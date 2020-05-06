package com.nwafu.databaseoprations.service;

import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.vo.RabbitHouseProductionSummary;

import java.util.List;

public interface ProductionSummaryService {
    ResponseMessage<List<RabbitHouseProductionSummary>> rabbitHouseProductionSummary(String dbName, String username, String farmUuid, String startDate, String endDate);
}
