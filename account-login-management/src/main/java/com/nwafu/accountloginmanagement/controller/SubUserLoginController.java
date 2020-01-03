package com.nwafu.accountloginmanagement.controller;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.SubUserLoginService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 子用户登录模块
 * @author: liu qinchang
 * @create: 2019-12-17 15:40
 **/

@RestController
@Slf4j
public class SubUserLoginController {

    @Resource
    SubUserLoginService subUserLoginService;

    /** 
    * @Description: 子用户登录类
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @GetMapping("/subUser/login")
    public ResponseMessage<Integer> subUserLogin(@RequestParam String subUsername, @RequestParam String subPassword) throws ServerException {
        log.info("subUserLogin   传入参数：{}, {}",subUsername, subPassword);
        if(subUsername == null || subUsername.length() == 0 || subPassword == null || subPassword.length() == 0){
            throw new ServerException("subUserLogin 传入参数有误");
        }
        ResponseMessage<Integer> responseMessage = subUserLoginService.subUserLogin(subUsername,subPassword);
        return responseMessage;
    }
    
    /** 
    * @Description: 子用户退出登录
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/18 
    */
    @GetMapping("/{subUsername}/sub/subUserExitlogin")
    public ResponseMessage<Integer> exitSubUserLogin(@PathVariable String subUsername) throws ServerException {
        log.info("exitSubUserLogin 入参: {}",subUsername);
        ResponseMessage responseMessage = subUserLoginService.exitSubUserLogin(subUsername);
        return responseMessage;
    }
}
