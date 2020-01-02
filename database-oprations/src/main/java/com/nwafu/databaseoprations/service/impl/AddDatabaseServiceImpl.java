package com.nwafu.databaseoprations.service.impl;

import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import com.nwafu.databaseoprations.config.DynamicDataSource;
import com.nwafu.databaseoprations.service.AddDatabaseService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: rabbitmanagement
 * @description: 添加数据源的实现类
 * @author: liu qinchang
 * @create: 2020-01-01 14:15
 **/

@Service
@Slf4j
public class AddDatabaseServiceImpl implements AddDatabaseService {

    @Override
    public void addDatabase(DatabaseInfo databaseInfo) {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        Map<Object, Object> datasourceMap = new HashMap<>();
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setUsername(databaseInfo.getLinkUsername());
        hikariDataSource.setPassword(databaseInfo.getLinkPassword());
        hikariDataSource.setJdbcUrl(databaseInfo.getJdbcUrl());
        hikariDataSource.setDriverClassName(databaseInfo.getDriverClassName());
        datasourceMap.put(databaseInfo.getDbName(), hikariDataSource);
        dynamicDataSource.setDataSources(datasourceMap);

    }
}
