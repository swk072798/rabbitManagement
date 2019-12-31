package com.nwafu.databaseoprations.config;

//import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import com.nwafu.databaseoprations.annotation.DataSource;
import com.nwafu.databaseoprations.feign.GetDatabaseInfoFeign;
import com.zaxxer.hikari.HikariDataSource;
//import feign.Feign;
//import feign.Request;
//import feign.Retryer;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: rabbitmanagement
 * @description: 添加新的数据源
 * @author: liu qinchang
 * @create: 2019-12-30 17:06
 **/

@Data
public class AddNewDatabase {
    Map<Object, Object> datasourceMap = new HashMap<>();

    /**
    * @Description: 读取数据库中的配置进行动态数据源的初始化
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/30
    */
    public void initDatabase(){
//        GetDatabaseInfoFeign getDatabaseInfoFeign = (GetDatabaseInfoFeign) Feign.builder()
//                .options(new Request.Options(1000,3500))
//                .retryer(new Retryer.Default(5000, 5000, 3))
//                .target(DatabaseInfo.class, "http://localhost:8300");
//        List<DatabaseInfo> databaseInfoList = getDatabaseInfoFeign.getAllDatabaseInfo();
//
//        for(DatabaseInfo databaseInfo : databaseInfoList){
//            HikariDataSource hikariDataSource = new HikariDataSource();
//            hikariDataSource.setUsername(databaseInfo.getLinkUsername());
//            hikariDataSource.setPassword(databaseInfo.getLinkPassword());
//            hikariDataSource.setJdbcUrl(databaseInfo.getJdbcUrl());
//            hikariDataSource.setDriverClassName(databaseInfo.getDriverClassName());
//            datasourceMap.put(databaseInfo.getDbName(), hikariDataSource);
//        }
    }

    /**
    * @Description: 生成数据源添加到动态配置中
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2019/12/30
    */
    public void generateDataSource(){

    }
}
