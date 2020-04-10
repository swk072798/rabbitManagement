package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.FarmInfomation;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface FarmInfomationService {
    ResponseMessage<PageInfo<FarmInfomation>> getAllFarmInfomation(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<FarmInfomation>> getFarmInfomationByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addFarmInfomation(String dbName, String username, List<FarmInfomation> farmInfomationList);
    ResponseMessage<Integer> deleteFarmInfomation(String dbName, String username, List<String> uuid);
}
