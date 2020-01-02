package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.accountloginmanagement.entity.ResponseMessage;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitInfoMapper;
import com.nwafu.databaseoprations.entity.RabbitInfo;
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

    /** 
    * @Description: 分页获取种兔基本信息列表 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(int limit, int page, String dbName){
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(limit, page);
        List<RabbitInfo> rabbitInfoList = rabbitInfoMapper.selectAll();
        PageInfo<RabbitInfo> rabbitInfoPageInfo = new PageInfo<>(rabbitInfoList);
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = new ResponseMessage<>("success", rabbitInfoPageInfo);
        return responseMessage;
    }

    /** 
    * @Description: 插入种兔基本信息（可以批量插入） 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/2 
    */
    @Override
    public ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfo> rabbitInfoList) {
        if(rabbitInfoList.size() == 0){
            throw new RuntimeException("传入参数不能为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitInfoMapper.insert(rabbitInfoList);
        if(flag == 0){
            throw new RuntimeException("insertRabbitInfo  插入失败");
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
    public ResponseMessage<Integer> deleteRabbitInfo(String dbName, List<String> rabbitNoList) {
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


}
