package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitHouse;
import java.util.List;

public interface RabbitHouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_house
     *
     * @mbg.generated
     */
    int insert(RabbitHouse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_house
     *
     * @mbg.generated
     */
    List<RabbitHouse> selectAll();
}