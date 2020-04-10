package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.FarmInfomation;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.FarmInfomationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔场信息管理
 * @author: liu qinchang
 * @create: 2020-03-31 09:50
 **/

@RestController
@Slf4j
@RequestMapping("/{dbName}/{username}")
public class FarmInfomationController {

    @Autowired
    FarmInfomationService farmInfomationService;

    @GetMapping("/getAllFarmInfomation")
    @ApiOperation(value = "获取所有兔场信息")
    public ResponseMessage<PageInfo<FarmInfomation>> getAllFarmInfomation(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllFarmInfomation 传参, {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<FarmInfomation>> responseMessage = farmInfomationService.getAllFarmInfomation(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getFarmInfomationByCondition")
    @ApiOperation(value = "按照条件筛选兔场信息")
    public ResponseMessage<PageInfo<FarmInfomation>> getFarmInfomationByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                                  @RequestParam Integer limit, @RequestParam Integer page,
                                                                                  @RequestParam String condition, @RequestParam String value){
        log.info("getFarmInfomationByCondition 传参， {}，{}，{}，{}，{}，{}",dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<FarmInfomation>> responseMessage = farmInfomationService.getFarmInfomationByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addFarmInfomation")
    @ApiOperation(value = "新增兔场信息")
    public ResponseMessage<Integer> addFarmInfomation(@PathVariable String dbName, @PathVariable String username, @RequestBody List<FarmInfomation> farmInfomationList){
        log.info("addFarmInfomation 传参， {}，{}，{}", dbName, username, farmInfomationList);
        ResponseMessage<Integer> responseMessage = farmInfomationService.addFarmInfomation(dbName, username, farmInfomationList);
        return responseMessage;
    }

    @DeleteMapping("/deleteFarmInfomation")
    @ApiOperation(value = "删除兔场信息")
    public ResponseMessage<Integer> deleteFarmInfomation(@PathVariable String dbName, @PathVariable String username, @RequestBody List<String> uuid){
        log.info("deleteFarmInfomation 传参， {}，{}，{}", dbName, username, uuid);
        ResponseMessage<Integer> responseMessage = farmInfomationService.deleteFarmInfomation(dbName, username, uuid);
        return responseMessage;
    }
}
