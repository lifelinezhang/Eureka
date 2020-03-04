package com.zhang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZhangRule {

    // 自定义负载均衡算法
    // IRule
    // AvailabilityFilteringRule: 会先过滤掉跳闸、访问故障的服务，对剩下的进行轮询
    // RoundRobinRule 轮询
    // RandomRule 随机
    // RetryRule 会先按照轮询获取服务，如果服务获取失败，则会在指定时间内进行重试
//    @Bean
//    public IRule myRule() {
//        return new RandomRule();
//    }

    // 现在调用自己的
    @Bean
    public IRule myRule() {
        return new ZhangRandomRule();
    }

}
