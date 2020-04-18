package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.nwafu.databaseoprations.entity.RabbitMaterialsRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.MaterialsRecordService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 饲料出库记录
 * @author: liu qinchang
 * @create: 2020-02-11 14:50
 **/

@RestController
@Slf4j
@RequestMapping("/{dbName}/{username}")
public class MaterialsRecordController {

    @Autowired
    MaterialsRecordService materialsRecordService;

    @GetMapping("/getAllMaterialsRecord")
    @ApiOperation(value = "查询所有饲料出库信息")
    public ResponseMessage<PageInfo<RabbitMaterialsRecord>> getAllMaterialsRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllMaterialsRecord 传参， {}，{}，{}，{}",dbName, username, limit, page);
        ResponseMessage<PageInfo<RabbitMaterialsRecord>> responseMessage = materialsRecordService.getAllMaterialsRecord(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getMaterialsRecordByFeedType")
    @ApiOperation(value = "按照饲料名称查询饲料出库信息")
    public ResponseMessage<PageInfo<RabbitMaterialsRecord>> getMaterialsRecordByFeedType(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit,
                                                                                         @RequestParam Integer page, @RequestParam String feedType){
        log.info("getMaterialsRecordByFeedType 传参, {}, {}, {}, {}, {}", dbName, username, limit, page, feedType);
        ResponseMessage<PageInfo<RabbitMaterialsRecord>> responseMessage = materialsRecordService.getMaterialsRecordByFeedType(dbName, username, limit, page, feedType);
        return responseMessage;
    }

    @PostMapping("/addMaterialsRecord")
    @ApiOperation(value = "添加饲料记录")
    public ResponseMessage<Integer> addMaterialsRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitMaterialsRecord> rabbitMaterialsRecordList){
        log.info("addMaterialsRecord 传参, {},{},{}", dbName, username, rabbitMaterialsRecordList);
        ResponseMessage<Integer> responseMessage = materialsRecordService.addMaterialsRecord(dbName, username, rabbitMaterialsRecordList);
        return responseMessage;
    }

    @DeleteMapping("/deleteMaterialsRecord")
    @ApiOperation(value = "删除饲料记录")
    public ResponseMessage<Integer> deleteMaterialsRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> id){
        log.info("deleteMaterialsRecord 传参, {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = materialsRecordService.deleteRecordById(dbName, username, id);
        return responseMessage;
    }

    @GetMapping("/getMaterialsRecord")
    @ApiOperation(value = "按照条件筛选饲料信息")
    public ResponseMessage<PageInfo<RabbitMaterialsRecord>> getMaterialsRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit,
                                                                               @RequestParam Integer page, @RequestParam String condition, @RequestParam String value){
        log.info("getMaterialsRecord 传参: {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<RabbitMaterialsRecord>> responseMessage = materialsRecordService.getMaterialsRecordByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

}
