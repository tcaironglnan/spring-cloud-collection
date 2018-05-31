package com.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FaceFeel
 * @Created 2018-05-30 14:05
 **/
@RestController
public class ConsulController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/hi")
    public String home() {
        return "hi ,i'm miya";
    }

    //健康检查的实现REST部分
    @RequestMapping("/health")
    public String health() {
        return "hello health ";
    }
}
