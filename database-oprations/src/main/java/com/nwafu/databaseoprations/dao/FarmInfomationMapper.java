package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.FarmInfomation;
import java.util.List;

public interface FarmInfomationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table farm_infomation
     *
     * @mbg.generated
     */
    int insert(FarmInfomation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table farm_infomation
     *
     * @mbg.generated
     */
    List<FarmInfomation> selectAll();
}