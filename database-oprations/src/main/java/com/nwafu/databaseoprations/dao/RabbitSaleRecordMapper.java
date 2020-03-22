package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RabbitSaleRecordMapper {
    List<RabbitSaleRecord> getAllRabbitSaleRecord();
    List<RabbitSaleRecord> getRabbitSaleRecordByCondition(String condition, String value);
    int insert(List<RabbitSaleRecord> rabbitSaleRecordList);
    int deleteRabbitSaleRecordById(List<String> id);
}
