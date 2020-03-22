package com.nwafu.databaseoprations.entity;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 兔舍基本信息
 * @author: liu qinchang
 * @create: 2020-02-18 18:07
 **/
@Data
public class RabbitHouseBasicInfo {
    private String rabbitHouseNo;
    private String rabbitHouseType;
    private String principal;
    private String farmUuid;
}
