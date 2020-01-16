package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIllness;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface IllnessRecordService {
    ResponseMessage<Integer> insertIllness(String dbName, String username, List<RabbitIllness> rabbitIllnesses);
    ResponseMessage<PageInfo<RabbitIllness>> selectAllIllness(String dbName, String username, int page, int limit);
    ResponseMessage<Integer> deleteIllness(String dbName, String username, List<String> id);
}
