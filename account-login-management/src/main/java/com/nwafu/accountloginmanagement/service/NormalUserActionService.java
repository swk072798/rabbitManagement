package com.nwafu.accountloginmanagement.service;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;


import java.util.List;

public interface NormalUserActionService {
    ResponseMessage addSubAccount(String subUsername, String subPassword, String parentUser, String permissions);
    ResponseMessage deleteSubAccount(String subUsername, String parentUser);
    ResponseMessage<Integer> updateSubUserPermissions(String permissions, String subUsername);
    ResponseMessage<List<SubAccountInfoPO>> getAllSubUserInfo(String parentUsername);
}
