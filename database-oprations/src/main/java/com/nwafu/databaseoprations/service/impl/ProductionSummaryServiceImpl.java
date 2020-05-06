package com.nwafu.databaseoprations.service.impl;

import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.*;
import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.ProductionSummaryService;
import com.nwafu.databaseoprations.vo.RabbitHouseProductionSummary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 生产汇总实现类
 * @author: liu qinchang
 * @create: 2020-05-01 11:51
 **/
@Service
public class ProductionSummaryServiceImpl implements ProductionSummaryService {

    @Resource
    RabbitHouseBasicInfoMapper rabbitHouseBasicInfoMapper;
    @Resource
    RabbitChangeRecordMapper rabbitChangeRecordMapper;
    @Resource
    RabbitEliminateMapper rabbitEliminateMapper;
    @Resource
    RabbitDeathMapper rabbitDeathMapper;


    RedisUtils redisUtils = new RedisUtils();

    @Override
    public ResponseMessage<List<RabbitHouseProductionSummary>> rabbitHouseProductionSummary(String dbName, String username, String farmUuid, String startDate, String endDate) {
        if(dbName == null || username == null || startDate == null || endDate == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        List<String> rabbitHouseNo = rabbitHouseBasicInfoMapper.getRabbitHouseNo(farmUuid);
        if(rabbitHouseNo.size() == 0){
            throw new RuntimeException("没有相关兔舍信息");
        }
        List<RabbitHouseProductionSummary> list = new ArrayList<>(rabbitHouseNo.size());
        for(int i = 0; i < rabbitHouseNo.size(); i++){
            Integer in = rabbitChangeRecordMapper.getInRabbitCount(rabbitHouseNo.get(i), startDate, endDate);
            Integer out = rabbitChangeRecordMapper.getOutRabbitCount(rabbitHouseNo.get(i), startDate, endDate);
            Integer eliminate = rabbitEliminateMapper.getEliminateCount(rabbitHouseNo.get(i), startDate, endDate);
            Integer death = rabbitDeathMapper.getDeathCount(rabbitHouseNo.get(i), startDate, endDate);
            RabbitHouseProductionSummary rabbitHouseProductionSummary = new RabbitHouseProductionSummary();
            rabbitHouseProductionSummary.setIn(in);
            rabbitHouseProductionSummary.setOut(out);
            rabbitHouseProductionSummary.setEliminate(eliminate);
            rabbitHouseProductionSummary.setDeath(death);
            rabbitHouseProductionSummary.setHouseNo(rabbitHouseNo.get(i));
            list.add(rabbitHouseProductionSummary);
        }
        ResponseMessage<List<RabbitHouseProductionSummary>> responseMessage = new ResponseMessage<>("success", list);
        return responseMessage;
    }
}
