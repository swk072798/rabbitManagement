package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 存放用户在redis中缓存的信息
 * @author: liu qinchang
 * @create: 2020-01-14 10:40
 **/

@Data
public class UserCacheInfo {
    private String username;
    private String permissions;
    private String parentUser;

    public UserCacheInfo(){}

    public UserCacheInfo(String username, String permissions, String parentUser){
        this.username = username;
        this.permissions = permissions;
        this.parentUser = parentUser;
    }
}
