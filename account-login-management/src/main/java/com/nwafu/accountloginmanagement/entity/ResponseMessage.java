package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

/**
 * @program: rabbitmanagement
 * @description: 封装返回值给前端
 * @author: liu qinchang
 * @create: 2019-12-09 16:49
 **/

@Data
public class  ResponseMessage <T>{
    private String message;
    private T data;
}
