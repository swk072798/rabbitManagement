package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitHouse;
import java.util.List;

public interface RabbitHouseMapper {
    int insert(RabbitHouse record);

    List<RabbitHouse> selectAll();
}