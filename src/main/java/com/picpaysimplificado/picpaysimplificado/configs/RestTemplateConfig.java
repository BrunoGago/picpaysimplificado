package com.picpaysimplificado.picpaysimplificado.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {

    static final int TIMEOUT = 5000; // TimeOut of 5000 milissegundos (5 seconds)

    // RestTemplate: used to make external requests, creating synchronous communications
    // The method below is "reproducer" which returns the RestTemplate
//    @LoadBalanced // using Spring Cloud load balancing.
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
//                .setConnectTimeout(Duration.ofMillis(TIMEOUT))//time limit for connection
//                .setReadTimeout(Duration.ofMillis(TIMEOUT))//time limit for reading
                .build();
    }

}
