package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitMaterialsRecordMapper;
import com.nwafu.databaseoprations.entity.RabbitMaterialsRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.MaterialsRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 用料登记表
 * @author: liu qinchang
 * @create: 2020-02-11 10:03
 **/

@Service
public class MaterialsRecordServiceImpl implements MaterialsRecordService {

    @Resource
    RabbitMaterialsRecordMapper rabbitMaterialsRecordMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitMaterialsRecord>> getAllMaterialsRecord(String dbName, String username, Integer page, Integer limit) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitMaterialsRecord> rabbitMaterialsRecordList = rabbitMaterialsRecordMapper.selectAll();
        PageInfo<RabbitMaterialsRecord> pageInfo = new PageInfo<>(rabbitMaterialsRecordList);
        ResponseMessage<PageInfo<RabbitMaterialsRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitMaterialsRecord>> getMaterialsRecordByFeedType(String dbName, String username, Integer page, Integer limit, String feedType) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitMaterialsRecord> rabbitMaterialsRecordList = rabbitMaterialsRecordMapper.selectByFeedType(feedType);
        PageInfo<RabbitMaterialsRecord> pageInfo = new PageInfo<>(rabbitMaterialsRecordList);
        ResponseMessage<PageInfo<RabbitMaterialsRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addMaterialsRecord(String dbName, String username, List<RabbitMaterialsRecord> rabbitMaterialsRecordList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitMaterialsRecordMapper.insert(rabbitMaterialsRecordList);
        if(flag == 0){
            throw new RuntimeException("新增信息失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRecordById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        int flag = rabbitMaterialsRecordMapper.deleteRecordById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
