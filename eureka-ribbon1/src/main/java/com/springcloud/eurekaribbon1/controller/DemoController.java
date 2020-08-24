package com.springcloud.eurekaribbon1.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/ribbon")
    @HystrixCommand(fallbackMethod ="ribbonFallBack" )
    public String ribbon(){
        String result=restTemplate.getForObject("http://product-client/test/hi",String.class);
        //restTemplate.postForObject("http://springbootService/service/rest?token=1", serviceInfo, String.class)
        return result;
    }

    public String ribbonFallBack(){
        return "service error ribbon";
    }

}
