package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.EmployeeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeInfoMapper {

    List<EmployeeInfo> selectAll();
    List<EmployeeInfo> selectByCondition(String condition, String value);
    int insert(List<EmployeeInfo> employeeInfoList);
    int deleteById(List<String> id);

}
