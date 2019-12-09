package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

/**
 * @program: rabbitmanagement
 * @description: 普通用户映射类
 * @author: liu qinchang
 * @create: 2019-12-09 16:38
 **/

@Data
public class NormalUserInfo {
    private String username;
    private String password;
    private String farmUuids;
    private String status;
    private String registrationTime;
}
