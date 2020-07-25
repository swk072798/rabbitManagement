package com.nwafu.accountloginmanagement.config;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 读取redis的配置类，如要修改端口，在这里修改
 * @author: liu qinchang
 * @create: 2020-01-14 10:59
 **/
@Data

public class RedisConf {

    private String server = "localhost";

    private String port = "6379";
}
