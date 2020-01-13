package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.FeedManageService;
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

@RestController
@RequestMapping("/{dbName}")
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
    @PostMapping("/addFeedInfo")
    public ResponseMessage<Integer> addFeedInfo(@PathVariable String dbName, @RequestBody List<RabbitIngredients> rabbitIngredients){
        log.info("addFeedInfo  参数:{},{}", dbName, rabbitIngredients);
        ResponseMessage<Integer> responseMessage = feedManageService.addFeedInfo(dbName, rabbitIngredients);
        return responseMessage;
    }

    /**
    * @Description: 查询所有饲料
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @GetMapping("/getAllFeedInfo")
    public ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(@RequestParam Integer limit,@RequestParam Integer page,@PathVariable String dbName){
        log.info("getAllFeedInfo  执行，参数：{},{},{}",limit, page, dbName);
        if(limit == null || page ==null || dbName == null){
            throw new RuntimeException("getAllFeedInfo 参数错误");
        }
        ResponseMessage<PageInfo<RabbitIngredients>> responseMessage = feedManageService.getAllFeedInfo(limit, page, dbName);
        return responseMessage;
    }

    /**
     * @Description: 按照名称查询饲料
     * @Param:
     * @return:
     * @Author: liu qinchang
     * @Date: 2020/1/13
     */
    @GetMapping("/getFeedInfoByName")
    public ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(@RequestParam Integer limit,@RequestParam Integer page, @RequestParam String feedType, @PathVariable String dbName){
        log.info("getFeedInfoByName  执行，参数：{},{},{},{}",limit, page, feedType, dbName);
        if(limit == null || page ==null || feedType == null ||dbName == null){
            throw new RuntimeException("getAllFeedInfo 参数错误");
        }
        ResponseMessage<PageInfo<RabbitIngredients>> responseMessage = feedManageService.getFeedInfoByName(limit, page, feedType, dbName);
        return responseMessage;
    }

    /**
    * @Description: 删除饲料信息
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @DeleteMapping("deleteFeedById")
    public ResponseMessage<Integer> deleteFeedById(@RequestParam List<String> deleteId, @PathVariable String dbName){
        log.info("deleteFeedById  入参： {},{}", deleteId, dbName);
        ResponseMessage responseMessage = feedManageService.deleteFeedInfo(deleteId, dbName);
        return responseMessage;
    }

}
