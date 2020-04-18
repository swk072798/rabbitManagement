package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.CompanyBaseInfoMapper;
import com.nwafu.databaseoprations.dao.RabbitInfoMapper;
import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.RabbitInfoVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.rabbitnoproducer.RabbitNoProducer;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.BaseRabbitInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    CompanyBaseInfoMapper companyBaseInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    RabbitNoProducer rabbitNoProducer;

    /** 
    * @Description: 分页获取种兔基本信息列表 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    @Override
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(Integer limit, Integer page, String dbName, String username){

        if(limit == null || page == null || dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }

        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getAllRabbitInfo 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.selectAll();
        System.out.println(rabbitInfoList);
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
    public ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfoVO> rabbitInfoVOList, String username) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(rabbitInfoVOList == null || rabbitInfoVOList.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("insertRabbitInfo 没有相关操作权限");
        }
        if(rabbitInfoVOList.size() == 0){
            throw new RuntimeException("传入参数不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        List<CompanyBaseInfo> companyBaseInfo = companyBaseInfoMapper.selectAll();
        if(companyBaseInfo == null || companyBaseInfo.size() == 0){
            throw new RuntimeException("企业缩写未设置");
        }
        List<String> allRabbitNo = rabbitInfoMapper.getAllRabbitNo();
        String abbreviation = companyBaseInfo.get(0).getCompanyAbbreviation();
        rabbitNoProducer = new RabbitNoProducer(abbreviation);
        rabbitNoProducer.setRabbitInfoVOList(rabbitInfoVOList);
        rabbitNoProducer.setAllRabbitNo(allRabbitNo);
        List<RabbitInfo> rabbitInfoList = rabbitNoProducer.produceNo();

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
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(rabbitNoList == null || rabbitNoList.size() == 0){
            throw new RuntimeException("待删除列表不能为空");
        }
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
    public ResponseMessage<PageInfo<RabbitInfo>> getFemaleRabbit(String dbName, Integer page, Integer limit, String username) {
        if(limit == null || page == null || dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
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
    public ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbit(String dbName, Integer page, Integer limit, String username) {
        if(limit == null || page == null || dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
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
    public ResponseMessage<PageInfo<RabbitInfo>> getLittleFemaleRabbit(String dbName, Integer page, Integer limit, String username) {
        if(limit == null || page == null || dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
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

    public ResponseMessage<PageInfo<RabbitInfo>> getRabbitInfoByCondition(String dbName, String username, Integer page, Integer limit, String condition, String value){
        if(limit == null || page == null || dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getLittleFemaleRabbit 没有相关操作权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.getRabbitInfoByCondition(condition, value);
        PageInfo<RabbitInfo> pageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

}
