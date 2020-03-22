package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitSaleRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitSaleRecordService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子销售记录登记表
 * @author: liu qinchang
 * @create: 2020-03-12 15:52
 **/
@RestController
@Slf4j
@RequestMapping("/{dbName}/{username}")
public class RabbitSaleRecordController {

    @Autowired
    RabbitSaleRecordService rabbitSaleRecordService;


    @GetMapping("/getAllRabbitSaleRecord")
    @ApiOperation(value = "获取所有兔子销售信息")
    public ResponseMessage<PageInfo<RabbitSaleRecord>> getAllRabbitSaleRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllRabbitSaleRecord 传参， {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<RabbitSaleRecord>> responseMessage = rabbitSaleRecordService.selectAllRabbitSaleRecord(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getRabbitSaleRecordByCondition")
    @ApiOperation(value = "根据条件筛选销售信息")
    public ResponseMessage<PageInfo<RabbitSaleRecord>> getRabbitSaleRecordByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                                      @RequestParam Integer limit, @RequestParam Integer page,
                                                                                      @RequestParam String condition, @RequestParam String value){
        log.info("getRabbitSaleRecordByCondition 传参, {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<RabbitSaleRecord>> responseMessage = rabbitSaleRecordService.selectRabbitSaleRecordByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addRabbitSaleRecord")
    @ApiOperation(value = "添加兔子销售记录")
    public ResponseMessage<Integer> addRabbitSaleRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitSaleRecord> rabbitSaleRecordList){
        log.info("addRabbitSaleRecord 传参，{},{},{}", dbName, username, rabbitSaleRecordList);
        ResponseMessage<Integer> responseMessage = rabbitSaleRecordService.addRabbitSaleRecord(dbName, username, rabbitSaleRecordList);
        return responseMessage;
    }

    @DeleteMapping("/deleteRabbitSaleRecord")
    @ApiOperation(value = "deleteRabbitSaleRecord")
    public ResponseMessage<Integer> deleteRabbitSaleRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<String> id){
        log.info("deleteRabbitSaleRecord 传参, {},{},{]", dbName, username, id);
        ResponseMessage<Integer> responseMessage = rabbitSaleRecordService.deleteRabbitSaleRecord(dbName, username, id);
        return responseMessage;
    }

}
