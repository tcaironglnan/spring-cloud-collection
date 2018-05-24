package com.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author FaceFeel
 * @Created 2018-05-23 14:18
 **/
@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @param name
     * @return
     */
    @Override
    public String hiService(String name) {

//        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name=" + name, String.class);
        return restTemplate.getForObject("http://SERVICE-HELLO/hi?name=" + name, String.class);
    }
}
