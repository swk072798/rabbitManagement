package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitmanagement
 * @description: 数据库配置信息类
 * @author: liu qinchang
 * @create: 2019-12-16 10:35
 **/
@Data
public class DatabaseInfo {
    private String dbName;
    private String owner;
    private String jdbcUrl;
    private String linkUsername;
    private String linkPassword;
    private String driverClassName;
}
