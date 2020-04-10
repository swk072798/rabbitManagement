package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfoVO;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface CompanyBaseInfoService {
    ResponseMessage<PageInfo<CompanyBaseInfo>> getAllCompanyBaseInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<CompanyBaseInfo>> getCompanyBaseInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addCompanyBaseInfo(String dbName, String username, List<CompanyBaseInfoVO> companyBaseInfoList);
    ResponseMessage<Integer> deleteCompanyBaseInfoById(String dbName, String username, List<String> id);
}
