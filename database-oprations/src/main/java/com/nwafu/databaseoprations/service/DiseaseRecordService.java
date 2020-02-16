package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIllness;
import com.nwafu.databaseoprations.entity.RabbitIllnessRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface DiseaseRecordService {
    ResponseMessage<PageInfo<RabbitIllness>> getIllnessByIllnessName(String dbName, String username, Integer page, Integer limit, String illnessName);
    ResponseMessage<PageInfo<RabbitIllness>> getAllIllness(String dbName, String username, Integer page, Integer limit);
    ResponseMessage<Integer> addIllnessInfo(String dbName, String username, List<RabbitIllness> rabbitIllnessList);
    ResponseMessage<Integer> deleteInfoById(String dbName, String username, List<String> id);

    ResponseMessage<PageInfo<RabbitIllnessRecord>> getAllRecord(String dbName, String username, Integer page, Integer limit);
    ResponseMessage<PageInfo<RabbitIllnessRecord>> getRecordByIllnessName(String dbName, String username, Integer page, Integer limit, String illnessName);
    ResponseMessage<Integer> addRabbitIllnessRecord(String dbName, String username, List<RabbitIllnessRecord> rabbitIllnessRecordList);
    ResponseMessage<Integer> deleteRecordById(String dbName, String username, List<String> id);
}
