package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitDeathMapper;
import com.nwafu.databaseoprations.entity.RabbitDeath;
import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitDeathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子死亡记录
 * @author: liu qinchang
 * @create: 2020-03-09 20:33
 **/

@Service
public class RabbitDeathServiceImpl implements RabbitDeathService {

    @Resource
    RabbitDeathMapper rabbitDeathMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitDeath>> getAllRabbitDeathInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitDeath> rabbitHouseBasicInfos = rabbitDeathMapper.selectAll();
        PageInfo<RabbitDeath> pageInfo = new PageInfo<>(rabbitHouseBasicInfos);
        ResponseMessage<PageInfo<RabbitDeath>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitDeath>> getRabbitDeathInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(condition == null || value == null){
            throw new RuntimeException("筛选条件不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitDeath> rabbitHouseBasicInfos = rabbitDeathMapper.selectByCondition(condition, value);
        PageInfo<RabbitDeath> pageInfo = new PageInfo<>(rabbitHouseBasicInfos);
        ResponseMessage<PageInfo<RabbitDeath>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitDeathInfo(String dbName, String username, List<RabbitDeath> rabbitDeathList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(rabbitDeathList == null || rabbitDeathList.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitDeathMapper.insert(rabbitDeathList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRabbitDeathInfo(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("待删除列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitDeathMapper.deleteRabbitDeathInfo(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
