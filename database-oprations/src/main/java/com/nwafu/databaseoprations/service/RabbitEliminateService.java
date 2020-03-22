package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitEliminate;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface RabbitEliminateService {
    ResponseMessage<PageInfo<RabbitEliminate>> getAllRabbitEliminateRecord(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitEliminate>> getRabbitEliminateRecordByCondition(String dbName, String username, Integer limit,Integer page, String condition, String value);
    ResponseMessage<Integer> addRabbitEliminateRecord(String dbName, String username, List<RabbitEliminate> rabbitEliminateList);
    ResponseMessage<Integer> deleteRabbitEliminateRecord(String dbName, String username, List<String> id);
}
