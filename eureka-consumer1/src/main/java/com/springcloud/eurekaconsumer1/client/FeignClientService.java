package com.springcloud.eurekaconsumer1.client;

import com.springcloud.eurekaconsumer1.client.fallback.FallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "product-client", fallback = FallBackService.class)
public interface FeignClientService {

    @RequestMapping(value = "/test/hi",method = RequestMethod.GET)
    String testHi();


    @RequestMapping(value = "/test/post",method = RequestMethod.POST)
    Object hello(@RequestBody Object serviceInfo);
}
