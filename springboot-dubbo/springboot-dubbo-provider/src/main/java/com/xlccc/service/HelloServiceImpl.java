package com.xlccc.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xlccc.common.service.HelloService;
import org.springframework.stereotype.Component;

@Service
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
