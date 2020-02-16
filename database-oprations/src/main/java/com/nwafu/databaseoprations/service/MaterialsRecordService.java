package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitMaterialsRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface MaterialsRecordService {
    ResponseMessage<PageInfo<RabbitMaterialsRecord>> getAllMaterialsRecord(String dbName, String username, Integer page, Integer limit);
    ResponseMessage<PageInfo<RabbitMaterialsRecord>> getMaterialsRecordByFeedType(String dbName, String username, Integer page, Integer limit, String feedType);
    ResponseMessage<Integer> addMaterialsRecord(String dbName, String username, List<RabbitMaterialsRecord> rabbitMaterialsRecordList);
    ResponseMessage<Integer> deleteRecordById(String dbName, String username, List<String> id);
}
