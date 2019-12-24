package com.nwafu.accountloginmanagement.entity;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 返回给前端的普通用户信息类
 * @author: liu qinchang
 * @create: 2019-12-24 11:49
 **/

@Data
public class NormalUserVO {
    private String username;
    private List<String> farmUuids;
    private String status;
    private String registrationTime;

    public NormalUserVO(){}

    public NormalUserVO(NormalUserInfo normalUserInfo){
        this.username = normalUserInfo.getUsername();
        this.farmUuids = Arrays.asList(normalUserInfo.getFarmUuids());
        this.status = normalUserInfo.getStatus();
        this.registrationTime = normalUserInfo.getRegistrationTime();
    }
}
