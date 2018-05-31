package com.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FaceFeel
 * @Created 2018-05-23 10:52
 **/
@RestController
public class LucyClientController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "Hello Eureka " + name;
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
