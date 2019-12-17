package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserActionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Server;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 普通用户操作类
 * @author: liu qinchang
 * @create: 2019-12-17 15:48
 **/
@Service
@Slf4j
public class NormalUserActionServiceImpl implements NormalUserActionService {
    @Resource
    NormalUserDao normalUserDao;

    @Override
    public ResponseMessage<Integer> addSubAccount(String subUsername, String subPassword, String parentUser, String permissions) throws ServerException {
        int flag = 0;
        try{
            flag = normalUserDao.addSubAccount(subUsername,subPassword,parentUser);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(flag == 0){
            throw new ServerException("分配子用户失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("添加子用户成功",1);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> deleteSubAccount(String subUsername, String parentUser) throws ServerException {
        int flag = 0;
        try {
            flag = normalUserDao.deleteSubAccount(subUsername);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        if(flag == 0){
            throw new ServerException("删除账号失败");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage("success",1);
        return responseMessage;
    }


}
