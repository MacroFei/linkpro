package com.xlccc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Linkp
 * @Date 2020/1/18 4:27 PM
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello (){
        return "Hello world!";
    }
}
