package com.feign.service;

import org.springframework.stereotype.Component;

/**
 * 该实现类主要的作用是为了实现Feign的熔断机制,如果访问出错,则
 * 直接返回该实现类的实现方法中的内容.
 * @author FaceFeel
 * @Created 2018-05-24 13:41
 **/
@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
