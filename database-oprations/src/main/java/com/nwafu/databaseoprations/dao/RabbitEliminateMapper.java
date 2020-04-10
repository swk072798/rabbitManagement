package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitEliminate;

import java.util.List;

public interface RabbitEliminateMapper {
    int insert(List<RabbitEliminate> rabbitEliminateList);
    List<RabbitEliminate> selectAll();
    List<RabbitEliminate> selectRabbitEliminateRecordByCondition(String condition, String value);
    int deleteById(List<String> id);
}
