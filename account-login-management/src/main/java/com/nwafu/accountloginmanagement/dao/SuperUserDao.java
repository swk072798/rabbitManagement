package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.NormalUserInfo;
import com.nwafu.accountloginmanagement.entity.SuperAdminInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuperUserDao {
    SuperAdminInfo getSuperUserInfo(String superUsername);
    int updateSuperUserStatus(String status, String superUsername);
    int addSuperUserAccount(String superUsername, String superPassword);
    int updateNormalUserInfo(String oldNormalUsername, String newNormalUsername, String newPassword);
    int deleteNormalUserInfo(String username);
    int deleteDatabase(String dbName);
    int deleteDatabaseInfo(String dbName);
    List<NormalUserInfo> getAllNormalUserInfo();
    int deleteSubUserByParentUser(String parentUser);
}
