package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        PropertyPlaceholderAutoConfiguration.class,
        ServletWebServerFactoryAutoConfiguration.class
})
@ComponentScan
public class Main extends BceSpringBootServletInitializer {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication application = new SpringApplicationBuilder()
                .sources(Main.class)
                .build();
        BceSpringBootUtils.amendBeforeStart(application);
        application.run(args);

    }
}