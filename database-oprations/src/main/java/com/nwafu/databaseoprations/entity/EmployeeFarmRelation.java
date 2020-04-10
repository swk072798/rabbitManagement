package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 员工和兔场关联关系
 * @author: liu qinchang
 * @create: 2020-04-02 21:02
 **/
@Data
public class EmployeeFarmRelation {
    private Integer id;
    private String employeeNo;
    private String farmUuid;
}
