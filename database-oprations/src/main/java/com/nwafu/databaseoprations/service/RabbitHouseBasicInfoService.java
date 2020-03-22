package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface RabbitHouseBasicInfoService {
    ResponseMessage<PageInfo<RabbitHouseBasicInfo>> selectAllInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitHouseBasicInfo>> selectInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addRabbitHouseBasicInfo(String dbName, String username, List<RabbitHouseBasicInfo> rabbitHouseBasicInfoList);
    ResponseMessage<Integer> deleteInfoById(String dbName, String username, List<String> id);
}
