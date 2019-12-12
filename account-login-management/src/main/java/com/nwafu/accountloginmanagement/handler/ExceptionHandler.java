package com.nwafu.accountloginmanagement.handler;

import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.ServerException;

/**
 * @program: rabbitmanagement
 * @description: 拦截器
 * @author: liu qinchang
 * @create: 2019-12-12 14:46
 **/

@RestControllerAdvice("com.nwafu.accountloginmanagement.controller")
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServerException.class)
    public ResponseMessage handException(ServerException se){
        log.error("服务调用异常：{}",se.getMessage());
        ResponseMessage result = new ResponseMessage(se.getMessage());
        return result;
    }
}
