package com.zhang.springcloud.controller;

import com.zhang.springcloud.pojo.Dept;
import com.zhang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 提供restful服务
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    // 这个地方组装的是EurekaDiscoveryClient,可以从注册中心获取一些信息
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/getAll")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }

    // 注册进来的微服务：获取一些消息
    @GetMapping("/discovery")
    public Object discovery() {
        // 获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("discovery => services：" + services);

        // 得到一个具体的微服务信息, 通过具体的微服务id：applicationName
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        instances.forEach(e -> {
            System.out.println(e.getHost() + "\t" +
                    e.getPort() + "\t" +
                    e.getUri()+ "\t" +
                    e.getServiceId()+ "\t");
        });
        return instances;
    }
}
