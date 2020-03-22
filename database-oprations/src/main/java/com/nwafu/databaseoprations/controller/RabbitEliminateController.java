package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitEliminate;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitEliminateService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子淘汰信息管理
 * @author: liu qinchang
 * @create: 2020-03-22 15:57
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class RabbitEliminateController {

    @Autowired
    RabbitEliminateService rabbitEliminateService;

    @GetMapping("/getAllRabbitEliminateRecord")
    @ApiOperation(value = "获取所有兔子淘汰信息")
    public ResponseMessage<PageInfo<RabbitEliminate>> getAllRabbitEliminateRecord(@PathVariable String dbName, @PathVariable String username,
                                                                                  @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllRabbitEliminateRecord 传参: {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<RabbitEliminate>> responseMessage = rabbitEliminateService.getAllRabbitEliminateRecord(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getRabbitEliminateRecordByCondition")
    @ApiOperation(value = "获取所有兔子淘汰信息")
    public ResponseMessage<PageInfo<RabbitEliminate>> getRabbitEliminateRecordByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                                          @RequestParam Integer limit, @RequestParam Integer page,
                                                                                          @RequestParam String condition, @RequestParam String value){
        log.info("getRabbitEliminateRecordByCondition 传参： {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<RabbitEliminate>> responseMessage = rabbitEliminateService.getRabbitEliminateRecordByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addRabbitEliminateRecord")
    @ApiOperation(value = "添加兔子淘汰信息")
    public ResponseMessage<Integer> addRabbitEliminateRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitEliminate> rabbitEliminateList){
        log.info("addRabbitEliminateRecord 传参 : {},{},{}", dbName, username, rabbitEliminateList);
        ResponseMessage<Integer> responseMessage = rabbitEliminateService.addRabbitEliminateRecord(dbName, username, rabbitEliminateList);
        return responseMessage;
    }

    @DeleteMapping("/deleteRabbitEliminateRecord")
    @ApiOperation(value = "删除兔子淘汰信息")
    public ResponseMessage<Integer> deleteRabbitEliminateRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<String> id){
        log.info("deleteRabbitEliminateRecord 传参: {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = rabbitEliminateService.deleteRabbitEliminateRecord(dbName, username, id);
        return responseMessage;
    }
}
