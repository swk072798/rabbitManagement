package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
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
public class LoginController {

    @Autowired
    NormalUserLoginService normalUserLoginService;

    @RequestMapping("/login")
    public ResponseMessage nornalUserLogin(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password) throws ServerException {
        log.info("入参：{},{}",username,password);
        ResponseMessage<NormalUserInfo> info = normalUserLoginService.getUserInfo(username);
        if(!info.getData().getPassword().equals(password)){
            throw new ServerException("用户名或密码错误");
        }
        ResponseMessage result = new ResponseMessage("登录成功");
        return result;
    }


}
