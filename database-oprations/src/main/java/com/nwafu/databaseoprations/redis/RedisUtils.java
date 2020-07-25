package com.nwafu.databaseoprations.redis;

import com.alibaba.fastjson.JSONObject;
import com.nwafu.databaseoprations.entity.UserCacheInfo;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

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

    public boolean isExit(String key){
        return redisClient.exists(key);
    }

    public List<String> getPermissionsToList(String key){
        UserCacheInfo userCacheInfo = (UserCacheInfo) getObject(key, UserCacheInfo.class);
        if(userCacheInfo.getPermissions() == null ){
            throw new RuntimeException("没有相关操作权限");
        }
        List<String> permissions = Arrays.asList(userCacheInfo.getPermissions().split("/"));
        return permissions;
    }

    public boolean checkPermission(String permission, String key){
        List<String> permissions = getPermissionsToList(key);
        if(permissions.contains(permission)){
            return true;
        }else{
            return false;
        }
    }

}
