package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitHouseBasicInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.RabbitHouseBasicInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 兔舍基本信息管理
 * @author: liu qinchang
 * @create: 2020-02-19 16:49
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class RabbitHouseBasicInfoController {
    @Autowired
    RabbitHouseBasicInfoService rabbitHouseBasicInfoService;

    /**
    * @Description: 查询全部兔舍信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/20
    */
    @GetMapping("/getAllBasicInfo")
    @ApiOperation(value = "查询所有信息")
    public ResponseMessage<PageInfo<RabbitHouseBasicInfo>> getAllBasicInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllBasicInfo  传参, {},{},{},{}",dbName, username, limit, page);
        ResponseMessage<PageInfo<RabbitHouseBasicInfo>> responseMessage = rabbitHouseBasicInfoService.selectAllInfo(dbName, username, limit, page);
        return responseMessage;
    }
    /**
    * @Description: 根据条件筛选兔舍信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/20
    */
    @GetMapping("/getBasicInfoByCondition")
    @ApiOperation(value = "按照条件查询信息")
    public ResponseMessage<PageInfo<RabbitHouseBasicInfo>> getBasicInfoByCondition(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit, @RequestParam Integer page, @RequestParam String condition, @RequestParam String value){
        log.info("getBasicInfoByCondition 传参， {},{},{},{}");
        ResponseMessage<PageInfo<RabbitHouseBasicInfo>> responseMessage = rabbitHouseBasicInfoService.selectInfoByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }
    
    /** 
    * @Description: 添加兔舍基本信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/2/21 
    */
    @PostMapping("/addBasicInfo")
    @ApiOperation(value = "添加兔舍基本信息")
    public ResponseMessage<Integer> addRabbitBasicInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitHouseBasicInfo> rabbitHouseBasicInfoList){
        log.info("addRabbitBasicInfo 传参, {},{},{}", dbName, username, rabbitHouseBasicInfoList);
        ResponseMessage<Integer> responseMessage = rabbitHouseBasicInfoService.addRabbitHouseBasicInfo(dbName, username, rabbitHouseBasicInfoList);
        return responseMessage;
    }

    /**
    * @Description: 删除兔舍基本信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/21
    */
    @DeleteMapping("/deleteBasicInfo")
    @ApiOperation(value = "删除兔舍基本信息")
    public ResponseMessage<Integer> deleteBasicInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<String> id){
        log.info("deleteBasicInfo 传参, {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = rabbitHouseBasicInfoService.deleteInfoById(dbName, username, id);
        return responseMessage;
    }
}
