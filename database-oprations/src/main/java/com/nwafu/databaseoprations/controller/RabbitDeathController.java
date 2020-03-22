package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitDeath;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitDeathService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子死亡记录
 * @author: liu qinchang
 * @create: 2020-03-09 20:53
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
@Api(value = "兔子死亡记录")
public class RabbitDeathController {
    @Autowired
    RabbitDeathService rabbitDeathService;

    @GetMapping("/selectAllRabbitDeathInfo")
    @ApiOperation("查询全部兔子死亡信息")
    public ResponseMessage<PageInfo<RabbitDeath>> selectAllRabbitDeathInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("selectAllRabbitDeathInfo 传参，{},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<RabbitDeath>> responseMessage = rabbitDeathService.getAllRabbitDeathInfo(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/selectRabbitDeathInfoByCondition")
    @ApiOperation("按照条件筛选死亡信息")
    public ResponseMessage<PageInfo<RabbitDeath>> selectRabbitDeathInfoByCondition(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page, @RequestParam String condition, @RequestParam String value){
        log.info("selectRabbitDeathInfoByCondition  传参， {},{},{},{},{},{}",dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<RabbitDeath>> responseMessage = rabbitDeathService.getRabbitDeathInfoByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addRabbitDeathInfo")
    @ApiOperation(value = "添加兔子死亡信息")
    public ResponseMessage<Integer> addRabbitDeathInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitDeath> rabbitDeathList){
        log.info("addRabbitDeathInfo  传参, {},{},{}", dbName, username,rabbitDeathList);
        ResponseMessage<Integer> responseMessage = rabbitDeathService.addRabbitDeathInfo(dbName, username, rabbitDeathList);
        return responseMessage;
    }

    @DeleteMapping("/deleteRabbitDeathInfo")
    @ApiOperation(value = "删除兔子死亡信息")
    public ResponseMessage<Integer> deleteRabbitDeathInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<String> id){
        log.info("deleteRabbitDeathInfo 传参, {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = rabbitDeathService.deleteRabbitDeathInfo(dbName, username, id);
        return responseMessage;
    }
}
