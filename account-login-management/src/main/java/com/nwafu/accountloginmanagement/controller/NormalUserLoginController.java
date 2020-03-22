package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.entity.AccountInfo;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 登录操作处理
 * @author: liu qinchang
 * @create: 2019-12-09 16:37
 **/

@RestController
@Slf4j
@Api(value = "普通用户登录类")
public class NormalUserLoginController {

    @Autowired
    NormalUserLoginService normalUserLoginService;

    /** 
    * @Description: 普通用户账号登录 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/12 
    */
    @ApiOperation(value = "普通用户账号登录")
    @GetMapping("/normalUser/login")
    public ResponseMessage normalUserLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password", required = false) String password) throws ServerException {
        log.info("normalUserLogin  入参：{},{}",username,password);
        if(username == null || password == null){
            throw new ServerException("用户名或密码不能为空");
        }
        ResponseMessage<NormalUserInfo> info = normalUserLoginService.normalUserLogin(username, password);
        return info;
    }

    /** 
    * @Description: 注册普通用户
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/12 
    */
    @ApiOperation(value = "普通用户注册")
    @PostMapping("/normalUser/register")
    public ResponseMessage<Integer> normalUserRegister(@RequestBody AccountInfo accountInfo) throws ServerException {
        log.info("normalUserRegister  入参为:{}",accountInfo);
        long startTime = System.currentTimeMillis();
        if(accountInfo == null || accountInfo.getUsername() == null || accountInfo.getPassword() == null){
            throw new ServerException("账号注册信息为空");
        }
        ResponseMessage<Integer> responseMessage = normalUserLoginService.addUserAccount(accountInfo.getUsername(),accountInfo.getPassword());
        log.info("normalUserRegister  执行时间： {} ms",System.currentTimeMillis() - startTime);
        return responseMessage;
    }
    
    /** 
    * @Description: 普通用户退出登录
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/17 
    */
    @ApiOperation(value = "普通用户退出登录")
    @GetMapping("/{normalUser}/normal/normalUserExitLogin")
    public ResponseMessage exitLogin(@PathVariable String normalUser) throws ServerException {
        if(normalUser == null || normalUser.length() == 0){
            throw new ServerException("exitLogin  用户名不能为空");
        }
       ResponseMessage responseMessage = normalUserLoginService.exitNormalUserLogin(normalUser);
        return responseMessage;
    }


}
