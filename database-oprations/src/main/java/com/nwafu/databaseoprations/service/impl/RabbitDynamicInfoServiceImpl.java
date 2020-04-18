package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitDynamicInformationMapper;
import com.nwafu.databaseoprations.entity.RabbitDynamicInformation;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitDynamicInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子动态信息记录
 * @author: liu qinchang
 * @create: 2020-02-14 09:25
 **/

@Service
public class RabbitDynamicInfoServiceImpl implements RabbitDynamicInfoService {

    @Resource
    RabbitDynamicInformationMapper rabbitDynamicInformationMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitDynamicInformation>> getAllRabbitDynamicInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitDynamicInformation> rabbitDynamicInformations = rabbitDynamicInformationMapper.selectAll();
        PageInfo<RabbitDynamicInformation> pageInfo = new PageInfo<>(rabbitDynamicInformations);
        ResponseMessage<PageInfo<RabbitDynamicInformation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitDynamicInformation>> getDynamicInfoByNo(String dbName, String username, Integer limit, Integer page, String rabbitNo) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitDynamicInformation> rabbitDynamicInformations = rabbitDynamicInformationMapper.selectInfoByNo(rabbitNo);
        PageInfo<RabbitDynamicInformation> pageInfo = new PageInfo<>(rabbitDynamicInformations);
        ResponseMessage<PageInfo<RabbitDynamicInformation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitDynamicInfo(String dbName, String username, List<RabbitDynamicInformation> rabbitDynamicInformationList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        if(rabbitDynamicInformationList == null || rabbitDynamicInformationList.size() == 0){
            throw new RuntimeException("新增数据不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitDynamicInformationMapper.insert(rabbitDynamicInformationList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteRabbitDynamicInfo(String dbName, String username, List<String> rabbitNo) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        if(rabbitNo == null || rabbitNo.size() == 0){
            throw new RuntimeException("待删除的rabbitNo不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitDynamicInformationMapper.deleteInfoByRabbitNo(rabbitNo);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<PageInfo<RabbitDynamicInformation>> getDynamicInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value){
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(condition == null || condition.equals("")){
            throw new RuntimeException("查询条件不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitDynamicInformation> rabbitDynamicInformations = rabbitDynamicInformationMapper.getDynamicInfoByCondition(condition, value);
        PageInfo<RabbitDynamicInformation> pageInfo = new PageInfo<>(rabbitDynamicInformations);
        ResponseMessage<PageInfo<RabbitDynamicInformation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }
}
