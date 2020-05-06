package com.nwafu.databaseoprations.service;

import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.vo.InventorySummary;

import java.util.List;


public interface InventorySummaryService {
    ResponseMessage<InventorySummary> getTotalRabbitByFarmName(String dbName, String username, String farmUuid, List<String> type);
}
