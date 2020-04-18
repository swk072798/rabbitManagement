package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RabbitInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_info
     *
     * @mbg.generated
     */
    int insert(List<RabbitInfo> record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_info
     *
     * @mbg.generated
     */
    List<RabbitInfo> selectAll();

    int deleteRabbitInfoByRabbitNo(List<String> rabbitNoList);

    List<RabbitInfo> getFamaleRabbitInfo();

    List<RabbitInfo> getMaleRabbitInfo();

    List<RabbitInfo> getLittleRabbitInfo();

    List<String> getAllRabbitNo();

    List<RabbitInfo> getRabbitInfoByCondition(String condition, String value);
}