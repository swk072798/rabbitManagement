package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyBaseInfoMapper {
    List<CompanyBaseInfo> selectAll();
    List<CompanyBaseInfo> selectByCondition(String condition, String value);
    int insert(List<CompanyBaseInfoVO> companyBaseInfoList);
    int deleteById(List<String> id);
}
