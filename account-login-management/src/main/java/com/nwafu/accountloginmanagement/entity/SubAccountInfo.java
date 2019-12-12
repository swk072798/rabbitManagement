package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

/**
 * @program: rabbitmanagement
 * @description: 前端提交的子用户信息类
 * @author: liu qinchang
 * @create: 2019-12-12 17:30
 **/

@Data
public class SubAccountInfo {
    private String subUsername;
    private String subPassword;
    private String parentUser;
}
