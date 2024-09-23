package org.example;

import com.google.common.collect.ImmutableSet;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;


public class BceSpringBootUtils {
    private static final Logger LOG = LoggerFactory.getLogger(BceSpringBootUtils.class);
    public static void amendBeforeStart(SpringApplication application) {
//        removeLoggingApplicationListenerForEliminatingLoggingReinit(application);
        Set<String> alreadyExistedAdditionalProfiles = null;
        if (!application.getClass().getSimpleName().equals("BceSpringApplicationForTest")) {
            alreadyExistedAdditionalProfiles = new ImmutableSet.Builder<String>()
                    .add(BceProfile.SERVICE_PROFILE)
                    .add(BceProfile.TOMCAT_PROFILE)
                    .build();
        }
        amendProfiles(application, alreadyExistedAdditionalProfiles);
    }
    public static void amendProfiles(SpringApplication application, Set<String> alreadyExistedAdditionalProfiles) {
        Set<String> additionalProfiles = new HashSet<>();
        if (alreadyExistedAdditionalProfiles != null) {
            additionalProfiles.addAll(alreadyExistedAdditionalProfiles);
            additionalProfiles.add(BceProfile.APACHE_HTTP_CLIENT_PROFILE); // adding this profile as well
        }
        if (BceUtils.classExist("org.apache.http.impl.client.DefaultHttpClient")) {
            // this if will not work
            additionalProfiles.add(BceProfile.APACHE_HTTP_CLIENT_PROFILE);
        }
        if (BceUtils.classExist("net.sf.ehcache.CacheManager")) {
            additionalProfiles.add(BceProfile.EHCACHE_PROFILE);
        }
        if (!additionalProfiles.isEmpty()) {
            LOG.debug("Additional profiles {}", additionalProfiles);
            application.setAdditionalProfiles(additionalProfiles.toArray(new String[additionalProfiles.size()]));
        }
    }
}
