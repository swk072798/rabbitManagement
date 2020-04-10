package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.EmployeeFarmRelationMapper;
import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelation;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelationVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.EmployeeFarmRelationService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 员工-兔场关联关系表
 * @author: liu qinchang
 * @create: 2020-04-04 11:09
 **/
@Service
public class EmployeeFarmRelationServiceImpl implements EmployeeFarmRelationService {

    @Resource
    EmployeeFarmRelationMapper employeeFarmRelationMapper;

    RedisUtils redisUtils = new RedisUtils();


    @Override
    public ResponseMessage<PageInfo<EmployeeFarmRelation>> getAllEmployeeFarmRelation(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<EmployeeFarmRelation> rabbitSaleRecordList = employeeFarmRelationMapper.selectAll();
        PageInfo<EmployeeFarmRelation> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<EmployeeFarmRelation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<EmployeeFarmRelation>> getEmployeeFarmRelationByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(condition == null || condition.equals("")){
            throw new RuntimeException("必要条件不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<EmployeeFarmRelation> rabbitSaleRecordList = employeeFarmRelationMapper.selectByCondition(condition, value);
        PageInfo<EmployeeFarmRelation> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<EmployeeFarmRelation>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addEmployeeFarmRelation(String dbName, String username, List<EmployeeFarmRelationVO> employeeFarmRelationList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(employeeFarmRelationList == null || employeeFarmRelationList.size() == 0){
            throw new RuntimeException("必要条件不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = employeeFarmRelationMapper.insert(employeeFarmRelationList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }

        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteEmployeeFarmRelationById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("必要条件不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);

        int flag = employeeFarmRelationMapper.deleteById(id);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }

        return new ResponseMessage<>("success", 1);
    }
}
