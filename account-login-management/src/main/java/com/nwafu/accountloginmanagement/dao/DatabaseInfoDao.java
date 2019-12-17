package com.nwafu.accountloginmanagement.dao;

import com.nwafu.accountloginmanagement.entity.DatabaseInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DatabaseInfoDao {
    DatabaseInfo getDatabaseInfo(String dbName);
    int addDatabaseInfo(String dbName, String owner, String jdbcUrl, String linkUsername, String linkPassword, String driverClassName);
}
