package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitHouseBasicInfoMapper;
import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.RabbitHouseBasicInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔舍基本信息管理
 * @author: liu qinchang
 * @create: 2020-02-19 09:52
 **/
@Service
public class RabbitHouseBasicInfoServiceImpl implements RabbitHouseBasicInfoService {

    @Resource
    RabbitHouseBasicInfoMapper rabbitHouseBasicInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<RabbitHouseBasicInfo>> selectAllInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitHouseBasicInfo> rabbitHouseBasicInfos = rabbitHouseBasicInfoMapper.selectAllInfo();
        PageInfo<RabbitHouseBasicInfo> pageInfo = new PageInfo<>(rabbitHouseBasicInfos);
        ResponseMessage<PageInfo<RabbitHouseBasicInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitHouseBasicInfo>> selectInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        if(condition == null || value == null){
            throw new RuntimeException("查询条件或参数不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitHouseBasicInfo> rabbitHouseBasicInfos = rabbitHouseBasicInfoMapper.selectInfoByCondition(condition, value);
        PageInfo<RabbitHouseBasicInfo> pageInfo = new PageInfo<>(rabbitHouseBasicInfos);
        ResponseMessage<PageInfo<RabbitHouseBasicInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addRabbitHouseBasicInfo(String dbName, String username, List<RabbitHouseBasicInfo> rabbitHouseBasicInfoList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        if(rabbitHouseBasicInfoList == null || rabbitHouseBasicInfoList.size() == 0){
            throw new RuntimeException("新增参数不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitHouseBasicInfoMapper.insert(rabbitHouseBasicInfoList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteInfoById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("待删除的id不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitHouseBasicInfoMapper.deleteById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
