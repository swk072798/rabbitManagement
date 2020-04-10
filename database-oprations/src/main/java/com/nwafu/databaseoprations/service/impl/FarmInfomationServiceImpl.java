package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSource;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.FarmInfomationMapper;
import com.nwafu.databaseoprations.entity.FarmInfomation;
import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.FarmInfomationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔场管理接口
 * @author: liu qinchang
 * @create: 2020-03-31 09:33
 **/
@Service
public class FarmInfomationServiceImpl implements FarmInfomationService {

    @Resource
    FarmInfomationMapper farmInfomationMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<FarmInfomation>> getAllFarmInfomation(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<FarmInfomation> rabbitSaleRecordList = farmInfomationMapper.selectAll();
        PageInfo<FarmInfomation> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<FarmInfomation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<FarmInfomation>> getFarmInfomationByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<FarmInfomation> rabbitSaleRecordList = farmInfomationMapper.selectByCondition(condition, value);
        PageInfo<FarmInfomation> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<FarmInfomation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addFarmInfomation(String dbName, String username, List<FarmInfomation> farmInfomationList) {
        if(dbName == null || username == null ){
            throw new RuntimeException("必要参数不能为空");
        }
        if(farmInfomationList == null || farmInfomationList.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        int flag = farmInfomationMapper.insert(farmInfomationList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteFarmInfomation(String dbName, String username, List<String> uuid) {
        if(dbName == null || username == null ){
            throw new RuntimeException("必要参数不能为空");
        }
        if(uuid == null || uuid.size() == 0){
            throw new RuntimeException("删除列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(username);
        int flag = farmInfomationMapper.deleteById(uuid);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
