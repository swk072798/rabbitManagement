package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubUserDao {
    SubAccountInfoPO subUserLogin(String username);
    int updateSubUserStatus(String status, String subUsername);
}
