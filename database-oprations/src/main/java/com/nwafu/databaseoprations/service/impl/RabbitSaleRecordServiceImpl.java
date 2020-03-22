package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitSaleRecordMapper;
import com.nwafu.databaseoprations.entity.RabbitDeath;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.RabbitSaleRecordPO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitSaleRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子销售记录表
 * @author: liu qinchang
 * @create: 2020-03-12 14:09
 **/
@Service
public class RabbitSaleRecordServiceImpl implements RabbitSaleRecordService {
    @Resource
    RabbitSaleRecordMapper rabbitSaleRecordMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitSaleRecord>> selectAllRabbitSaleRecord(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitSaleRecord> rabbitSaleRecordList = rabbitSaleRecordMapper.getAllRabbitSaleRecord();
        PageInfo<RabbitSaleRecord> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<RabbitSaleRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitSaleRecord>> selectRabbitSaleRecordByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitSaleRecord> rabbitSaleRecordList = rabbitSaleRecordMapper.getRabbitSaleRecordByCondition(condition, value);
        PageInfo<RabbitSaleRecord> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<RabbitSaleRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitSaleRecord(String dbName, String username, List<RabbitSaleRecord> rabbitSaleRecordList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(rabbitSaleRecordList == null || rabbitSaleRecordList.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        List<RabbitSaleRecordPO> rabbitSaleRecordPOS = new ArrayList<>(rabbitSaleRecordList.size());
        for(RabbitSaleRecord rabbitSaleRecord : rabbitSaleRecordList){
            rabbitSaleRecordPOS.add(new RabbitSaleRecordPO(rabbitSaleRecord));
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
       int flag = rabbitSaleRecordMapper.insert(rabbitSaleRecordList);
       if(flag == 0){
           throw new RuntimeException("新增失败");
       }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRabbitSaleRecord(String dbName, String username, List<String> id) {
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
        int flag = rabbitSaleRecordMapper.deleteRabbitSaleRecordById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
