package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"org.example.*","org.openapi.example.*"})
public class AppConfiguration implements WebMvcConfigurer {
}
