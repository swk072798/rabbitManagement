package com.nwafu.accountloginmanagement.dao;


import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DatabaseInfoDao {
    List<DatabaseInfo> getAllDatabaseInfo();
    DatabaseInfo getDatabaseInfo(String dbName);
    int addDatabaseInfo(String dbName, String owner, String jdbcUrl, String linkUsername, String linkPassword, String driverClassName);
}
