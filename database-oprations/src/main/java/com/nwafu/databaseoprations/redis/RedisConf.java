package com.nwafu.databaseoprations.redis;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 读取redis的配置类
 * @author: liu qinchang
 * @create: 2020-01-14 10:59
 **/
@Data

public class RedisConf {

    private String server = "116.62.150.116";

    private String port = "6379";
}
