package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;


public interface SubUserLoginService {
    ResponseMessage<Integer> subUserLogin(String username, String password);
    ResponseMessage<Integer> exitSubUserLogin(String subUsername);
}
