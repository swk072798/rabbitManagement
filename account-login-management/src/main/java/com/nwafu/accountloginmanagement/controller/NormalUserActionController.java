package com.nwafu.accountloginmanagement.controller;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoVO;
import com.nwafu.accountloginmanagement.service.NormalUserActionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 普通用户的账号方面的操作
 * @author: liu qinchang
 * @create: 2019-12-12 17:33
 **/

@RestController
@Slf4j
@Api(value = "普通用户账号操作")
public class NormalUserActionController {

    @Autowired
    NormalUserActionService normalUserActionService;
    /**
     * @Description: 普通用户创建子用户
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2019/12/12
     */
    @ApiOperation(value = "创建子用户")
    @PostMapping("/{normalUsername}/normal/addSubAccount")
    public ResponseMessage addSubAccount(@RequestBody SubAccountInfoVO subAccountInfo, @PathVariable String normalUsername) throws ServerException {
        log.info("addSubAccount入参为:{}",subAccountInfo);
        if(subAccountInfo == null || subAccountInfo.getSubUsername() == null
            ||subAccountInfo.getSubPassword() == null || subAccountInfo.getParentUser() == null){
            throw new ServerException("传入参数不正确");
        }
        if(!normalUsername.equals(subAccountInfo.getParentUser())){
            throw new ServerException("normalUsername不一致");
        }
        String securityPassword = DigestUtils.md5DigestAsHex(subAccountInfo.getSubPassword().getBytes());
        ResponseMessage responseMessage = normalUserActionService.addSubAccount(subAccountInfo.getSubUsername(), securityPassword, subAccountInfo.getParentUser(), subAccountInfo.getPermissions().toString());

        return responseMessage;
    }

    /**
    * @Description: 普通用户删除子用户
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/17
    */
    @ApiOperation(value = "删除子用户")
    @GetMapping("/{normalUsername}/normal/deleteSubAccount")
    public ResponseMessage<Integer> deleteSubAccount(@RequestParam String username, @PathVariable(value = "normalUsername") String parentUser) throws ServerException {
        log.info("deleteSubAccount  入参  {},{}",username,parentUser);
        if(username == null || parentUser == null){
            throw new ServerException("删除子用户参数不能为空");
        }
        ResponseMessage<Integer> responseMessage = normalUserActionService.deleteSubAccount(username,parentUser);
        return responseMessage;
    }


    /**
    * @Description: 普通用户给子用户分配权限
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/18
    */
    @ApiOperation(value = "普通用户给子用户分配权限")
    @PostMapping("/{normalUsername}/normal/updateSubPermissions")
    public ResponseMessage<Integer> addSubPermissions(@RequestParam String permissions, @RequestParam String subUsername, @PathVariable String normalUsername) throws ServerException {
        log.info("addSubPermissions  入参: {}, {}",permissions, normalUsername);
        if(subUsername == null){
            throw new ServerException("分配权限参数不能为空");
        }
        ResponseMessage<Integer> responseMessage = normalUserActionService.updateSubUserPermissions(permissions,subUsername);
        return responseMessage;
    }

    /**
    * @Description: 查询分配的所有子用户
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/18
    */
    @ApiOperation(value = "获取所有子用户信息")
    @GetMapping("/{normalUsername}/normal/getAllSubUserInfo")
    public ResponseMessage<List<SubAccountInfoPO>> getAllSubUserInfo(@PathVariable String normalUsername) throws ServerException {
        log.info("getAllSubUserInfo  传入参数： {}", normalUsername);
        long startTime = System.currentTimeMillis();
        if(normalUsername == null){
            throw new ServerException("normalUsername 不能为空");
        }
        ResponseMessage<List<SubAccountInfoPO>> responseMessage = normalUserActionService.getAllSubUserInfo(normalUsername);
        log.info("getAllSubUserInfo 执行时间: {} ms",System.currentTimeMillis() - startTime);
        return responseMessage;
    }
}
