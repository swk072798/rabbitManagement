package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.SubUserDao;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import com.nwafu.accountloginmanagement.service.SubUserLoginService;
import org.apache.catalina.Server;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 子用户登录实现类
 * @author: liu qinchang
 * @create: 2019-12-17 16:13
 **/
public class SubUserLoginServiceImpl implements SubUserLoginService {

    @Resource
    SubUserDao subUserDao;


    @Override
    public ResponseMessage<Integer> subUserLogin(String username, String password) throws ServerException {
        SubAccountInfoPO subAccountInfoPO = subUserDao.subUserLogin(username);
        if(!DigestUtils.md5DigestAsHex(password.getBytes()).equals(subAccountInfoPO.getSubPassword())){
            throw new ServerException("账号密码错误");
        }
        ResponseMessage<Integer> responseMessage = new ResponseMessage<>("success");
        return responseMessage;
    }
}
