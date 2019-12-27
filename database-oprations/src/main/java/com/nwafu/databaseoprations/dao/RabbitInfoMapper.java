package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import java.util.List;

public interface RabbitInfoMapper {
    int insert(RabbitInfo record);

    List<RabbitInfo> selectAll();
}