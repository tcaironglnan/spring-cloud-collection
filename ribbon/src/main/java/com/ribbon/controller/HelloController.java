package com.ribbon.controller;

import com.ribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author FaceFeel
 * @Created 2018-05-23 14:20
 **/
@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("hi")
    @ResponseBody
    public String hi(@RequestParam String name) {

        return helloService.hiService(name);
    }
}
