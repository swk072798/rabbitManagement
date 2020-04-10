package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.CompanyBaseInfoMapper;
import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfoVO;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.CompanyBaseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 公司基本信息存储表
 * @author: liu qinchang
 * @create: 2020-04-04 10:59
 **/
@Service
public class CompanyBaseInfoServiceImpl implements CompanyBaseInfoService {

    @Resource
    CompanyBaseInfoMapper companyBaseInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<PageInfo<CompanyBaseInfo>> getAllCompanyBaseInfo(String dbName, String username, Integer limit, Integer page) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(page, limit);
        List<CompanyBaseInfo> rabbitSaleRecordList = companyBaseInfoMapper.selectAll();
        PageInfo<CompanyBaseInfo> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<CompanyBaseInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<PageInfo<CompanyBaseInfo>> getCompanyBaseInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value) {
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
        List<CompanyBaseInfo> rabbitSaleRecordList = companyBaseInfoMapper.selectByCondition(condition, value);
        PageInfo<CompanyBaseInfo> pageInfo = new PageInfo<>(rabbitSaleRecordList);
        ResponseMessage<PageInfo<CompanyBaseInfo>> responseMessage = new ResponseMessage<>("success", pageInfo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<Integer> addCompanyBaseInfo(String dbName, String username, List<CompanyBaseInfoVO> companyBaseInfoVOList) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(companyBaseInfoVOList == null || companyBaseInfoVOList.size() == 0){
            throw new RuntimeException("插入列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("没有新增权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        if(companyBaseInfoMapper.selectAll().size() >= 1){
            throw new RuntimeException("最多只能添加一条公司基本信息");
        }
        int flag = companyBaseInfoMapper.insert(companyBaseInfoVOList);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }

    @Override
    public ResponseMessage<Integer> deleteCompanyBaseInfoById(String dbName, String username, List<String> id) {
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(id == null || id.size() == 0){
            throw new RuntimeException("删除列表不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("d")){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);

        int flag = companyBaseInfoMapper.deleteById(id);
        if(flag == 0){
            throw new RuntimeException("新增失败");
        }
        return new ResponseMessage<>("success", 1);
    }
}
