package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.netflix.discovery.converters.Auto;
import com.nwafu.databaseoprations.entity.RabbitDynamicInformation;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitDynamicInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子动态信息管理
 * @author: liu qinchang
 * @create: 2020-02-14 15:22
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class RabbitDynamicInfoController {
    @Autowired
    RabbitDynamicInfoService rabbitDynamicInfoService;

    @GetMapping("/getAllDynamicInfo")
    public ResponseMessage<PageInfo<RabbitDynamicInformation>> getAllDynamicInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllDynamicInfo 传参, {},{},{},{}", dbName,username, limit, page);
        ResponseMessage<PageInfo<RabbitDynamicInformation>> responseMessage = rabbitDynamicInfoService.getAllRabbitDynamicInfo(dbName,username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getDynamicInfoByRabbitNo")
    public ResponseMessage<PageInfo<RabbitDynamicInformation>> getDynamicInfoByRabbitNo(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page, @RequestParam String rabbitNo){
        log.info("getDynamicInfoByRabbitNo 传参, {},{},{},{},{}", dbName, username, limit, page, rabbitNo);
        ResponseMessage<PageInfo<RabbitDynamicInformation>> responseMessage = rabbitDynamicInfoService.getDynamicInfoByNo(dbName, username, limit, page, rabbitNo);
        return responseMessage;
    }

    @PostMapping("/addDynamicInfo")
    public ResponseMessage<Integer> addDynamicInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitDynamicInformation> rabbitDynamicInformationList){
        log.info("addDynamicInfo 传参, {},{},{}", dbName, username, rabbitDynamicInformationList);
        ResponseMessage<Integer> responseMessage = rabbitDynamicInfoService.addRabbitDynamicInfo(dbName, username, rabbitDynamicInformationList);
        return responseMessage;
    }

    @DeleteMapping("deleteDynamicInfo")
    public ResponseMessage<Integer> deleteDynamicInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> rabbitNo){
        log.info("deleteDynamicInfo 传参, {},{},{}");
        ResponseMessage<Integer> responseMessage = rabbitDynamicInfoService.deleteRabbitDynamicInfo(dbName, username, rabbitNo);
        return responseMessage;
    }
}
