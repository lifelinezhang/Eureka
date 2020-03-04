package com.zhang.springcloud.config;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {


    // 配置负载均衡实现RestTemplate，因为请求是通过RestTemplate实现的，所以这个类负载均衡就可以了
    @Bean
    @LoadBalanced  // 实现负载均衡 ribbon的作用，默认轮询
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }



}
