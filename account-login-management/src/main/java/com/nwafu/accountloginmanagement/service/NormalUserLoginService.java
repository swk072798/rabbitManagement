package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface NormalUserLoginService {
    ResponseMessage getUserInfo(String username) throws ServerException;
}
