package com.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author FaceFeel
 * @Created 2018-05-23 14:18
 **/
@Service("helloService")
public class ZipkinHelloServiceImpl implements ZipkinHelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 第一个注解表示的是:为该方法创建了熔断机制/功能
     * 请求远程服务方法
     *
     * @param name 传入参数
     * @return ""
     */
    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public String hiService(String name) {

//        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name=" + name, String.class);
        return restTemplate.getForObject("http://SERVICE-HELLO/hi?name=" + name, String.class);
    }

    /**
     * 该方法是hiService方法上的@HystrixCommand(fallbackMethod = "hiError")
     * 注解中的回调方法,这是熔断的处理机制
     * @param name ""
     * @return ""
     */
    public String hiError(String name) {
        return "hi " + name + ",sorry, error !";
    }
}
