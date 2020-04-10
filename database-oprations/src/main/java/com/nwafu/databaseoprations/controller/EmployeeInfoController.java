package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.EmployeeInfo;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.EmployeeInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @program: rabbitManagement
 * @description: 员工基本信息管理
 * @author: liu qinchang
 * @create: 2020-04-04 11:40
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class EmployeeInfoController {

    @Autowired
    EmployeeInfoService employeeInfoService;


    @GetMapping("/getAllEmployeeInfo")
    @ApiOperation(value = "获取所有员工基本信息")
    public ResponseMessage<PageInfo<EmployeeInfo>> getAllEmployeeInfo(@PathVariable String dbName, @PathVariable String username,
                                                                      @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllEmployeeInfo 传参: {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<EmployeeInfo>> responseMessage = employeeInfoService.getAllEmployeeInfo(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getEmployeeInfoByCondition")
    @ApiOperation(value = "按照条件获取员工基本信息")
    public ResponseMessage<PageInfo<EmployeeInfo>> getEmployeeInfoByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                              @RequestParam Integer limit, @RequestParam Integer page,
                                                                              @RequestParam String condition, @RequestParam String value){
        log.info("getEmployeeInfoByCondition 传参: {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<EmployeeInfo>> responseMessage = employeeInfoService.getEmployeeByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addEmployeeInfo")
    @ApiOperation(value = "添加员工信息")
    public ResponseMessage<Integer> addEmployeeInfo(@PathVariable String dbName, @PathVariable String username,
                                                                              @RequestBody List<EmployeeInfo> employeeInfoList){
        log.info("addEmployeeInfo 传参: {},{},{},{},{},{}", dbName, username, employeeInfoList);
        ResponseMessage<Integer> responseMessage = employeeInfoService.addEmployeeInfo(dbName, username, employeeInfoList);
        return responseMessage;
    }

    @DeleteMapping("/deleteEmployeeInfo")
    @ApiOperation(value = "删除员工信息")
    public ResponseMessage<Integer> deleteEmployeeInfo(@PathVariable String dbName, @PathVariable String username,
                                                               @RequestBody List<String> id){
        log.info("deleteEmployeeInfo 传参: {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = employeeInfoService.deleteEmployeeInfoById(dbName, username, id);
        return responseMessage;
    }
}
