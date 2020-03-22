package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitDeath;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface RabbitDeathService {
    ResponseMessage<PageInfo<RabbitDeath>> getAllRabbitDeathInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitDeath>> getRabbitDeathInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addRabbitDeathInfo(String dbName, String username, List<RabbitDeath> rabbitDeathList);
    ResponseMessage<Integer> deleteRabbitDeathInfo(String dbName, String username, List<String> id);
}
