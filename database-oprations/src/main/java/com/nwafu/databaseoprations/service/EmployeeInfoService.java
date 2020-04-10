package com.nwafu.databaseoprations.service;


import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface EmployeeInfoService {
    ResponseMessage<PageInfo<EmployeeInfo>> getAllEmployeeInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<EmployeeInfo>> getEmployeeByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addEmployeeInfo(String dbName, String username, List<EmployeeInfo> employeeInfoList);
    ResponseMessage<Integer> deleteEmployeeInfoById(String dbName, String username, List<String> id);
}
