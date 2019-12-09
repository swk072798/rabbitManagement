package com.nwafu.rabbiteureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RabbitEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitEurekaApplication.class, args);
	}

}
