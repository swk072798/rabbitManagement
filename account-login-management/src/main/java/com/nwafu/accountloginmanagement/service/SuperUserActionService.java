package com.nwafu.accountloginmanagement.service;

public interface SuperUserActionService {
    int updateNornalUserInfo(String oldUserName, String newUserName, String newPassword);
}
