package com.example.asteriskserver.FeignClients.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by  :  erakhmanberdiev
 * created date & time: 04.08.2023  17:13
 */

@Configuration
public class FeignClientDefaultConfiguration {

    @Value("${feignClient.username}")
    private String username;

    @Value("${feignClient.password}")
    private String password;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(username, password);
    }
}