package com.xlccc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 本地Redis默认密码为admin
 */
@SpringBootApplication
public class SpringbootFirstRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFirstRedisApplication.class, args);
	}

}
