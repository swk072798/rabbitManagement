package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitDynamicInformation;
import java.util.List;

public interface RabbitDynamicInformationMapper {
    int insert(RabbitDynamicInformation record);

    List<RabbitDynamicInformation> selectAll();
}