package com.nwafu.accountloginmanagement.controller;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SuperAdminInfo;
import com.nwafu.accountloginmanagement.service.SuperAdminLoginService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 超级用户登录类
 * @author: liu qinchang
 * @create: 2019-12-19 13:59
 **/

@RestController
@Slf4j
public class SuperUserLoginController {

    @Autowired
    SuperAdminLoginService superAdminLoginService;
    /**
    * @Description: 超级用户登录
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/19
    */
    @GetMapping("/superUser/login")
    public ResponseMessage<Integer> superUserLogin(@RequestParam String superUsername, @RequestParam String superPassword) throws ServerException {
        log.info("superUserLogin  传入参数: {}, {}", superUsername, superPassword);
        if(superUsername == null || superPassword == null){
            throw new ServerException("superUserLogin  传入参数不正确");
        }
        ResponseMessage<Integer> responseMessage = superAdminLoginService.superUserLogin(superUsername, superPassword);
        return responseMessage;
    }
    
    /** 
    * @Description: 超级用户退出登录
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2019/12/19 
    */
    @GetMapping("/{superUsername}/super/exitLogin")
    public ResponseMessage<Integer> superUseEexitLogin(@PathVariable String superUsername) throws ServerException {
        log.info("superUseEexitLogin  传入参数: {}",superUsername);
        if(superUsername == null){
            throw new ServerException("superUseEexitLogin  传入参数不正确");
        }
        ResponseMessage responseMessage = superAdminLoginService.superUserExitLogin(superUsername);
        return responseMessage;
    }

    /**
    * @Description: 添加超级用户账号
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/19
    */
    @PostMapping("/superUser/register")
    public ResponseMessage<Integer> addSuperUserAccount(@RequestBody SuperAdminInfo superAdminInfo) throws ServerException {
        log.info("addSuperUserAccount  入参为: {}",superAdminInfo);
        if(superAdminInfo == null || superAdminInfo.getSuperUsername() == null || superAdminInfo.getSuperPassword() == null){
            throw new ServerException("addSuperUserAccount  入参错误");
        }
        ResponseMessage responseMessage = superAdminLoginService.addSuperUserAccount(superAdminInfo.getSuperUsername(), superAdminInfo.getSuperPassword());
        return responseMessage;
    }
}
