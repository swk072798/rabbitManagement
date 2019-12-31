package com.nwafu.databaseoprations.controller;

import com.nwafu.databaseoprations.annotation.DataSource;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.entity.FarmInfomation;
import com.nwafu.databaseoprations.service.TestService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 测试动态数据源类
 * @author: liu qinchang
 * @create: 2019-12-27 14:06
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/getFarmInfo_m")
    public List<FarmInfomation> getFarmInfo_m(@RequestParam(value = "username") String usermane){
        log.info("getFarmInfo,  {}", usermane);
        DynamicDataSourceContextHolder.setDataSourceKey("master");
        List<FarmInfomation> result = testService.selectAllFarm();
        return result;
    }


    @RequestMapping("/getFarmInfo_s")
    public List<FarmInfomation> getFarmInfo(@RequestParam(value = "username") String usermane){
        log.info("getFarmInfo,  {}", usermane);
        HikariDataSource hikariDataSource = new HikariDataSource();
        DynamicDataSourceContextHolder.setDataSourceKey("slave");
        List<FarmInfomation> result = testService.selectAllFarm();
        return result;
    }
}
