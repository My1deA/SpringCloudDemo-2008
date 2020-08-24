package com.springcloud.eurekaproduct2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        return "product-client-2 : hi! 22222";
    }
}
