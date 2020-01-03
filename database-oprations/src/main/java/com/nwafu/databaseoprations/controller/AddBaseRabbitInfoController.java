package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.BaseRabbitInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: rabbitmanagement
 * @description: 添加种兔基本信息controller
 * @author: liu qinchang
 * @create: 2020-01-02 15:21
 **/

@RestController
@Slf4j
@RequestMapping("/{dbName}")
public class AddBaseRabbitInfoController {

    @Autowired
    BaseRabbitInfoService baseRabbitInfoService;

    @GetMapping("/getAllRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(@RequestParam int page, @RequestParam int limit,
                                                                  @PathVariable String dbName){
        log.info("getAllRabbitInfo  参数： {}, {}, {}", page, limit, dbName);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage= baseRabbitInfoService.getAllRabbitInfo(page, limit, dbName);
        log.info("getAllRabbitInfo 执行完毕，耗时： {} ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    @PostMapping("/insertRabbitInfo")
    public ResponseMessage<Integer> insertRabbitInfo(@PathVariable String dbName, @RequestBody List<RabbitInfo> rabbitInfoList){
        log.info("insertRabbitInfo  传参：{}", rabbitInfoList);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.insertRabbitInfo(dbName, rabbitInfoList);
        log.info("insertRabbitInfo  执行完步，耗时： {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    @DeleteMapping("/deleteRabbitInfo")
    public ResponseMessage<Integer> deleteRabbitInfo(@PathVariable String dbName, @RequestBody List<String> rabbitNoList){
        log.info("deleteRabbitInfo  参数：{},{}",dbName, rabbitNoList);
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.deleteRabbitInfo(dbName, rabbitNoList);
        return responseMessage;
    }

}
