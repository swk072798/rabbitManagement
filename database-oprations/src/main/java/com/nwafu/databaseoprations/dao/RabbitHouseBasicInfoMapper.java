package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RabbitHouseBasicInfoMapper {
    int insert(List<RabbitHouseBasicInfo> rabbitHouseBasicInfoList);
    List<RabbitHouseBasicInfo> selectAllInfo();
    List<RabbitHouseBasicInfo> selectInfoByCondition(String condition, String value);
    int deleteById(List<String> id);
}
