package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.EmployeeFarmRelation;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelationVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeFarmRelationMapper {

    List<EmployeeFarmRelation> selectAll();
    List<EmployeeFarmRelation> selectByCondition(String condition, String value);
    int insert(List<EmployeeFarmRelationVO> employeeFarmRelationList);
    int deleteById(List<String> id);

}
