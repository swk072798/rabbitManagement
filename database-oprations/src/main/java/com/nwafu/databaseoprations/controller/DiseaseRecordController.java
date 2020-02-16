package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIllness;
import com.nwafu.databaseoprations.entity.RabbitIllnessRecord;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.DiseaseRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 疾病记录和疾病登记
 * @author: liu qinchang
 * @create: 2020-02-05 17:38
 **/
@Slf4j
@RestController
@RequestMapping("/{dbName}/{username}")
public class DiseaseRecordController {

    @Autowired
    DiseaseRecordService diseaseRecordService;


    /**
    * @Description: 查询全部疾病
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/7
    */
    @ApiOperation(value = "查询所有疾病信息")
    @GetMapping("/getAllRabbitIllnessInfo")
    public ResponseMessage<PageInfo<RabbitIllness>> getAllRabbitIllnessInfo(@PathVariable String dbName, @PathVariable String username,
                                                               @RequestParam Integer page, @RequestParam Integer limit){
        log.info("getAllRabbitIllnessInfo 传参， {}，{}，{}，{}", dbName, username, page, limit);
        ResponseMessage<PageInfo<RabbitIllness>> responseMessage = diseaseRecordService.getAllIllness(dbName, username, page, limit);
        return responseMessage;
    }

    /**
    * @Description:  按照名称查询疾病信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/7
    */
    @ApiOperation(value = "根据疾病名称查询")
    @GetMapping("/getRabbitIllnessInfoByName")
    public ResponseMessage<PageInfo<RabbitIllness>> getRabbitIllnessInfoByName(@PathVariable String dbName, @PathVariable String username,
                                                                               @RequestParam Integer page, @RequestParam Integer limit, @RequestParam String illnessName){
        log.info("getRabbitIllnessInfoByName 传参，{}，{}，{}，{}，{}",dbName, username, page, limit, illnessName);
        ResponseMessage<PageInfo<RabbitIllness>> responseMessage = diseaseRecordService.getIllnessByIllnessName(dbName, username, page, limit, illnessName);
        return responseMessage;
    }

    /**
    * @Description: 添加疾病信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/8
    */
    @ApiOperation(value = "添加疾病信息")
    @PostMapping("/addRabbitIllnessInfo")
    public ResponseMessage<Integer> addRabbitIllnessInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitIllness> rabbitIllnessList){
        log.info("addRabbitIllnessInfo 传参， {},{},{},", dbName, username, rabbitIllnessList);
        ResponseMessage<Integer> responseMessage = diseaseRecordService.addIllnessInfo(dbName, username, rabbitIllnessList);
        return responseMessage;
    }

    /**
    * @Description: 删除疾病信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/8
    */
    @ApiOperation(value = "删除疾病信息")
    @DeleteMapping("/deleteRabbitIllnessInfo")
    public ResponseMessage<Integer> deleteRabbitIllnessInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> id){
        log.info("deleteRabbitIllnessInfo 传参, {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = diseaseRecordService.deleteInfoById(dbName, username, id);
        return responseMessage;
    }
    
    /** 
    * @Description: 查看所有兔子疾病记录
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/2/8 
    */
    @ApiOperation(value = "查询所有兔子患病记录")
    @GetMapping("/getAllRecord")
    public ResponseMessage<PageInfo<RabbitIllnessRecord>> getAllRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer page, @RequestParam Integer limit){
        log.info("getAllRecord 传参, {}, {}, {}, {}", dbName, username, page, limit);
        ResponseMessage<PageInfo<RabbitIllnessRecord>> responseMessage = diseaseRecordService.getAllRecord(dbName, username, page, limit);
        return responseMessage;
    }
    
    /** 
    * @Description: 按照疾病名称查询患病
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/2/8 
    */
    @ApiOperation(value = "按照疾病名称查询兔子患病记录")
    @GetMapping("/getRecordByName")
    public ResponseMessage<PageInfo<RabbitIllnessRecord>> getRecordByName(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit,
                                                                          @RequestParam Integer page, @RequestParam String illnessName){
        log.info("getRecordByName 传参, {},{},{},{}", dbName, username, limit, page, illnessName);
        ResponseMessage<PageInfo<RabbitIllnessRecord>> responseMessage = diseaseRecordService.getRecordByIllnessName(dbName, username, limit, page, illnessName);
        return responseMessage;
    }

    /**
    * @Description: 添加兔子患病记录
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/8
    */
    @ApiOperation(value = "添加兔子患病信息")
    @PostMapping("/addRabbitIllnessRecord")
    public ResponseMessage<Integer> addRabbitIllnessRecord(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitIllnessRecord> rabbitIllnessRecordList){
        log.info("addRabbitIllnessRecord 传参, {},{},{}", dbName, username, rabbitIllnessRecordList);
        ResponseMessage<Integer> responseMessage = diseaseRecordService.addRabbitIllnessRecord(dbName, username, rabbitIllnessRecordList);
        return responseMessage;
    }

    /**
    * @Description: 删除兔子患病记录
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/2/8
    */
    @ApiOperation(value = "删除兔子患病信息")
    @PostMapping("/deleteRabbitIllnessRecord")
    public ResponseMessage<Integer> deleteRabbitIllnessRecord(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> id){
        log.info("deleteRabbitIllnessRecord 传参， {},{},{}", dbName, username,id);
        ResponseMessage<Integer> responseMessage = diseaseRecordService.deleteRecordById(dbName, username, id);
        return responseMessage;
    }

}
