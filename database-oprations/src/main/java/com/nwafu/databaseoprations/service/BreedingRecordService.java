package com.nwafu.databaseoprations.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitBreeding;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface BreedingRecordService {
    ResponseMessage<Integer> insertBreedingRecord(String dbName, String username, List<RabbitBreeding> rabbitBreedingList);
    ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecord(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecordByFemaleRabbit(String dbName, String username, Integer limit, Integer page, String femaleRabbitNo);
    ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingRecordByMaleRabbit(String dbName, String username, Integer limit, Integer page, String maleRabbitNo);
    ResponseMessage<Integer> deleteBreedingRecord(String dbName, String username, List<String> breedingInfomationIdList);
    ResponseMessage<Integer> deleteBreedingRecordByFemaleRabbit(String dbName, String username, String femaleRabbitNo);
    ResponseMessage<Integer> deleteBreedingRecordByMaleRabbit(String dbName, String username, String maleRabbitNo);
    ResponseMessage<PageInfo<RabbitBreeding>> getBreedingRecordByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
}
