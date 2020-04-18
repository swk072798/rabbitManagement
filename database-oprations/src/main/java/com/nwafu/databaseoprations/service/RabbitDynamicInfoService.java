package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitDynamicInformation;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface RabbitDynamicInfoService {
    ResponseMessage<PageInfo<RabbitDynamicInformation>> getAllRabbitDynamicInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitDynamicInformation>> getDynamicInfoByNo(String dbName, String username, Integer limit, Integer page, String rabbitNo);
    ResponseMessage<Integer> addRabbitDynamicInfo(String dbName, String username, List<RabbitDynamicInformation> rabbitDynamicInformationList);
    ResponseMessage<Integer> deleteRabbitDynamicInfo(String dbName, String username, List<String> id);
    ResponseMessage<PageInfo<RabbitDynamicInformation>> getDynamicInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
}
