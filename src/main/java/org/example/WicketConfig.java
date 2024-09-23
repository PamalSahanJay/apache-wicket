package org.example;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import static org.example.BceSpringBootServletInitializer.DEFAULT_URL_PATTERN;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WicketConfig {
    private static final String WICKET_FILTER_NAME = "wicket.audit";

    @Bean
    public FilterRegistrationBean wicketFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new WicketFilter());
        registration.addInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
        registration.addInitParameter(WicketFilter.FILTER_MAPPING_PARAM, DEFAULT_URL_PATTERN);
        registration.setName(WICKET_FILTER_NAME);
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        registration.setOrder(HttpFilterOrder.WICKET_FILTER.getOrder());
        return registration;
    }
}
