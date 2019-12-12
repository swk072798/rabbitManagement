package com.nwafu.accountloginmanagement.config;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @program: rabbitmanagement
 * @description: spring-security配置类
 * @author: liu qinchang
 * @create: 2019-12-06 17:34
 **/

@Configuration
@EnableEurekaClient
public class SecurityConfig  {
//    @Override
//    public void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("/login/").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().permitAll();
//    }
}
