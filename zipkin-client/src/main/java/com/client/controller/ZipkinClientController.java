package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author FaceFeel
 * @Created 2018-05-28 17:09
 **/
@RestController
public class ZipkinClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String callHome(){

        return restTemplate.getForObject("http://127.0.0.1:8769/miya",String.class);
    }

    @RequestMapping("/info")
    public String info(){
        return "I'm service zipkin-client!";
    }
}
