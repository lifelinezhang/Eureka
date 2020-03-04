package com.zhang.springcloud;

import com.zhang.myrule.ZhangRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


// ribbon和eureka整合之后，客户端可以直接通过服务名调用，不用关心ip地址和端口号
@SpringBootApplication
@EnableEurekaClient
// 对name为SPRINGCLOUD-PROVIDER-DEPT的服务端做ZhangRule.java类中自定义的负载均衡策略。
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = ZhangRule.class)
public class DeptConsumer_8080 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_8080.class, args);
    }
}


// 在没有负载均衡的情况下，需要直接写ip和端口
// 在有负载均衡的情况下，调用远程服务有两种方法：
/**
 * 1、使用ribbon，配置对远程哪个服务实现负载均衡，并且不能有具体的ip和端口，只能用服务名，不然怎么做负载均衡？
 * 2、使用feign，feign包含了ribbon，没有显式地配置负载均衡，并且使其调用远程的写法类似于mybatis
 */
