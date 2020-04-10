package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 公司基本信息，不带id
 * @author: liu qinchang
 * @create: 2020-04-05 09:48
 **/
@Data
public class CompanyBaseInfoVO {
    private String companyName;
    private String companyAbbreviation;
}
