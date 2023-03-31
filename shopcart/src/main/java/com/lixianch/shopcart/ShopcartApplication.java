package com.lixianch.shopcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * created by lixianch on 2023/3/31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ShopcartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopcartApplication.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
