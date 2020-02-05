package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.FeedManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 饲料管理controller
 * @author: liu qinchang
 * @create: 2020-01-03 16:18
 **/

@Api(value = "饲料管理")
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class FeedManageController {
    @Autowired
    FeedManageService feedManageService;

    /** 
    * @Description: 添加饲料
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/13 
    */
    @ApiOperation(value = "添加饲料")
    @PostMapping("/addFeedInfo")
    public ResponseMessage<Integer> addFeedInfo(@PathVariable String dbName, @RequestBody List<RabbitIngredients> rabbitIngredients, @PathVariable String username){
        log.info("addFeedInfo  参数:{},{}", dbName, rabbitIngredients);
        ResponseMessage<Integer> responseMessage = feedManageService.addFeedInfo(dbName, rabbitIngredients, username);
        return responseMessage;
    }

    /**
    * @Description: 查询所有饲料
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @ApiOperation(value = "查询所有饲料")
    @GetMapping("/getAllFeedInfo")
    public ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(@RequestParam Integer limit,@RequestParam Integer page,
                                                                       @PathVariable String dbName, @PathVariable String username){
        log.info("getAllFeedInfo  执行，参数：{},{},{}",limit, page, dbName);
        if(limit == null || page ==null || dbName == null){
            throw new RuntimeException("getAllFeedInfo 参数错误");
        }
        ResponseMessage<PageInfo<RabbitIngredients>> responseMessage = feedManageService.getAllFeedInfo(limit, page, dbName, username);
        return responseMessage;
    }

    /**
     * @Description: 按照名称查询饲料
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2020/1/13
     */
    @ApiOperation(value = "按照名称查询饲料")
    @GetMapping("/getFeedInfoByName")
    public ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(@RequestParam Integer limit,@RequestParam Integer page, @RequestParam String feedType,
                                                                          @PathVariable String dbName, @PathVariable String username){
        log.info("getFeedInfoByName  执行，参数：{},{},{},{}",limit, page, feedType, dbName);
        if(limit == null || page ==null || feedType == null ||dbName == null){
            throw new RuntimeException("getAllFeedInfo 参数错误");
        }
        ResponseMessage<PageInfo<RabbitIngredients>> responseMessage = feedManageService.getFeedInfoByName(limit, page, feedType, dbName, username);
        return responseMessage;
    }

    /**
    * @Description: 删除饲料信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @ApiOperation(value = "删除饲料信息")
    @DeleteMapping("deleteFeedById")
    public ResponseMessage<Integer> deleteFeedById(@RequestParam List<String> deleteId, @PathVariable String dbName, @PathVariable String username){
        log.info("deleteFeedById  入参： {},{}", deleteId, dbName);
        ResponseMessage responseMessage = feedManageService.deleteFeedInfo(deleteId, dbName, username);
        return responseMessage;
    }

}
