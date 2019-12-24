package com.nwafu.accountloginmanagement.service;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;

import java.rmi.ServerException;

public interface SuperAdminLoginService {
    ResponseMessage<Integer> superUserLogin(String superUsername, String superPassword) throws ServerException;
    ResponseMessage<Integer> superUserExitLogin(String superUsername) throws ServerException;
    ResponseMessage<Integer> addSuperUserAccount(String superUsername, String superPassword) throws ServerException;
}
