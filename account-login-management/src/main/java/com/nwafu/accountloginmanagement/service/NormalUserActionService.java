package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface NormalUserActionService {
    ResponseMessage addSubAccount(String subUsername, String subPassword, String parentUser, String permissions) throws ServerException;
    ResponseMessage deleteSubAccount(String subUsername, String parentUser) throws ServerException;
}
