package com.xlccc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xlccc.common.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @Reference
    private HelloService helloService;

    @RequestMapping("/hello")
    public String Hello(){
        String hello = helloService.sayHello("world");
        System.out.println(helloService.sayHello("Link.p"));
        return hello;
    }
}
