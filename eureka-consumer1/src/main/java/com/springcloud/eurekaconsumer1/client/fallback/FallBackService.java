package com.springcloud.eurekaconsumer1.client.fallback;

import com.springcloud.eurekaconsumer1.client.FeignClientService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FallBackService implements FeignClientService {
    @Override
    public String testHi() {
        return "Service error";
    }

    @Override
    public Object hello(Object serviceInfo) {
        return null;
    }
}
