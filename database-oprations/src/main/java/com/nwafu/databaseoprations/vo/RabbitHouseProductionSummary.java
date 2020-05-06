package com.nwafu.databaseoprations.vo;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description:
 * @author: liu qinchang
 * @create: 2020-05-01 11:43
 **/
@Data
public class RabbitHouseProductionSummary {
    private String houseNo;
    private Integer in;
    private Integer out;
    private Integer eliminate;
    private Integer death;
    private Integer ill;

}
