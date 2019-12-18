package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

/**
 * @program: rabbitmanagement
 * @description: 超级用户映射类
 * @author: liu qinchang
 * @create: 2019-12-09 16:39
 **/

@Data
public class SuperAdminInfo {
    private String superUsername;
    private String superUserPassword;
    private String status;
}
