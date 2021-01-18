package com.alvesjefs.zuulmerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ZuulMsOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulMsOauthApplication.class, args);
	}

}
