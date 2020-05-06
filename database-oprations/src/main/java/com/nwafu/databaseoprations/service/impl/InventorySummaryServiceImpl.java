package com.nwafu.databaseoprations.service.impl;

import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.FarmInfomationMapper;
import com.nwafu.databaseoprations.dao.RabbitInfoMapper;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.InventorySummaryService;
import com.nwafu.databaseoprations.vo.InventorySummary;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 存栏统计实现接口
 * @author: liu qinchang
 * @create: 2020-04-29 09:58
 **/
@Service
public class InventorySummaryServiceImpl implements InventorySummaryService {

    @Resource
    FarmInfomationMapper farmInfomationMapper;
    @Resource
    RabbitInfoMapper rabbitInfoMapper;

    RedisUtils redisUtils = new RedisUtils();

    /**
     *
     * @param dbName
     * @param username
     * @param farmUuid
     * @param type : 如果type为空，则查询所有
     * @return
     */
    @Override
    public ResponseMessage<InventorySummary> getTotalRabbitByFarmName(String dbName, String username, String farmUuid, List<String> type) {
        if(dbName == null || username == null || farmUuid == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        if(type == null || type.size() == 0){
            Integer maleTotal = rabbitInfoMapper.getMaleRabbitCount(farmUuid);
            Integer femaleTotal = rabbitInfoMapper.getFemaleRabbitCount(farmUuid);
            Integer total = maleTotal + femaleTotal;
            InventorySummary inventorySummary = new InventorySummary();
            inventorySummary.setFemale(femaleTotal);
            inventorySummary.setMale(maleTotal);
            inventorySummary.setTotal(total);
            return new ResponseMessage<>("success", inventorySummary);
        }
        StringBuffer sqlType = new StringBuffer();
        sqlType.append("economiType=\"" + type.get(0) + "\" ");
        for(int i = 1; i < type.size(); i++){
            sqlType.append("or economiType=\"" + type.get(i) + "\" ");
        }
//        System.out.println(sqlType.toString());
        Integer total = rabbitInfoMapper.getTotalByCondition(farmUuid, sqlType.toString());
        Integer maleTotal = rabbitInfoMapper.getMaleCountByCondition(farmUuid, sqlType.toString());
        Integer femaleTotal = rabbitInfoMapper.getFemaleCountByCondition(farmUuid, sqlType.toString());
        InventorySummary inventorySummary = new InventorySummary();
        inventorySummary.setFemale(femaleTotal);
        inventorySummary.setMale(maleTotal);
        inventorySummary.setTotal(total);
        return new ResponseMessage<>("success", inventorySummary);
    }
}
