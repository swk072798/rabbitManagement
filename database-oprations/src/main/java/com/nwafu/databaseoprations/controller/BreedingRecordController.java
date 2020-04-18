package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitBreeding;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.BreedingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: rabbitManagement
 * @description: 繁殖信息管理
 * @author: liu qinchang
 * @create: 2020-01-15 11:13
 **/

@Api(value = "繁殖信息管理")
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class BreedingRecordController {

    @Autowired
    BreedingRecordService breedingRecordService;

    /** 
    * @Description: 查询所有繁殖信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/15 
    */
    @ApiOperation(value = "查询所有繁殖信息")
    @GetMapping("/selectAllBreedingInfo")
    public ResponseMessage<PageInfo<RabbitBreeding>> selectAllBreedingInfo(@PathVariable String dbName, @PathVariable String username, @RequestParam int limit,
                                                                           @RequestParam int page){
        log.info("selectAllBreedingInfo  入参:{}, {}, {}, {}", dbName, username, limit, page);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = breedingRecordService.selectBreedingRecord(dbName, username, limit, page);
        log.info("selectAllBreedingInfo 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /**
    * @Description: 根据母兔信息查询繁殖信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/15
    */
    @ApiOperation(value = "根据母兔信息查询繁殖信息")
    @GetMapping("/selectBreedingByFemaleRabbitNo")
    public ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingByFemaleRabbitNo(@PathVariable String dbName, @PathVariable String username, @RequestParam int limit,
                                                                                    @RequestParam int page, @RequestParam String femaleRabbitNo){
        log.info("selectBreedingByFemaleRabbitNo  入参:{}, {}, {}, {}, {}", dbName, username, limit, page, femaleRabbitNo);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = breedingRecordService.selectBreedingRecordByFemaleRabbit(dbName, username, limit, page, femaleRabbitNo);
        log.info("selectBreedingByFemaleRabbitNo 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /**
    * @Description: 根据公兔查询繁殖信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/15
    */
    @ApiOperation(value = "根据公兔查询繁殖信息")
    @GetMapping("/selectBreedingByMaleRabbitNo")
    public ResponseMessage<PageInfo<RabbitBreeding>> selectBreedingByMaleRabbitNo(@PathVariable String dbName, @PathVariable String username, @RequestParam int limit,
                                                                                  @RequestParam int page, @RequestParam String maleRabbitNo){
        log.info("selectBreedingByMaleRabbitNo  入参:{}, {}, {}, {}, {}", dbName, username, limit, page, maleRabbitNo);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = breedingRecordService.selectBreedingRecordByMaleRabbit(dbName, username, limit, page, maleRabbitNo);
        log.info("selectBreedingByMaleRabbitNo 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }
    
    /** 
    * @Description: 新增繁殖信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/15 
    */
    @ApiOperation(value = "新增繁殖信息")
    @PostMapping("/insertBreedingInfo")
    public ResponseMessage<Integer> insertBreedingInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<RabbitBreeding> rabbitBreedingList){
        log.info("insertBreedingInfo  入参:{}, {}, {}", dbName, username, rabbitBreedingList);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = breedingRecordService.insertBreedingRecord(dbName, username, rabbitBreedingList);
        log.info("insertBreedingInfo 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }
    
    /** 
    * @Description: 根据id删除繁殖信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/15 
    */
    @ApiOperation(value = "根据id删除繁殖信息")
    @DeleteMapping("/deleteBreedingRecordById")
    public ResponseMessage<Integer> deleteBreedingRecordById(@PathVariable String dbName, @PathVariable String username, @RequestParam List<String> deleteId){
        log.info("deleteBreedingRecordById  入参:{}, {}, {}", dbName, username, deleteId);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = breedingRecordService.deleteBreedingRecord(dbName, username, deleteId);
        log.info("deleteBreedingRecordById 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /**
     * @Description: 根据母兔删除繁殖信息
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2020/1/15
     */
    @ApiOperation(value = "根据母兔删除繁殖信息")
    @DeleteMapping("/deleteBreedingRecordByFemaleRabbit")
    public ResponseMessage<Integer> deleteBreedingRecordByFemaleRabbit(@PathVariable String dbName, @PathVariable String username, @RequestParam String femaleRabbit){
        log.info("deleteBreedingRecordByFemaleRabbit  入参:{}, {}, {}", dbName, username, femaleRabbit);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = breedingRecordService.deleteBreedingRecordByFemaleRabbit(dbName, username, femaleRabbit);
        log.info("deleteBreedingRecordByFemaleRabbit 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    /**
     * @Description: 根据公兔删除繁殖信息
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2020/1/15
     */
    @ApiOperation(value = "根据公兔删除繁殖信息")
    @DeleteMapping("/deleteBreedingRecordByMaleRabbit")
    public ResponseMessage<Integer> deleteBreedingRecordByMaleRabbit(@PathVariable String dbName, @PathVariable String username, @RequestParam String maleId){
        log.info("deleteBreedingRecordByMaleRabbit  入参:{}, {}, {}", dbName, username, maleId);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = breedingRecordService.deleteBreedingRecordByMaleRabbit(dbName, username, maleId);
        log.info("deleteBreedingRecordByMaleRabbit 执行时间: {}ms", System.currentTimeMillis() - startTime);
        return responseMessage;
    }

    @GetMapping("/getBreedingRecordByCondition")
    @ApiOperation(value = "按照条件筛选信息")
    public ResponseMessage<PageInfo<RabbitBreeding>> getBreedingRecordByCondition(@PathVariable String dbName, @PathVariable String username, @RequestParam Integer limit,
                                                                                  @RequestParam Integer page, @RequestParam String condition, @RequestParam String value){
        log.info("getBreedingRecordByCondition 传参：{}，{}，{}，{}，{}，{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<RabbitBreeding>> responseMessage = breedingRecordService.getBreedingRecordByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }
    
    
}
