package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitInfoMapper;
import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.BaseRabbitInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 处理种兔基本信息类
 * @author: liu qinchang
 * @create: 2020-01-02 15:27
 **/
@Service
public class BaseRabbitInfoServiceImpl implements BaseRabbitInfoService {

    @Resource
    RabbitInfoMapper rabbitInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    /** 
    * @Description: 分页获取种兔基本信息列表 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    @Override
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(int limit, int page, String dbName, String username){

        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getAllRabbitInfo 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.selectAll();
        PageInfo<RabbitInfo> rabbitInfoPageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", rabbitInfoPageInfo);
        return responseMessage;
    }

    /** 
    * @Description: 新增种兔基本信息（可以批量新增）
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    @Override
    public ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfo> rabbitInfoList, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("insertRabbitInfo 没有相关操作权限");
        }
        if(rabbitInfoList.size() == 0){
            throw new RuntimeException("传入参数不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitInfoMapper.insert(rabbitInfoList);
        if(flag == 0){
            throw new RuntimeException("insertRabbitInfo  新增失败");
        }

        return new ResponseMessage<>("success", 1);
    }

    /** 
    * @Description: 删除种兔基本信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    @Override
    public ResponseMessage<Integer> deleteRabbitInfo(String dbName, List<String> rabbitNoList, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("deleteRabbitInfo 没有相关操作权限");
        }
        if(rabbitNoList.size() == 0){
            throw new RuntimeException("deleteRabbitInfo  参数异常");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitInfoMapper.deleteRabbitInfoByRabbitNo(rabbitNoList);
        if(flag == 0){
            throw new RuntimeException("deleteRabbitInfo  删除失败");
        }
        return new ResponseMessage<Integer>("success", 1);
    }

    @Override
    public ResponseMessage<PageInfo<RabbitInfo>> getFemaleRabbit(String dbName, int page, int limit, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getFemaleRabbit 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.getFamaleRabbitInfo();
        PageInfo<RabbitInfo> pageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbit(String dbName, int page, int limit, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getMaleRabbit 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.getMaleRabbitInfo();
        PageInfo<RabbitInfo> pageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<RabbitInfo>> getLittleFemaleRabbit(String dbName, int page, int limit, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getLittleFemaleRabbit 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.getLittleRabbitInfo();
        PageInfo<RabbitInfo> pageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }


}
