package com.bus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FaceFeel
 * @Created 2018-05-25 15:38
 **/
@RestController
@RefreshScope
public class BusClientController {

    @Value("${foo}")
    String foo;

    @RequestMapping("/hi")
    public String foo() {
        return foo;
    }
}
