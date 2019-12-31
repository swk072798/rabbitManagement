package com.nwafu.accountloginmanagement.controller;

import com.nwafu.accountloginmanagement.dao.DatabaseInfoDao;
import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 获取数据库配置类
 * @author: liu qinchang
 * @create: 2019-12-30 17:15
 **/

@RestController
public class GetDatabaseInfoController {

    @Resource
    DatabaseInfoDao databaseInfoDao;

    @GetMapping("/getAllDatabaseInfo")
    public List<DatabaseInfo> getDatabaseInfo(){
        return databaseInfoDao.getAllDatabaseInfo();
    }
}
