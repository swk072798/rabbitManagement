package com.nwafu.databaseoprations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})       //禁用数据源自动配置
@ComponentScan(basePackages = "com.nwafu.databaseoprations.config")
public class DatabaseOprationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseOprationsApplication.class, args);
    }

}
