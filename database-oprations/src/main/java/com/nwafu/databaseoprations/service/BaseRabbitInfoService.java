package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.RabbitInfoVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface BaseRabbitInfoService {
    ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(Integer page, Integer limit, String dbName, String username);
    ResponseMessage<Integer> insertRabbitInfo(String dbName, List<RabbitInfoVO> rabbitInfoList, String username);
    ResponseMessage<Integer> deleteRabbitInfo(String dbName, List<String> rabbitNoList, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getFemaleRabbit(String dbName, Integer page, Integer limit, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbit(String dbName, Integer page, Integer limit, String username);
    ResponseMessage<PageInfo<RabbitInfo>> getLittleFemaleRabbit(String dbName, Integer page, Integer limit, String username);

}
