package com.nwafu.databaseoprations.controller;

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


    @PostMapping("/addFeedInfo")
    public ResponseMessage<Integer> addFeedInfo(@PathVariable String dbName, @RequestBody List<RabbitIngredients> rabbitIngredients){
        log.info("addFeedInfo  参数:{},{}", dbName, rabbitIngredients);
        ResponseMessage<Integer> responseMessage = feedManageService.addFeedInfo(dbName, rabbitIngredients);
        return responseMessage;
    }

}
