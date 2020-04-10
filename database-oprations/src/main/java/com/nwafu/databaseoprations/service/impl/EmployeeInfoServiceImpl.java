package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.EmployeeInfoMapper;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.EmployeeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 员工基本信息管理操作
 * @author: liu qinchang
 * @create: 2020-04-04 10:30
 **/
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {

    @Resource
    EmployeeInfoMapper employeeInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<EmployeeInfo>> getAllEmployeeInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<EmployeeInfo> rabbitSaleRecordList = employeeInfoMapper.selectAll();
        PageInfo<EmployeeInfo> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<EmployeeInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<EmployeeInfo>> getEmployeeByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(condition == null || condition.equals("")){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<EmployeeInfo> rabbitSaleRecordList = employeeInfoMapper.selectByCondition(condition, value);
        PageInfo<EmployeeInfo> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<EmployeeInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addEmployeeInfo(String dbName, String username, List<EmployeeInfo> employeeInfoList) {
        if(dbName == null || username == null ){
            throw new RuntimeException("必要参数不能为空");
        }
        if(employeeInfoList == null || employeeInfoList.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = employeeInfoMapper.insert(employeeInfoList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteEmployeeInfoById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null ){
            throw new RuntimeException("必要参数不能为空");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("新增列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = employeeInfoMapper.deleteById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
