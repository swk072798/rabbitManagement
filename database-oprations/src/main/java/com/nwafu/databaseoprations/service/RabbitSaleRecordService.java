package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface RabbitSaleRecordService {
    ResponseMessage<PageInfo<RabbitSaleRecord>> selectAllRabbitSaleRecord(String dbName, String username, Integer limit, Integer page);
    ResponseMessage<PageInfo<RabbitSaleRecord>> selectRabbitSaleRecordByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> addRabbitSaleRecord(String dbName, String username, List<RabbitSaleRecord> rabbitSaleRecordList);
    ResponseMessage<Integer> deleteRabbitSaleRecord(String dbName, String username, List<String> id);
}
