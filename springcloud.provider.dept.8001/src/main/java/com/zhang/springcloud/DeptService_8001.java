package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient  // 在服务启动后自动注册到eureka中
@EnableDiscoveryClient // 服务发现
public class DeptService_8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptService_8001.class, args);
    }

}
