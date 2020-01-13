package com.nwafu.accountloginmanagement.service;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;

public interface NormalUserLoginService {
    ResponseMessage normalUserLogin(String username, String password);
    ResponseMessage addUserAccount(String username, String password);
    ResponseMessage exitNormalUserLogin(String username);
}
