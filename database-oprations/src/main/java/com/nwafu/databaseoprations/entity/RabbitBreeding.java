package com.nwafu.databaseoprations.entity;

import java.io.Serializable;
import java.util.Date;

public class RabbitBreeding implements Serializable {
    private Integer breedingInformationId;

    private String femaleRabbitNo;

    private String maleRabbitNo;

    private Date breedingTime;

    private String twelve-dayMoldTire;

    private Date birthTime;

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

    private Double twenty-oneDaysOldNestWeight;

    private Double weaningNestWeight;

    private Double lactationAverageDailyGain;

    private Double lactationConsumption;

    private Double lactationAverageMaterialWeightRatio;

    private String tiresNumber;

    private static final long serialVersionUID = 1L;

    public Integer getBreedingInformationId() {
        return breedingInformationId;
    }

    public void setBreedingInformationId(Integer breedingInformationId) {
        this.breedingInformationId = breedingInformationId;
    }

    public String getFemaleRabbitNo() {
        return femaleRabbitNo;
    }

    public void setFemaleRabbitNo(String femaleRabbitNo) {
        this.femaleRabbitNo = femaleRabbitNo == null ? null : femaleRabbitNo.trim();
    }

    public String getMaleRabbitNo() {
        return maleRabbitNo;
    }

    public void setMaleRabbitNo(String maleRabbitNo) {
        this.maleRabbitNo = maleRabbitNo == null ? null : maleRabbitNo.trim();
    }

    public Date getBreedingTime() {
        return breedingTime;
    }

    public void setBreedingTime(Date breedingTime) {
        this.breedingTime = breedingTime;
    }

    public String getTwelve-dayMoldTire() {
        return twelve-dayMoldTire;
    }

    public void setTwelve-dayMoldTire(String twelve-dayMoldTire) {
        this.twelve-dayMoldTire = twelve-dayMoldTire == null ? null : twelve-dayMoldTire.trim();
    }

    public Date getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(Date birthTime) {
        this.birthTime = birthTime;
    }

    public Integer getNestLittersNumber() {
        return nestLittersNumber;
    }

    public void setNestLittersNumber(Integer nestLittersNumber) {
        this.nestLittersNumber = nestLittersNumber;
    }

    public Integer getNestLiveRabbitsNumber() {
        return nestLiveRabbitsNumber;
    }

    public void setNestLiveRabbitsNumber(Integer nestLiveRabbitsNumber) {
        this.nestLiveRabbitsNumber = nestLiveRabbitsNumber;
    }

    public Double getNestLiveRabbitsRate() {
        return nestLiveRabbitsRate;
    }

    public void setNestLiveRabbitsRate(Double nestLiveRabbitsRate) {
        this.nestLiveRabbitsRate = nestLiveRabbitsRate;
    }

    public Integer getNestWeakDeadRabbitsNumber() {
        return nestWeakDeadRabbitsNumber;
    }

    public void setNestWeakDeadRabbitsNumber(Integer nestWeakDeadRabbitsNumber) {
        this.nestWeakDeadRabbitsNumber = nestWeakDeadRabbitsNumber;
    }

    public Double getNestWeakDeadRabbitsRate() {
        return nestWeakDeadRabbitsRate;
    }

    public void setNestWeakDeadRabbitsRate(Double nestWeakDeadRabbitsRate) {
        this.nestWeakDeadRabbitsRate = nestWeakDeadRabbitsRate;
    }

    public Integer getNestWeakRabbitsNumber() {
        return nestWeakRabbitsNumber;
    }

    public void setNestWeakRabbitsNumber(Integer nestWeakRabbitsNumber) {
        this.nestWeakRabbitsNumber = nestWeakRabbitsNumber;
    }

    public Double getNestWeakRabbitsRate() {
        return nestWeakRabbitsRate;
    }

    public void setNestWeakRabbitsRate(Double nestWeakRabbitsRate) {
        this.nestWeakRabbitsRate = nestWeakRabbitsRate;
    }

    public Double getNestDeathRabbitRate() {
        return nestDeathRabbitRate;
    }

    public void setNestDeathRabbitRate(Double nestDeathRabbitRate) {
        this.nestDeathRabbitRate = nestDeathRabbitRate;
    }

    public Double getDeathRabbitRate() {
        return deathRabbitRate;
    }

