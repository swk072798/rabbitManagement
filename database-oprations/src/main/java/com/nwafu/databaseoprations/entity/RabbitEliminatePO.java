package com.nwafu.databaseoprations.entity;

import java.sql.Timestamp;

/**
 * @program: rabbitManagement
 * @description: 兔子淘汰记录实体类
 * @author: liu qinchang
 * @create: 2020-03-21 14:43
 **/

public class RabbitEliminatePO {
    private String rabbitNo;

    private String eliminateDate;

    private String rabbitHouseNo;

    private String cageNo;

    private String eliminateReason;

    public RabbitEliminatePO(RabbitEliminate rabbitEliminate){
        this.rabbitNo = rabbitEliminate.getRabbitNo();
        this.eliminateDate = new Timestamp(rabbitEliminate.getEliminateDate().getTime()).toString().split("\\.")[0];
        this.rabbitHouseNo = rabbitEliminate.getRabbitHouseNo();
        this.cageNo = rabbitEliminate.getCageNo();
        this.eliminateReason = rabbitEliminate.getEliminateReason();
    }
}
