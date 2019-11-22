package com.notes.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserServerApplication {

    @Bean
    public RestTemplate restTemplate() { return new RestTemplate(); }

    public static void main(String[] args) {
        new SpringApplicationBuilder(UserServerApplication.class).web(WebApplicationType.SERVLET).run();
    }
}
