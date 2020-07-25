package com.nwafu.accountloginmanagement.config;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @program: rabbitManagement
 * @description: redis工具类，负责一些权限验证的功能
 * @author: liu qinchang
 * @create: 2020-01-14 10:17
 **/
@Slf4j
public class RedisUtils {
    private Jedis redisClient;

    RedisConf redisConf = new RedisConf();

    public RedisUtils(){
        log.info("redis server:{} , port:{}",redisConf.getServer(), redisConf.getPort());
        redisClient = new Jedis(redisConf.getServer(), Integer.parseInt(redisConf.getPort()));
    }

    public void addString(String key, String value){
        redisClient.set(key, value);
    }

    public String getValue(String key){
        return redisClient.get(key);
    }

    public void addObject(String key, Object object){
        redisClient.set(key, JSONObject.toJSONString(object));
    }

    public Object getObject(String key, Class clazz){
        return JSONObject.parseObject(redisClient.get(key), clazz);
    }

    public void delete(String... keys){
        redisClient.del(keys);
    }

}
