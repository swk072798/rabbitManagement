package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nwafu.databaseoprations.config.DateJsonDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 兔子销售记录
 * @author: liu qinchang
 * @create: 2020-03-12 13:57
 **/
@Data
public class RabbitSaleRecord {
    private String rabbitNo;

    private String farmUuid;

    private String rabbitHouseNo;

    private String cageNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date saleDate;

    private Double price;

    private String client;

    private String executive;
}
