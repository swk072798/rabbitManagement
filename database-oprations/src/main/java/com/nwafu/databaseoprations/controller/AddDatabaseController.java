package com.nwafu.databaseoprations.controller;

import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import com.nwafu.databaseoprations.service.AddDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: rabbitmanagement
 * @description: 供普通用户在注册时将数据源添加到链接组中
 * @author: liu qinchang
 * @create: 2020-01-01 14:14
 **/

@RestController
@Slf4j
public class AddDatabaseController {

    @Autowired
    AddDatabaseService addDatabaseService;

    @GetMapping("/addDatabaseLink")
    public void addDatabaseLink(@RequestParam String username, @RequestParam String jdbcUrl, @RequestParam String user, @RequestParam String password, @RequestParam String driverClass){
        log.info("addDatabaseLink  参数：{},{},{},{},{}", username, jdbcUrl, user, password, driverClass);
//        if(databaseInfo == null){
//            throw new RuntimeException("addDatabaseLink  参数异常");
//        }
        DatabaseInfo databaseInfo = new DatabaseInfo();
        databaseInfo.setDbName(username);
        databaseInfo.setDriverClassName("com.mysql.cj.jdbc.Driver");
        databaseInfo.setJdbcUrl(jdbcUrl);
        databaseInfo.setLinkUsername("root");
        databaseInfo.setLinkPassword("123456");
        databaseInfo.setOwner(username);
        addDatabaseService.addDatabase(databaseInfo);
    }
}
