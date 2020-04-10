package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 存放企业的基本信息
 * @author: liu qinchang
 * @create: 2020-04-02 21:01
 **/
@Data
public class CompanyBaseInfo {
    private Integer id;
    private String companyName;
    private String companyAbbreviation;
}
