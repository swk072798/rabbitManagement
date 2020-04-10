package com.nwafu.accountloginmanagement.entity;

import lombok.Data;


/**
 * @program: rabbitmanagement
 * @description: 子用户信息持久层交互类
 * @author: liu qinchang
 * @create: 2019-12-17 16:19
 **/

@Data
public class SubAccountInfoPO {
    private String subUsername;
    private String subPassword;
    private String parentUser;
    private String permissions;
    private String employeeNo;
    private String status;
}
