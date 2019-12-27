package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.FarmInfomation;
import java.util.List;

public interface FarmInfomationMapper {
    int insert(FarmInfomation record);

    List<FarmInfomation> selectAll();
}