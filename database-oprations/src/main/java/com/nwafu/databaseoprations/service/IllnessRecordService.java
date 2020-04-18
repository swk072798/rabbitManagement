package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIllness;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface IllnessRecordService {
    ResponseMessage<PageInfo<RabbitIllness>> selectAllIllness(String dbName, String username, Integer page, Integer limit);
    ResponseMessage<PageInfo<RabbitIllness>>selectAllIllnessByCondition(String dbName, String username, Integer page, Integer limit, String condition, String value);
    ResponseMessage<Integer> insertIllness(String dbName, String username, List<RabbitIllness> rabbitIllnesses);
    ResponseMessage<Integer> deleteIllness(String dbName, String username, List<String> id);
}
