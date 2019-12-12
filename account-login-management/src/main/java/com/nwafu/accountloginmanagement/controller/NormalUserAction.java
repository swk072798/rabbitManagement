package com.nwafu.accountloginmanagement.controller;

import com.netflix.discovery.converters.Auto;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfo;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 普通用户的账号方面的操作
 * @author: liu qinchang
 * @create: 2019-12-12 17:33
 **/

@RestController
@Slf4j
public class NormalUserAction {

    @Autowired
    NormalUserLoginService normalUserLoginService;
    /**
     * @Description: 普通用户分配子用户
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2019/12/12
     */
    @PostMapping("/addSubAccount")
    public ResponseMessage addSubAccount(@RequestBody SubAccountInfo subAccountInfo) throws ServerException {
        log.info("addSubAccount入参为:{}",subAccountInfo);
        if(subAccountInfo == null || subAccountInfo.getSubUsername() == null
            ||subAccountInfo.getSubPassword() == null || subAccountInfo.getParentUser() == null){
            throw new ServerException("传入参数不正确");
        }
        ResponseMessage responseMessage = normalUserLoginService.addSubAccount(subAccountInfo.getSubUsername(), subAccountInfo.getSubPassword(), subAccountInfo.getParentUser());
        return responseMessage;
    }
}
