package com.nwafu.accountloginmanagement.service;


import com.nwafu.accountloginmanagement.entity.ResponseMessage;

public interface SuperAdminLoginService {
    ResponseMessage<Integer> superUserLogin(String superUsername, String superPassword);
    ResponseMessage<Integer> superUserExitLogin(String superUsername);
    ResponseMessage<Integer> addSuperUserAccount(String superUsername, String superPassword);
}
