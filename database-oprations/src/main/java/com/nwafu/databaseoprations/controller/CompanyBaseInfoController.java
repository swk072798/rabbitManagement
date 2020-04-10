package com.nwafu.databaseoprations.controller;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfo;
import com.nwafu.databaseoprations.entity.CompanyBaseInfoVO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.CompanyBaseInfoService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: rabbitManagement
 * @description: 公司基本信息管理类
 * @author: liu qinchang
 * @create: 2020-04-04 11:20
 **/
@RestController
@RequestMapping("/{dbName}/{username}")
@Slf4j
public class CompanyBaseInfoController {

    @Autowired
    CompanyBaseInfoService companyBaseInfoService;

    @GetMapping("/getAllCompanyBaseInfo")
    @ApiOperation(value = "查询所有公司基本信息")
    public ResponseMessage<PageInfo<CompanyBaseInfo>> getAllCompanyBaseInfo(@PathVariable String dbName, @PathVariable String username,
                                                                            @RequestParam Integer limit, @RequestParam Integer page){
        log.info("getAllCompanyBaseInfo 传参: {},{},{},{}", dbName, username, limit, page);
        ResponseMessage<PageInfo<CompanyBaseInfo>> responseMessage = companyBaseInfoService.getAllCompanyBaseInfo(dbName, username, limit, page);
        return responseMessage;
    }

    @GetMapping("/getCompanyBaseInfoByCondition")
    @ApiOperation(value = "按照条件筛选信息")
    public ResponseMessage<PageInfo<CompanyBaseInfo>> getCompanyBaseInfoByCondition(@PathVariable String dbName, @PathVariable String username,
                                                                                    @RequestParam Integer limit, @RequestParam Integer page,
                                                                                    @RequestParam String condition, @RequestParam String value){
        log.info("getCompanyBaseInfoByCondition 传参: {},{},{},{},{},{}", dbName, username, limit, page, condition, value);
        ResponseMessage<PageInfo<CompanyBaseInfo>> responseMessage = companyBaseInfoService.getCompanyBaseInfoByCondition(dbName, username, limit, page, condition, value);
        return responseMessage;
    }

    @PostMapping("/addCompanyBaseInfo")
    @ApiOperation(value = "添加公司基本信息")
    public ResponseMessage<Integer> addCompanyBaseInfo(@PathVariable String dbName, @PathVariable String username, @RequestBody List<CompanyBaseInfoVO> companyBaseInfoList){
        log.info("getCompanyBaseInfoByCondition 传参: {},{},{}", dbName, username, companyBaseInfoList);
        ResponseMessage<Integer> responseMessage = companyBaseInfoService.addCompanyBaseInfo(dbName, username,companyBaseInfoList);
        return responseMessage;
    }

    @DeleteMapping("/deleteCompanyBaseInfoById")
    @ApiOperation(value = "删除公司基本信息")
    public ResponseMessage<Integer> deleteCompanyBaseInfoById(@PathVariable String dbName, @PathVariable String username,@RequestBody List<String> id){
        log.info("getCompanyBaseInfoByCondition 传参: {},{},{}", dbName, username, id);
        ResponseMessage<Integer> responseMessage = companyBaseInfoService.deleteCompanyBaseInfoById(dbName, username, id);
        return responseMessage;
    }

}
