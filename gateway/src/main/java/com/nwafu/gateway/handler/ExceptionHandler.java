package com.nwafu.gateway.handler;

import com.nwafu.gateway.classes.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @program: rabbitmanagement
 * @description: 拦截器
 * @author: liu qinchang
 * @create: 2019-12-12 14:46
 **/

@RestControllerAdvice("com.nwafu.databaseoprations.controller")
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public ResponseMessage handException(RuntimeException re){
        log.error("服务调用异常：{}",re.getMessage());
        ResponseMessage result = new ResponseMessage(re.getMessage(), -1);
        return result;
    }
}
