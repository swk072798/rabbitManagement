package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitBreeding;
import com.nwafu.databaseoprations.entity.RabbitBreedingPO;

import java.util.List;

public interface RabbitBreedingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_breeding
     *
     * @mbg.generated
     */
    int insert(List<RabbitBreedingPO> record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_breeding
     *
     * @mbg.generated
     */
    List<RabbitBreeding> selectAll();

    List<RabbitBreeding> selectByFemaleRabbit(String femaleRabbitNo);

    List<RabbitBreeding> selectByMaleRabbit(String maleRabbitNo);

    int deleteById(List<String> rabbitInfomationIds);

    int deleteByFemaleRabbit(String femaleRabitNo);

    int deleteByMaleRabbit(String maleRabitNo);
}