package com.nwafu.databaseoprations.service.impl;

import com.nwafu.databaseoprations.dao.FarmInfomationMapper;
import com.nwafu.databaseoprations.entity.FarmInfomation;
import com.nwafu.databaseoprations.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 测试类
 * @author: liu qinchang
 * @create: 2019-12-30 14:11
 **/
@Service
public class TestServiceImpl implements TestService {

    @Resource
    FarmInfomationMapper farmInfomationMapper;

    @Override
    public List<FarmInfomation> selectAllFarm() {
        List<FarmInfomation> farmInfomationList = farmInfomationMapper.selectAll();
        return farmInfomationList;
    }
}
