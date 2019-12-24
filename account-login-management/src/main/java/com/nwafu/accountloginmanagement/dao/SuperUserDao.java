package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.SuperAdminInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SuperUserDao {
    SuperAdminInfo getSuperUserInfo(String superUsername);
    int updateSuperUserStatus(String status, String superUsername);
    int addSuperUserAccount(String superUsername, String superPassword);
    int updateNormalUserInfo(String oldNormalUsername, String newNormalUsername, String newPassword);
}
