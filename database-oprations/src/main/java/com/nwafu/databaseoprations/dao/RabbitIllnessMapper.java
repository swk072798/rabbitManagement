package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitIllness;
import java.util.List;

public interface RabbitIllnessMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_illness
     *
     * @mbg.generated
     */
    int insert(RabbitIllness record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_illness
     *
     * @mbg.generated
     */
    List<RabbitIllness> selectAll();
}