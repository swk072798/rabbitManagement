package com.nwafu.gateway.redis;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;


/**
 * @program: rabbitManagement
 * @description: redis工具类
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

    public boolean isExit(String key){
        return redisClient.exists(key);
    }

    public boolean isUserExit(String username){
        return redisClient.exists(username);
    }

}
