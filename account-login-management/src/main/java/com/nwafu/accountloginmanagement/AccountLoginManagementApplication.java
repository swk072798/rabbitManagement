package com.nwafu.accountloginmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.nwafu.accountloginmanagement.dao")
@EnableTransactionManagement		//支持事务回滚操作
public class AccountLoginManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountLoginManagementApplication.class, args);
	}

}
