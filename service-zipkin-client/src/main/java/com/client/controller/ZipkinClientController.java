package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author FaceFeel
 * @Created 2018-05-29 9:49
 **/
@RestController
public class ZipkinClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hiclient")
    public String callHome(){
        try {
            return restTemplate.getForObject("http://127.0.0.1:8769/hi",String.class);
        }catch (Exception e){
            e.printStackTrace();
            return "callHome is exception!";
        }
    }

    @RequestMapping("/info")
    public String info(){

        return "I'm service - hi!";
    }
}
