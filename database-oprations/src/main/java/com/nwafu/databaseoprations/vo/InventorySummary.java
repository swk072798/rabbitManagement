package com.nwafu.databaseoprations.vo;

import lombok.Data;

/**
 * @program: rabbitManagement
 * @description: 存栏统计返回类
 * @author: liu qinchang
 * @create: 2020-04-29 10:24
 **/
@Data
public class InventorySummary {
    private Integer male;
    private Integer female;
    private Integer total;

}
