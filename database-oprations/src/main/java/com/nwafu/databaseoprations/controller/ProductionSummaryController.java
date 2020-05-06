package com.nwafu.databaseoprations.controller;

import com.netflix.discovery.converters.Auto;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.ProductionSummaryService;
import com.nwafu.databaseoprations.vo.RabbitHouseProductionSummary;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 生产汇总
 * @author: liu qinchang
 * @create: 2020-05-01 14:14
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class ProductionSummaryController {
    @Autowired
    ProductionSummaryService productionSummaryService;

    @GetMapping("/getRabbitHouseProductionSummary")
    @ApiOperation(value = "兔舍生产汇总")
    public ResponseMessage<List<RabbitHouseProductionSummary>> getRabbitHouseProductionSummary(@PathVariable String dbName, @PathVariable String username,
                                                                                               @RequestParam String startDate, @RequestParam String endDate,
                                                                                               @RequestParam String farmUuid){
        log.info("getRabbitHouseProductionSummary 传参:{},{},{},{}", dbName, username, startDate, endDate);
        ResponseMessage<List<RabbitHouseProductionSummary>> responseMessage = productionSummaryService.rabbitHouseProductionSummary(dbName, username, farmUuid, startDate, endDate);
        return responseMessage;
    }

}
