package com.springcloud.eurekaproduct1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        return "product-client-1 : hi! 11111";
    }
}
