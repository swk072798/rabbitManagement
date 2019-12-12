package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface NormalUserLoginService {
    ResponseMessage getUserInfo(String username) throws ServerException;
    ResponseMessage addUserAccount(String username, String password) throws ServerException;
    ResponseMessage addSubAccount(String subUsername, String subPassword, String parentUser) throws ServerException;
}
