package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoVO;
import com.nwafu.accountloginmanagement.service.NormalUserActionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 普通用户的账号方面的操作
 * @author: liu qinchang
 * @create: 2019-12-12 17:33
 **/

@RestController
@Slf4j
public class NormalUserActionController {

    @Autowired
    NormalUserActionService normalUserActionService;
    /**
     * @Description: 普通用户分配子用户
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2019/12/12
     */
    @PostMapping("/{normalUsername}/addSubAccount")
    public ResponseMessage addSubAccount(@RequestBody SubAccountInfoVO subAccountInfo, @PathVariable String normalUsername) throws ServerException {
        log.info("addSubAccount入参为:{}",subAccountInfo);
        if(subAccountInfo == null || subAccountInfo.getSubUsername() == null
            ||subAccountInfo.getSubPassword() == null || subAccountInfo.getParentUser() == null){
            throw new ServerException("传入参数不正确");
        }
        if(!normalUsername.equals(subAccountInfo.getParentUser())){
            throw new ServerException("normalUsername不一致");
        }
        ResponseMessage responseMessage = normalUserActionService.addSubAccount(subAccountInfo.getSubUsername(), subAccountInfo.getSubPassword(), subAccountInfo.getParentUser(), subAccountInfo.getPermissions().toString());

        return responseMessage;
    }

    /**
    * @Description: 普通用户删除子用户
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/17
    */
    @GetMapping("/{normalUsername}/deleteSubAccount")
    public ResponseMessage<Integer> deleteSubAccount(@RequestParam String username, @PathVariable(value = "normalUsername") String parentUser) throws ServerException {
        log.info("deleteSubAccount  入参  {},{}",username,parentUser);
        ResponseMessage<Integer> responseMessage = normalUserActionService.deleteSubAccount(username,parentUser);
        return responseMessage;
    }

}
