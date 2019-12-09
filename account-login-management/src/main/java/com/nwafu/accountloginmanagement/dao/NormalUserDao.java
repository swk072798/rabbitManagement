package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;

/**
 * @program: rabbitmanagement
 * @description: 普通用户的数据库操作
 * @author: liu qinchang
 * @create: 2019-12-09 17:16
 **/
public interface NormalUserDao {
    NormalUserInfo getNormalUserInfoByUsername(String username);
}
