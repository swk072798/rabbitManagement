package com.nwafu.accountloginmanagement.service.impl;

import com.nwafu.accountloginmanagement.dao.NormalUserDao;
import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.service.NormalUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: rabbitmanagement
 * @description: 普通用户登录操作service层
 * @author: liu qinchang
 * @create: 2019-12-09 17:18
 **/

@Service
@Slf4j
public class NormalUserLoginServiceImpl implements NormalUserLoginService {

    NormalUserDao normalUserDao;

    @Override
    public NormalUserInfo getUserInfo(String username) {
        NormalUserInfo result = normalUserDao.getNormalUserInfoByUsername(username);
        return result;
    }
}
