package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 前端传来的不带rabbitNo的兔子信息
 * @author: liu qinchang
 * @create: 2020-03-31 20:13
 **/

@Data
public class RabbitInfoVO {


    private String cageNo;

    private String rabbitHouseNo;

    private String farmUuid;

    private Integer birthParity;

    private Double initialWeight;

    private String coatGloss;

    private Integer identicalRabbits;

    private String economiType;

    private String sex;

    private String initialAge;

    private String fineHairType;

    private String origin;

    private String mainCoatColor;

    private String paternalNo;

    private String coatFeature;

    private String maternalNo;

    private String roughType;

    private Integer age;

    private String coatColor;


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date bornDate;

    private Integer nipplesNumber;

    private String photo;
}
