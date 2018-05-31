package com.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FeignClient注解中的值表示的是要访问/请求的目标服务的名称
 * fallback说明:该参数的指定熔断机制的处理实现.该参数中的类是本接口(实现熔断的接口)
 * 的实现类.当sayHiFromClientOne方法访问远程服务发生错误时,则会自动执行本接口的实现类下的
 * 实现方法,并返回该方法中的内容.
 * @author FaceFeel
 * @Created 2018-05-23 17:05
 **/
@FeignClient(value="service-hello",fallback = FeignServiceImpl.class)
public interface FeignService {

    /**
     * 请求映射中的value值指的是要请求服务的controller请求路径
     * @param name 传入参数
     * @return ""
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name")String name);
}
