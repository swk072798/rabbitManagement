package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitBreedingMapper;
import com.nwafu.databaseoprations.entity.RabbitBreeding;
import com.nwafu.databaseoprations.entity.RabbitBreedingPO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.BreedingRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 繁殖记录操作
 * @author: liu qinchang
 * @create: 2020-01-15 09:50
 **/
@Service
public class BreedingRecordServiceImpl implements BreedingRecordService {

    @Resource
    RabbitBreedingMapper rabbitBreedingMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<Integer> insertBreedingRecord(String dbName, String username, List<RabbitBreeding> rabbitBreedingList) {
        if(!redisUtils.checkPermission("c", username)){
            throw new RuntimeException("没有插入权限");
        }
        if(rabbitBreedingList == null || rabbitBreedingList.size() == 0){
            throw new RuntimeException("插入列表不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        List<RabbitBreedingPO> rabbitBreedingPOS = new ArrayList<>();
        for(RabbitBreeding rabbitBreeding : rabbitBreedingList){
            RabbitBreedingPO rabbitBreedingPO = new RabbitBreedingPO(rabbitBreeding);
            rabbitBreedingPOS.add(rabbitBreedingPO);
        }
        int flag = rabbitBreedingMapper.insert(rabbitBreedingPOS);
        if(flag == 0){
            throw new RuntimeException("插入失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecord(String dbName, String username, int limit, int page) {
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        PageHelper.startPage(page, limit);
        List<RabbitBreeding> rabbitBreedings = rabbitBreedingMapper.selectAll();
        PageInfo<RabbitBreeding> pageInfo = new PageInfo<>(rabbitBreedings, page);
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecordByFemaleRabbit(String dbName, String username, int limit, int page, String femaleRabbitNo) {
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitBreeding> rabbitBreedings = rabbitBreedingMapper.selectByFemaleRabbit(femaleRabbitNo);
        PageInfo<RabbitBreeding> pageInfo = new PageInfo<>(rabbitBreedings);
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecordByMaleRabbit(String dbName, String username, int limit, int page, String maleRabbitNo) {
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitBreeding> rabbitBreedings = rabbitBreedingMapper.selectByMaleRabbit(maleRabbitNo);
        PageInfo<RabbitBreeding> pageInfo = new PageInfo<>(rabbitBreedings);
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> deleteBreedingRecord(String dbName, String username, List<String> breedingInfomationIdList) {
        if (!redisUtils.checkPermission("d", username)) {
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitBreedingMapper.deleteById(breedingInfomationIdList);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteBreedingRecordByFemaleRabbit(String dbName, String username, String femaleRabbitNo) {
        if (!redisUtils.checkPermission("d", username)) {
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitBreedingMapper.deleteByFemaleRabbit(femaleRabbitNo);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteBreedingRecordByMaleRabbit(String dbName, String username, String maleRabbitNo) {
        if (!redisUtils.checkPermission("d", username)) {
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitBreedingMapper.deleteByMaleRabbit(maleRabbitNo);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
