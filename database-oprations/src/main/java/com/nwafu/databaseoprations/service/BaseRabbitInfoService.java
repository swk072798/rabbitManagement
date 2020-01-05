package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface BaseRabbitInfoService {
    ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(int page, int limit, String dbName);
    ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfo> rabbitInfoList);
    ResponseMessage<Integer> deleteRabbitInfo(String dbName, List<String> rabbitNoList);
    ResponseMessage<PageInfo<RabbitInfo>> getFemaleRabbit(String dbName, int page, int limit);
    ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbit(String dbName, int page, int limit);
    ResponseMessage<PageInfo<RabbitInfo>> getLittleFemaleRabbit(String dbName, int page, int limit);

}