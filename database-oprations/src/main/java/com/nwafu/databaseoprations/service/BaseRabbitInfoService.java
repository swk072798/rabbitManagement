package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface BaseRabbitInfoService {
    ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(int page, int limit, String dbName, String username);
    ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfo> rabbitInfoList, String username);
    ResponseMessage<Integer> deleteRabbitInfo(String dbName, List<String> rabbitNoList, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getFemaleRabbit(String dbName, int page, int limit, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbit(String dbName, int page, int limit, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getLittleFemaleRabbit(String dbName, int page, int limit, String username);

}
