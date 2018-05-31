package com.feign.controller;

import com.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动注入的FeignService接口会报错(安装检测插件的情况下才能看到),
 * 即:提示不能自动注入,没有Bean的名字叫FeignService
 * 但这不影响使用,因为该接口没有实现类,而是直接使用接口实现外部访问.
 * @author FaceFeel
 * @Created 2018-05-23 17:05
 **/
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHiFromClientOne(@RequestParam(value = "name") String name){

        return feignService.sayHiFromClientOne(name);
    }
}
