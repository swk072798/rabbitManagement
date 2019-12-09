package com.nwafu.accountloginmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: rabbitmanagement
 * @description: 登录操作处理
 * @author: liu qinchang
 * @create: 2019-12-09 16:37
 **/

@RestController
public class LoginController {

    @GetMapping("/login")
    public void nornalUserLogin(String username, String password){

    }


}
