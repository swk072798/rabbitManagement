package com.nwafu.databaseoprations.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 疾病记录的数据库实例
 * @author: liu qinchang
 * @create: 2020-02-06 10:33
 **/
@Data
public class RabbitIllnessPO {
    private Integer id;

    private String illnessName;

    private String pathogen;

    private String drugResistance;

    private String infectionTime;

    private String medicine;

    private String farmUuid;

    private String remark;

    public RabbitIllnessPO(RabbitIllness rabbitIllness){
        this.id = rabbitIllness.getId();
        this.illnessName = rabbitIllness.getIllnessName();
        this.pathogen = rabbitIllness.getPathogen();
        this.drugResistance = rabbitIllness.getDrugResistance();
        this.infectionTime = new Timestamp(rabbitIllness.getInfectionTime().getTime()).toString().split("\\.")[0];
        this.medicine = rabbitIllness.getMedicine();
        this.farmUuid = rabbitIllness.getFarmUuid();
        this.remark = rabbitIllness.getRemark();
    }
}