    public void setDeathRabbitRate(Double deathRabbitRate) {
        this.deathRabbitRate = deathRabbitRate;
    }

    public Double getNewbornNestWeight() {
        return newbornNestWeight;
    }

    public void setNewbornNestWeight(Double newbornNestWeight) {
        this.newbornNestWeight = newbornNestWeight;
    }

    public Double getNewbornAverageWeight() {
        return newbornAverageWeight;
    }

    public void setNewbornAverageWeight(Double newbornAverageWeight) {
        this.newbornAverageWeight = newbornAverageWeight;
    }

    public Integer getSucklingRabbitsNumber() {
        return sucklingRabbitsNumber;
    }

    public void setSucklingRabbitsNumber(Integer sucklingRabbitsNumber) {
        this.sucklingRabbitsNumber = sucklingRabbitsNumber;
    }

    public Double getTwenty-oneDaysOldNestWeight() {
        return twenty-oneDaysOldNestWeight;
    }

    public void setTwenty-oneDaysOldNestWeight(Double twenty-oneDaysOldNestWeight) {
        this.twenty-oneDaysOldNestWeight = twenty-oneDaysOldNestWeight;
    }

    public Double getWeaningNestWeight() {
        return weaningNestWeight;
    }

    public void setWeaningNestWeight(Double weaningNestWeight) {
        this.weaningNestWeight = weaningNestWeight;
    }

    public Double getLactationAverageDailyGain() {
        return lactationAverageDailyGain;
    }

    public void setLactationAverageDailyGain(Double lactationAverageDailyGain) {
        this.lactationAverageDailyGain = lactationAverageDailyGain;
    }

    public Double getLactationConsumption() {
        return lactationConsumption;
    }

    public void setLactationConsumption(Double lactationConsumption) {
        this.lactationConsumption = lactationConsumption;
    }

    public Double getLactationAverageMaterialWeightRatio() {
        return lactationAverageMaterialWeightRatio;
    }

    public void setLactationAverageMaterialWeightRatio(Double lactationAverageMaterialWeightRatio) {
        this.lactationAverageMaterialWeightRatio = lactationAverageMaterialWeightRatio;
    }

    public String getTiresNumber() {
        return tiresNumber;
    }

    public void setTiresNumber(String tiresNumber) {
        this.tiresNumber = tiresNumber == null ? null : tiresNumber.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", breedingInformationId=").append(breedingInformationId);
        sb.append(", femaleRabbitNo=").append(femaleRabbitNo);
        sb.append(", maleRabbitNo=").append(maleRabbitNo);
        sb.append(", breedingTime=").append(breedingTime);
        sb.append(", twelve-dayMoldTire=").append(twelve-dayMoldTire);
        sb.append(", birthTime=").append(birthTime);
        sb.append(", nestLittersNumber=").append(nestLittersNumber);
        sb.append(", nestLiveRabbitsNumber=").append(nestLiveRabbitsNumber);
        sb.append(", nestLiveRabbitsRate=").append(nestLiveRabbitsRate);
        sb.append(", nestWeakDeadRabbitsNumber=").append(nestWeakDeadRabbitsNumber);
        sb.append(", nestWeakDeadRabbitsRate=").append(nestWeakDeadRabbitsRate);
        sb.append(", nestWeakRabbitsNumber=").append(nestWeakRabbitsNumber);
        sb.append(", nestWeakRabbitsRate=").append(nestWeakRabbitsRate);
        sb.append(", nestDeathRabbitRate=").append(nestDeathRabbitRate);
        sb.append(", deathRabbitRate=").append(deathRabbitRate);
        sb.append(", newbornNestWeight=").append(newbornNestWeight);
        sb.append(", newbornAverageWeight=").append(newbornAverageWeight);
        sb.append(", sucklingRabbitsNumber=").append(sucklingRabbitsNumber);
        sb.append(", twenty-oneDaysOldNestWeight=").append(twenty-oneDaysOldNestWeight);
        sb.append(", weaningNestWeight=").append(weaningNestWeight);
        sb.append(", lactationAverageDailyGain=").append(lactationAverageDailyGain);
        sb.append(", lactationConsumption=").append(lactationConsumption);
        sb.append(", lactationAverageMaterialWeightRatio=").append(lactationAverageMaterialWeightRatio);
        sb.append(", tiresNumber=").append(tiresNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}