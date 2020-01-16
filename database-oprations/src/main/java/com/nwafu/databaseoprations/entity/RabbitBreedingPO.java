package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nwafu.databaseoprations.config.DateJsonDeserializer;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 饲料数据库持久类
 * @author: liu qinchang
 * @create: 2020-01-15 14:21
 **/

@Data
public class RabbitBreedingPO {
    private Integer breedingInformationId;

    private String femaleRabbitNo;

    private String maleRabbitNo;

    private String breedingTime;

    private String twelveDayMoldTire;

    private String birthTime;

    private Integer nestLittersNumber;

    private Integer nestLiveRabbitsNumber;

    private Double nestLiveRabbitsRate;

    private Integer nestWeakDeadRabbitsNumber;

    private Double nestWeakDeadRabbitsRate;

    private Integer nestWeakRabbitsNumber;

    private Double nestWeakRabbitsRate;

    private Double nestDeathRabbitRate;

    private Double deathRabbitRate;

    private Double newbornNestWeight;

    private Double newbornAverageWeight;

    private Integer sucklingRabbitsNumber;

    private Double twentyOneDaysOldNestWeight;

    private Double weaningNestWeight;

    private Double lactationAverageDailyGain;

    private Double lactationConsumption;

    private Double lactationAverageMaterialWeightRatio;

    private String tiresNumber;

    public RabbitBreedingPO(RabbitBreeding rabbitBreeding){
        this.breedingInformationId = rabbitBreeding.getBreedingInformationId();

        this.femaleRabbitNo = rabbitBreeding.getFemaleRabbitNo();

        this.maleRabbitNo = rabbitBreeding.getMaleRabbitNo();

        this.breedingTime = new Timestamp(rabbitBreeding.getBreedingTime().getTime()).toString().split("\\.")[0];

        this.twelveDayMoldTire = rabbitBreeding.getTwelveDayMoldTire();

        this.birthTime = new Timestamp(rabbitBreeding.getBirthTime().getTime()).toString().split("\\.")[0];

        this.nestLittersNumber = rabbitBreeding.getNestLittersNumber();

        this.nestLiveRabbitsNumber = rabbitBreeding.getNestLiveRabbitsNumber();

        this.nestLiveRabbitsRate = rabbitBreeding.getNestLiveRabbitsRate();

        this.nestWeakDeadRabbitsNumber = rabbitBreeding.getNestWeakDeadRabbitsNumber();

        this.nestWeakDeadRabbitsRate = rabbitBreeding.getNestWeakDeadRabbitsRate();

        this.nestWeakRabbitsNumber = rabbitBreeding.getNestWeakRabbitsNumber();

        this.nestWeakRabbitsRate = rabbitBreeding.getNestWeakRabbitsRate();

        this.nestDeathRabbitRate = rabbitBreeding.getNestDeathRabbitRate();

        this.deathRabbitRate = rabbitBreeding.getDeathRabbitRate();

        this.newbornNestWeight = rabbitBreeding.getNewbornNestWeight();

        this.newbornAverageWeight = rabbitBreeding.getNewbornAverageWeight();

        this.sucklingRabbitsNumber = rabbitBreeding.getSucklingRabbitsNumber();

        this.twentyOneDaysOldNestWeight = rabbitBreeding.getTwentyOneDaysOldNestWeight();

        this.weaningNestWeight = rabbitBreeding.getWeaningNestWeight();

        this.lactationAverageDailyGain = rabbitBreeding.getLactationAverageDailyGain();

        this.lactationConsumption = rabbitBreeding.getLactationConsumption();

        this.lactationAverageMaterialWeightRatio = rabbitBreeding.getLactationAverageMaterialWeightRatio();

        this.tiresNumber = rabbitBreeding.getTiresNumber();
    }
}
