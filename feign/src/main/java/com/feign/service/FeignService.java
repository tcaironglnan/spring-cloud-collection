package com.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient注解中的值表示的是要访问/请求的目标服务的名称
 * @author FaceFeel
 * @Created 2018-05-23 17:05
 **/
@FeignClient(value="service-hello")
public interface FeignService {

    /**
     * 请求映射中的value值指的是要请求服务的controller请求路径
     * @param name 传入参数
     * @return ""
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name")String name);
}
