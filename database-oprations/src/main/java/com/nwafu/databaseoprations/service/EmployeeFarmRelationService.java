package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelation;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelationVO;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface EmployeeFarmRelationService {
    ResponseMessage<PageInfo<EmployeeFarmRelation>> getAllEmployeeFarmRelation(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<EmployeeFarmRelation>> getEmployeeFarmRelationByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addEmployeeFarmRelation(String dbName, String username, List<EmployeeFarmRelationVO> employeeFarmRelationList);
    ResponseMessage<Integer> deleteEmployeeFarmRelationById(String dbName, String username, List<String> id);
}
