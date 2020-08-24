#### 1 eureka: 注册中心 <br>
> @SpringBootApplication
@EnableEurekaServer

<br><br>

#### 2 client: 生产者<br>
> @SpringBootApplication
  @EnableDiscoveryClient

<br><br>


#### 3 feign:  <br>
> @SpringBootApplication
  //@EnableEurekaClient 和 @EnableDiscoveryClient 都是让eureka发现该服务并注册到eureka上的注解
  //相同点：都能让注册中心Eureka发现，并将该服务注册到注册中心上；
  //不同点：@EnableEurekaClient只适用于Eureka作为注册中心，而@EnableDiscoveryClient可以是其他注册中心；
  @EnableEurekaClient
  //表示开启Fegin客户端
  @EnableFeignClients

<br>

>需要yml 配置 hystrix   使用接口(类似于clients的contrllers方法)调用clients(生产者)的contrllers对应的get post方法   
>如果失败 则对应实现该接口fallback类去返回数据
```yaml
# feign 熔断器
feign:
  hystrix:
    enabled: true
```
```java
@FeignClient(value = "product-client", fallback = FallBackService.class)
public interface FeignClientService {

    @RequestMapping(value = "/test/hi",method = RequestMethod.GET)
    String testHi();


    @RequestMapping(value = "/test/post",method = RequestMethod.POST)
    Object hello(@RequestBody Object serviceInfo);
}

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

```



#### 4 ribbon: <br>
> @SpringBootApplication
  @EnableDiscoveryClient
  @EnableHystrix

<br>

> 类似 feign 但他需要引入 ribbon 以及 Hystrix 并且需要自定义RestTemple 
在Controller层面直接使用RestTemplate的get post方法返回数据 需要在同类里定义fallback方法
```java
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

@SpringBootConfiguration
public class RestConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
```

#### 5 zuul 路由
> @SpringBootApplication
  @EnableDiscoveryClient
  @EnableZuulProxy

<br>

> 在yml中定义规则 不能直接访问clients（生产者）
```yaml
# zuul
zuul:
  routes:
    # 这里可以自定义
    zuultest:
      # 匹配的路由规则
      path: /zuultest/**
      # 路由的目标服务名
      serviceId: product-client

```

