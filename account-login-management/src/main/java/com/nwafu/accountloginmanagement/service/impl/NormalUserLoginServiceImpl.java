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
    public ResponseMessage getUserInfo(String username) throws ServerException {
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
}
