package com.nwafu.accountloginmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AccountLoginManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountLoginManagementApplication.class, args);
	}

}
