package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface SuperUserActionService {
    ResponseMessage<Integer> updateNornalUserInfo(String oldUserName, String newUserName, String newPassword) throws ServerException;
    ResponseMessage<Integer> deleteNormalUserInfo(String username);
}
