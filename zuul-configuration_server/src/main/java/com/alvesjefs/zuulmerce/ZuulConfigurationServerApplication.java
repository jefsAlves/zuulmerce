package com.alvesjefs.zuulmerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ZuulConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulConfigurationServerApplication.class, args);
	}

}
