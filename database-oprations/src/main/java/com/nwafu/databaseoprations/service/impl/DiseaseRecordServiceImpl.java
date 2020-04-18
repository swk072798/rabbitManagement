package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitIllnessMapper;
import com.nwafu.databaseoprations.dao.RabbitIllnessRecordMapper;
import com.nwafu.databaseoprations.entity.RabbitIllness;
import com.nwafu.databaseoprations.entity.RabbitIllnessPO;
import com.nwafu.databaseoprations.entity.RabbitIllnessRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.DiseaseRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 疾病记录和登记
 * @author: liu qinchang
 * @create: 2020-02-05 17:57
 **/

@Service
public class DiseaseRecordServiceImpl implements DiseaseRecordService {
    @Resource
    RabbitIllnessMapper rabbitIllnessMapper;

    @Resource
    RabbitIllnessRecordMapper rabbitIllnessRecordMapper;


    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitIllness>> getIllnessByIllnessName(String dbName, String username, Integer page, Integer limit, String illnessName) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }

        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllness> rabbitIllnessList = rabbitIllnessMapper.selectInfoByName(illnessName);
        PageInfo<RabbitIllness> pageInfo = new PageInfo<>(rabbitIllnessList);
        ResponseMessage responseMessage = new ResponseMessage("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitIllness>> getAllIllness(String dbName, String username, Integer page, Integer limit) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllness> rabbitIllnessList = rabbitIllnessMapper.selectAll();
        PageInfo<RabbitIllness> pageInfo = new PageInfo<>(rabbitIllnessList);
        ResponseMessage<PageInfo<RabbitIllness>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }
    @Override
    public ResponseMessage<PageInfo<RabbitIllness>> getIllnessByCondition(String dbName, String username, Integer page, Integer limit, String condition, String value){
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllness> rabbitIllnessList = rabbitIllnessMapper.getAllIllnessByCondition(condition, value);
        PageInfo<RabbitIllness> pageInfo = new PageInfo<>(rabbitIllnessList);
        ResponseMessage<PageInfo<RabbitIllness>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addIllnessInfo(String dbName, String username, List<RabbitIllness> rabbitIllnessList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        if(rabbitIllnessList.size() == 0){
            throw new RuntimeException("加入数据为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        List<RabbitIllnessPO> rabbitIllnessPOList = new ArrayList<>();
        for(RabbitIllness rabbitIllness : rabbitIllnessList){
            RabbitIllnessPO rabbitIllnessPO = new RabbitIllnessPO(rabbitIllness);
            rabbitIllnessPOList.add(rabbitIllnessPO);
        }
        int flag = rabbitIllnessMapper.insert(rabbitIllnessPOList);
        if(flag == 0){
            throw new RuntimeException("加入数据失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteInfoById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        if(id.size() == 0){
            throw new RuntimeException("待删除的id不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitIllnessMapper.deleteInfoById(id);
        if(flag == 0){
            throw new RuntimeException("删除信息失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<PageInfo<RabbitIllnessRecord>> getAllRecord(String dbName, String username, Integer page, Integer limit) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllnessRecord> rabbitIllnessRecordList = rabbitIllnessRecordMapper.selectAll();
        PageInfo<RabbitIllnessRecord> pageInfo = new PageInfo<>(rabbitIllnessRecordList);
        ResponseMessage<PageInfo<RabbitIllnessRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitIllnessRecord>> getRecordByIllnessName(String dbName, String username, Integer page, Integer limit, String illnessName) {
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllnessRecord> rabbitIllnessRecordList = rabbitIllnessRecordMapper.selectInfoByName(username);
        PageInfo<RabbitIllnessRecord> pageInfo = new PageInfo<>(rabbitIllnessRecordList);
        ResponseMessage<PageInfo<RabbitIllnessRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitIllnessRecord(String dbName, String username, List<RabbitIllnessRecord> rabbitIllnessRecordList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有添加权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitIllnessRecordMapper.insert(rabbitIllnessRecordList);
        if(flag == 0){
            throw new RuntimeException("添加数据失败");
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
        if (id.size() == 0){
            throw new RuntimeException("待删除的id不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitIllnessRecordMapper.deleteInfoById(id);
        if(flag == 0){
            throw new RuntimeException("删除数据失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<PageInfo<RabbitIllnessRecord>> getIllnessRecordByCondition(String dbName, String username, Integer page, Integer limit, String condition, String value){
        if(dbName == null || username == null || page == null || limit == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        if(condition == null || condition.equals("")){
            throw new RuntimeException("查询条件不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitIllnessRecord> rabbitIllnessList = rabbitIllnessRecordMapper.selectInfoByCondition(condition, value);
        PageInfo<RabbitIllnessRecord> pageInfo = new PageInfo<>(rabbitIllnessList);
        ResponseMessage<PageInfo<RabbitIllnessRecord>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }
}
