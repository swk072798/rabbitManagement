package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitBreeding;
import java.util.List;

public interface RabbitBreedingMapper {
    int insert(RabbitBreeding record);

    List<RabbitBreeding> selectAll();
}