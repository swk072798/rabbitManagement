package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: rabbitmanagement
 * @description: 普通用户的数据库操作
 * @author: liu qinchang
 * @create: 2019-12-09 17:16
 **/

@Mapper
public interface NormalUserDao {
    NormalUserInfo getNormalUserInfoByUsername(String username);
    int addAccount(String username,String password);
    int addSubAccount(String subUsername, String subPassword, String parentUser);
    int createDatabase(String dbName);
    int updataLoginStatus(String newStatus, String username);
}
