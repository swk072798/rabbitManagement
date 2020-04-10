package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelation;
import com.nwafu.databaseoprations.entity.EmployeeFarmRelationVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.EmployeeFarmRelationService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 员工-兔场关联关系管理
 * @author: liu qinchang
 * @create: 2020-04-04 12:12
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class EmployeeFarmRelationController {

    @Autowired
    EmployeeFarmRelationService employeeFarmRelationService;

    @GetMapping("/getAllEmployeeFarmRelation")
    @ApiOperation(value = "查询所有员工和兔场的关系")
    public ResponseMessage<PageInfo<EmployeeFarmRelation>> getAllEmployeeFarmRelation(@PathVariable String dbName, @PathVariable String username,
                                                                                       @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllEmployeeFarmRelateion 传参: {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<EmployeeFarmRelation>> responseMessage = employeeFarmRelationService.getAllEmployeeFarmRelation(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getEmployeeFarmRelationByCondition")
    @ApiOperation(value = "按照条件查询员工和兔场的关系")
    public ResponseMessage<PageInfo<EmployeeFarmRelation>> getEmployeeFarmRelationByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                                              @RequestParam Integer limit, @RequestParam Integer page,
                                                                                              @RequestParam String condition, @RequestParam String value){
        log.info("getEmployeeFarmRelationByCondition 传参: {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<EmployeeFarmRelation>> responseMessage = employeeFarmRelationService.getEmployeeFarmRelationByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addEmployeeFarmRelation")
    @ApiOperation(value = "添加员工兔场关系")
    public ResponseMessage<Integer> addEmployeeFarmRelation(@PathVariable String dbName, @PathVariable String username,
                                                            @RequestBody List<EmployeeFarmRelationVO> employeeFarmRelationList){
        log.info("getEmployeeFarmRelationByCondition 传参: {},{},{},{},{},{}", dbName, username, employeeFarmRelationList);
        ResponseMessage<Integer> responseMessage = employeeFarmRelationService.addEmployeeFarmRelation(dbName, username, employeeFarmRelationList);
        return responseMessage;
    }

    @DeleteMapping("/deleteEmployeeFarmRelation")
    @ApiOperation(value = "删除员工兔场关联关系")
    public ResponseMessage<Integer> deleteEmployeeFarmRelation(@PathVariable String dbName, @PathVariable String username,
                                                            @RequestBody List<String> id){
        log.info("getEmployeeFarmRelationByCondition 传参: {},{},{},{},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = employeeFarmRelationService.deleteEmployeeFarmRelationById(dbName, username, id);
        return responseMessage;
    }
}
