package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitEliminateMapper;
import com.nwafu.databaseoprations.entity.RabbitEliminate;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitEliminateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子淘汰记录表
 * @author: liu qinchang
 * @create: 2020-03-22 14:30
 **/
@Service
public class RabbitEliminateServiceImpl implements RabbitEliminateService {

    @Resource
    RabbitEliminateMapper rabbitEliminateMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitEliminate>> getAllRabbitEliminateRecord(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitEliminate> rabbitSaleRecordList = rabbitEliminateMapper.selectAll();
        PageInfo<RabbitEliminate> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<RabbitEliminate>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitEliminate>> getRabbitEliminateRecordByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        if(condition == null || condition == ""){
            throw new RuntimeException("查询条件不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitEliminate> rabbitSaleRecordList = rabbitEliminateMapper.selectRabbitEliminateRecordByCondition(condition, value);
        PageInfo<RabbitEliminate> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<RabbitEliminate>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitEliminateRecord(String dbName, String username, List<RabbitEliminate> rabbitEliminateList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        if(rabbitEliminateList == null || rabbitEliminateList.size() == 0){
            throw new RuntimeException("添加列表不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitEliminateMapper.insert(rabbitEliminateList);
        if(flag == 0){
            throw new RuntimeException("添加信息失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRabbitEliminateRecord(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有删除权限");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("删除列表不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitEliminateMapper.deleteById(id);
        if(flag == 0){
            throw new RuntimeException("删除信息失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
