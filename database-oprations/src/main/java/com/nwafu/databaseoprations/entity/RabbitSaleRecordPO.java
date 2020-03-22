package com.nwafu.databaseoprations.entity;

import java.sql.Timestamp;

/**
 * @program: rabbitManagement
 * @description: 兔子销售记录实例类
 * @author: liu qinchang
 * @create: 2020-03-21 13:48
 **/
public class RabbitSaleRecordPO {
    private String rabbitNo;

    private String farmUuid;

    private String rabbitHouseNo;

    private String cageNo;

    private String saleDate;

    private Double price;

    private String client;

    private String executive;

    public RabbitSaleRecordPO(RabbitSaleRecord rabbitSaleRecord){
        this.rabbitNo = rabbitSaleRecord.getRabbitNo();
        this.farmUuid = rabbitSaleRecord.getFarmUuid();
        this.cageNo = rabbitSaleRecord.getCageNo();
        this.saleDate = new Timestamp(rabbitSaleRecord.getSaleDate().getTime()).toString().split("\\.")[0];
        this.price = rabbitSaleRecord.getPrice();
        this.client = rabbitSaleRecord.getClient();
        this.executive = rabbitSaleRecord.getExecutive();
    }
}
