package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitHealth;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitHealthService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔子健康信息记录表
 * @author: liu qinchang
 * @create: 2020-02-09 14:15
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class RabbitHealthController {
    @Autowired
    RabbitHealthService rabbitHealthService;
    
    /** 
    * @Description: 查询所有健康信息 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/2/9 
    */
    @GetMapping("/getAllRabbitHealthInfo")
    @ApiOperation(value = "查询所有健康信息")
    public ResponseMessage<PageInfo<RabbitHealth>> getAllRabbitHealthInfo(@PathVariable String dbName, @PathVariable String username,
                                                                          @RequestParam Integer page, @RequestParam Integer limit){
        log.info("getAllRabbitHealthInfo 传参， {}, {}, {}, {}", dbName, username, page, limit);
        ResponseMessage<PageInfo<RabbitHealth>> responseMessage = rabbitHealthService.getAllRabbitHealthInfo(dbName, username, page, limit);
        return responseMessage;
    }

    /**
    * @Description: 按照条件筛选健康信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/10
    */
    @GetMapping("/getRabbitInfoByCondition")
    @ApiOperation(value = "按照条件筛选健康信息")
    public ResponseMessage<PageInfo<RabbitHealth>> getRabbitInfoByCondition(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer page,
                                                                            @RequestParam Integer limit, @RequestParam String condition, @RequestParam String value){
        log.info("getRabbitInfoByCondition 传参, {},{},{},{},{},{}", dbName, username, page, limit, condition, value);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitHealth>> responseMessage = rabbitHealthService.getRabbitHealth(dbName, username, page, limit, condition, value);
        log.info("getRabbitInfoByCondition 耗时：{} ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    @PostMapping("/addRabbitHealthInfo")
    @ApiOperation(value = "添加健康信息")
    public ResponseMessage<Integer> addRabbitHealthInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitHealth> rabbitHealthList){
        log.info("addRabbitHealthInfo 传参, {},{},{}", dbName, username, rabbitHealthList);
        ResponseMessage<Integer> responseMessage = rabbitHealthService.addRabbitHealthInfo(dbName, username, rabbitHealthList);
        return responseMessage;
    }

    @DeleteMapping("/deleteRabbitHealthInfo")
    @ApiOperation(value = "删除健康信息")
    public ResponseMessage<Integer> deleteRabbitHealthInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> id){
        log.info("deleteRabbitHealthInfo 传参, {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = rabbitHealthService.deleteRabbitHealthInfo(dbName, username, id);
        return responseMessage;
    }


}
