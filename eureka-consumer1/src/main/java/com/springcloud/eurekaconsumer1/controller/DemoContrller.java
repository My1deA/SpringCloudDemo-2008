package com.springcloud.eurekaconsumer1.controller;

import com.springcloud.eurekaconsumer1.client.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoContrller {

    @Autowired
    FeignClientService feignClientService;

    @RequestMapping("/hi")
    public String hi(){
        return feignClientService.testHi();
    }
}
