package com.daka.core.config;

import com.daka.core.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: zjt
 * @date: 2019-04-24 21:12
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new TokenFilter());
        registration.addUrlPatterns("/daka/*");
        registration.setName("tokenFilter");
        registration.setOrder(1);
        return registration;
    }
}