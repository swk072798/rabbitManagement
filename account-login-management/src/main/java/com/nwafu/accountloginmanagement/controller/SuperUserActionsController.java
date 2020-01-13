package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.entity.NormalUserVO;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.SuperUserActionService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 超级用户操作
 * @author: liu qinchang
 * @create: 2019-12-24 09:59
 **/

@RestController
@Slf4j
public class SuperUserActionsController {

    @Autowired
    SuperUserActionService superUserActionService;

    @GetMapping("/{superUsername}/super/updateNormalUserInfo")
    public ResponseMessage<Integer> updateNormalUserInfo(@PathVariable String superUsername, @RequestParam String oldNormalUsername,
                                                         @RequestParam(required = false) String newNormalUsername, @RequestParam(required = false) String newPassword) throws ServerException {
        log.info("updateNormalUserInfo  入参:  {},{},{},{}",superUsername,oldNormalUsername,newNormalUsername,newPassword);
        ResponseMessage<Integer> responseMessage = superUserActionService.updateNornalUserInfo(oldNormalUsername,newNormalUsername,newPassword);
        return responseMessage;
    }

    @GetMapping("/{superUsername}/super/deleteNormalUserInfo")
    public ResponseMessage<Integer> deleteNormalUserInfo(@PathVariable String superUsername, @RequestParam String username){
        log.info("deleteNormalUserInfo  入参: {},{}",superUsername, username);
        long starTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage= superUserActionService.deleteNormalUserInfo(username);
        log.info("deleteNormalUserInfo 执行时间：{} ms", System.currentTimeMillis() - starTime);
        return responseMessage;
    }

    @GetMapping("/{superUsername}/super/getAllNormalUserInfo")
    public ResponseMessage<List<NormalUserVO>> getAllNormalUserInfo(@PathVariable String superUsername){
        log.info("getAllNormalUserInfo  传入参数:  {}",superUsername);
        ResponseMessage<List<NormalUserVO>> responseMessage = superUserActionService.getAllNormalUserInfo();
        log.info("getAllNormalUserInfo  执行成功，查询总数： {}",responseMessage.getData().size());
        return responseMessage;
    }
}
