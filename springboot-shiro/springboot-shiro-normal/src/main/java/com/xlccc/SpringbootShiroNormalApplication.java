package com.xlccc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xlccc.mapper")
public class SpringbootShiroNormalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroNormalApplication.class, args);
    }

}
