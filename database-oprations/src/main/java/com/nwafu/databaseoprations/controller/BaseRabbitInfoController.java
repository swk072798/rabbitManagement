package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.Page;
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
public class BaseRabbitInfoController {

    @Autowired
    BaseRabbitInfoService baseRabbitInfoService;

    /** 
    * @Description: 分页获取所有种兔信息 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/3 
    */
    @GetMapping("/getAllRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(@RequestParam int page, @RequestParam int limit,
                                                                  @PathVariable String dbName){
        log.info("getAllRabbitInfo  参数： {}, {}, {}", page, limit, dbName);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage= baseRabbitInfoService.getAllRabbitInfo(page, limit, dbName);
        log.info("getAllRabbitInfo 执行完毕，耗时： {} ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /** 
    * @Description: 添加种兔信息 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/3 
    */
    @PostMapping("/insertRabbitInfo")
    public ResponseMessage<Integer> insertRabbitInfo(@PathVariable String dbName, @RequestBody List<RabbitInfo> rabbitInfoList){
        log.info("insertRabbitInfo  传参：{}", rabbitInfoList);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.insertRabbitInfo(dbName, rabbitInfoList);
        log.info("insertRabbitInfo  执行完步，耗时： {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /** 
    * @Description: 删除种兔信息 
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/3 
    */
    @DeleteMapping("/deleteRabbitInfo")
    public ResponseMessage<Integer> deleteRabbitInfo(@PathVariable String dbName, @RequestBody List<String> rabbitNoList){
        log.info("deleteRabbitInfo  参数：{},{}",dbName, rabbitNoList);
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.deleteRabbitInfo(dbName, rabbitNoList);
        return responseMessage;
    }
    
    /** 
    * @Description: 获取母兔信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/3 
    */
    @GetMapping("/getFamaleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getFamaleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit){
        log.info("getFamaleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if(dbName == null){
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getFemaleRabbit(dbName, page, limit);
        log.info("getFamaleRabbitInfo  调用完毕");
        return responseMessage;
    }

    /**
    * @Description: 获取公兔信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/3
    */
    @GetMapping("/getMaleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit){
        log.info("getMaleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if(dbName == null){
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getMaleRabbit(dbName, page, limit);
        log.info("getMaleRabbitInfo  调用完毕");
        return responseMessage;

    }

    /**
    * @Description: 获取仔兔信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/3
    */
    @GetMapping("/getLittleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getLittleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit) {
        log.info("getLittleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if (dbName == null) {
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getLittleFemaleRabbit(dbName, page, limit);
        log.info("getLittleRabbitInfo  调用完毕");
        return responseMessage;
    }


}
