package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.rmi.ServerException;


/**
 * @program: rabbitmanagement
 * @description: 普通用户登录操作service层
 * @author: liu qinchang
 * @create: 2019-12-09 17:18
 **/

@Service
@Slf4j
public class NormalUserLoginServiceImpl implements NormalUserLoginService {
    @Resource
    NormalUserDao normalUserDao;

    @Override
    public ResponseMessage<NormalUserInfo> getUserInfo(String username) throws ServerException {
        log.info("{}",username);
        NormalUserInfo info = normalUserDao.getNormalUserInfoByUsername(username);
        log.info("查询结果:{}",info);
        if (info == null){
            throw new ServerException("未找到相关账号信息");
        }
        ResponseMessage result = new ResponseMessage();
        result.setData(info);
        return result;
    }

    @Override
    public ResponseMessage<Integer> addUserAccount(String username, String password) throws ServerException {
        int flag = 0;
        try{
            flag = normalUserDao.addAccount(username,password);
        } catch (Exception e){
            log.info(e.getMessage());
        }
        if(flag == 0){
            throw new ServerException("添加账号失败");
        }
        ResponseMessage responseMessage = new ResponseMessage("注册成功",1);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addSubAccount(String subUsername, String subPassword, String parentUser) throws ServerException {
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


}
