package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.accountloginmanagement.entity.SubAccountInfoPO;

import java.rmi.ServerException;
import java.util.List;

public interface NormalUserActionService {
    ResponseMessage addSubAccount(String subUsername, String subPassword, String parentUser, String permissions) throws ServerException;
    ResponseMessage deleteSubAccount(String subUsername, String parentUser) throws ServerException;
    ResponseMessage<Integer> updateSubUserPermissions(List<String> permissions, String subUsername) throws ServerException;
    ResponseMessage<List<SubAccountInfoPO>> getAllSubUserInfo(String parentUsername);
}
