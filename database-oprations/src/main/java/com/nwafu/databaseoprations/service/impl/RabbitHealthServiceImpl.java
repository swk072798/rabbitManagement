package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitHealthMapper;
import com.nwafu.databaseoprations.entity.RabbitHealth;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitHealthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子健康信息记录表
 * @author: liu qinchang
 * @create: 2020-02-09 09:42
 **/
@Service
public class RabbitHealthServiceImpl implements RabbitHealthService {

    @Resource
    RabbitHealthMapper rabbitHealthMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitHealth>> getAllRabbitHealthInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        PageHelper.startPage(page, limit);
        List<RabbitHealth> rabbitHealthList = rabbitHealthMapper.selectAll();
        PageInfo<RabbitHealth> pageInfo = new PageInfo<>(rabbitHealthList);
        ResponseMessage<PageInfo<RabbitHealth>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitHealth>> getRabbitHealthByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || page == null || condition == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        PageHelper.startPage(page, limit);
        List<RabbitHealth> rabbitHealthList = rabbitHealthMapper.selectByCondition(condition, value);
        PageInfo<RabbitHealth> pageInfo = new PageInfo<>(rabbitHealthList);
        ResponseMessage<PageInfo<RabbitHealth>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitHealthInfo(String dbName, String username, List<RabbitHealth> rabbitHealthList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        if(rabbitHealthList == null || rabbitHealthList.size() == 0){
            throw new RuntimeException("新增数据不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        int flag = rabbitHealthMapper.insert(rabbitHealthList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRabbitHealthInfo(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        int flag = rabbitHealthMapper.deleteInfoById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
