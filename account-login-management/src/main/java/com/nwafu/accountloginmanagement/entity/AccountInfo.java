package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 前端传来的账号信息的封装类
 * @author: liu qinchang
 * @create: 2019-12-12 16:16
 **/

@Data
public class AccountInfo {
    private String username;
    private String password;

}
