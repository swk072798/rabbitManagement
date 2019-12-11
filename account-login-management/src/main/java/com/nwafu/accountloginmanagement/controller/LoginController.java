package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/login")
    public ResponseMessage nornalUserLogin(@RequestParam(required = false) String username, @RequestParam(required = false) String password){
        log.info("入参：{},{}",username,password);
        NormalUserInfo normalUserInfo = normalUserLoginService.getUserInfo(username);
        ResponseMessage result = new ResponseMessage();
        result.setData(normalUserInfo);
        return result;
    }


}
