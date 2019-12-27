package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitHealth;
import java.util.List;

public interface RabbitHealthMapper {
    int insert(RabbitHealth record);

    List<RabbitHealth> selectAll();
}