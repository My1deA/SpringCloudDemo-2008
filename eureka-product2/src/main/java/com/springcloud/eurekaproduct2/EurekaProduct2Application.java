package com.springcloud.eurekaproduct2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaProduct2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProduct2Application.class, args);
    }

}
