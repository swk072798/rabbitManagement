package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitDeath;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RabbitDeathMapper {
    List<RabbitDeath> selectAll();

    List<RabbitDeath> selectByCondition(String condition, String value);

    int insert(List<RabbitDeath> rabbitDeathList);

    int deleteRabbitDeathInfo(List<String> id);

    int getDeathCount(String rabbitHouseNo, String startDate, String endDate);
}
