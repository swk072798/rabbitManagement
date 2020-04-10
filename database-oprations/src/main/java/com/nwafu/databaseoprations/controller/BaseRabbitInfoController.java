package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import com.nwafu.databaseoprations.entity.RabbitInfo;
import com.nwafu.databaseoprations.entity.RabbitInfoVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.entity.UserCacheInfo;
import com.nwafu.databaseoprations.redis.RedisUtils;
import com.nwafu.databaseoprations.service.BaseRabbitInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * @program: rabbitmanagement
 * @description: 添加种兔基本信息controller
 * @author: liu qinchang
 * @create: 2020-01-02 15:21
 **/

@Api(value = "种兔基本信息操作接口")
@RestController
@Slf4j
@RequestMapping("/{dbName}/{username}")
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
    @ApiOperation(value = "分页获取所有种兔信息", notes = "分页获取所有种兔信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "页码"), @ApiImplicitParam(name = "limit", value = "每页显示几个"),
                        @ApiImplicitParam(name = "dbName", value = "数据库名称"), @ApiImplicitParam(name = "username", value = "用户名")})
    @GetMapping("/getAllRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getAllRabbitInfo(@RequestParam int page, @RequestParam int limit,
                                                                  @PathVariable String dbName, @PathVariable String username){
        log.info("getAllRabbitInfo  参数： {}, {}, {}", page, limit, dbName);
        long startTime = System.currentTimeMillis();
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage= baseRabbitInfoService.getAllRabbitInfo(page, limit, dbName, username);
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
    @ApiOperation(value = "添加种兔信息")
    @PostMapping("/insertRabbitInfo")
    public ResponseMessage<Integer> insertRabbitInfo(@PathVariable String dbName, @RequestBody List<RabbitInfoVO> rabbitInfoList, @PathVariable String username){
        log.info("insertRabbitInfo  传参：{}", rabbitInfoList);
        long startTime = System.currentTimeMillis();
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.insertRabbitInfo(dbName, rabbitInfoList, username);
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
    @ApiOperation(value = "删除种兔信息")
    @DeleteMapping("/deleteRabbitInfo")
    public ResponseMessage<Integer> deleteRabbitInfo(@PathVariable String dbName, @RequestBody List<String> rabbitNoList, @PathVariable String username){
        log.info("deleteRabbitInfo  参数：{},{}",dbName, rabbitNoList);
        ResponseMessage<Integer> responseMessage = baseRabbitInfoService.deleteRabbitInfo(dbName, rabbitNoList, username);
        return responseMessage;
    }
    
    /** 
    * @Description: 获取母兔信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/3 
    */
    @ApiOperation(value = "获取母兔信息")
    @GetMapping("/getFamaleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getFamaleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit, @PathVariable String username){
        log.info("getFamaleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if(dbName == null){
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getFemaleRabbit(dbName, page, limit, username);
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
    @ApiOperation(value = "获取公兔信息")
    @GetMapping("/getMaleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getMaleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit, @PathVariable String username){
        log.info("getMaleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if(dbName == null){
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getMaleRabbit(dbName, page, limit, username);
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
    @ApiOperation(value = "获取仔兔信息")
    @GetMapping("/getLittleRabbitInfo")
    public ResponseMessage<PageInfo<RabbitInfo>> getLittleRabbitInfo(@PathVariable String dbName, @RequestParam int page, @RequestParam int limit, @PathVariable String username) {
        log.info("getLittleRabbitInfo  参数：{},{},{}", dbName, page, limit);
        if (dbName == null) {
            throw new RuntimeException("dbName 不能为空");
        }
        ResponseMessage<PageInfo<RabbitInfo>> responseMessage = baseRabbitInfoService.getLittleFemaleRabbit(dbName, page, limit, username);
        log.info("getLittleRabbitInfo  调用完毕");
        return responseMessage;
    }


}
