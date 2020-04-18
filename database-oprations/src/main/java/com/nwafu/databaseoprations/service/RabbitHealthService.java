package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitHealth;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import javax.xml.ws.Response;
import java.util.List;

public interface RabbitHealthService {
    ResponseMessage<PageInfo<RabbitHealth>> getAllRabbitHealthInfo(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitHealth>> getRabbitHealthByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addRabbitHealthInfo(String dbName, String username, List<RabbitHealth> rabbitHealthList);
    ResponseMessage<Integer> deleteRabbitHealthInfo(String dbName, String username, List<String> id);
}
