package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 不带id的
 * @author: liu qinchang
 * @create: 2020-04-05 11:03
 **/
@Data
public class EmployeeFarmRelationVO {
    private String employeeNo;
    private String farmUuid;
}
