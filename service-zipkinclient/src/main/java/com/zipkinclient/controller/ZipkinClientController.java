package com.zipkinclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author FaceFeel
 * @Created 2018-05-29 9:30
 **/
@RestController
public class ZipkinClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home() {

        return "hi ! I'm miya";
    }

    @RequestMapping("/miya")
    public String info() {

        try {
            return restTemplate.getForObject("http://127.0.0.1:8768/info", String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }
    }
}
