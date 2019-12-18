package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface SubUserLoginService {
    ResponseMessage<Integer> subUserLogin(String username, String password) throws ServerException;
    ResponseMessage<Integer> exitSubUserLogin(String subUsername) throws ServerException;
}
