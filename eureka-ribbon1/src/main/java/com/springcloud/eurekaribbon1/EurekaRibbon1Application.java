package com.springcloud.eurekaribbon1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class EurekaRibbon1Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaRibbon1Application.class, args);
    }

}
