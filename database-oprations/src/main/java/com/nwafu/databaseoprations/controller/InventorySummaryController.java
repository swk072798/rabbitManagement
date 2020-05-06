package com.nwafu.databaseoprations.controller;

import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.InventorySummaryService;
import com.nwafu.databaseoprations.vo.InventorySummary;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 存栏统计controller
 * @author: liu qinchang
 * @create: 2020-04-29 10:53
 **/

@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class InventorySummaryController {

    @Autowired
    InventorySummaryService inventorySummaryService;

    @GetMapping("/getInventorySummary")
    @ApiOperation(value = "存栏汇总")
    public ResponseMessage<InventorySummary> getInventorySummary(@PathVariable String dbName, @PathVariable String username,
                                                                 @RequestParam String farmUuid, @RequestParam List<String> type){
        log.info("getInventorySummary 传参： {}，{}，{}，{}",dbName, username,farmUuid, type);
        ResponseMessage<InventorySummary> responseMessage = inventorySummaryService.getTotalRabbitByFarmName(dbName, username, farmUuid, type);
        return responseMessage;
    }
}
