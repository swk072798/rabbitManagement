package com.nwafu.databaseoprations.entity;

import java.io.Serializable;
import java.util.Date;

public class RabbitInfo implements Serializable {
    private String rabbitNo;

    private String cageNo;

    private Integer birthParity;

    private Double initialWeight;

    private String coatGloss;

    private String rabbitHouseNo;

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

    private Date bornDate;

    private Integer nipplesNumber;

    private String photo;

    private static final long serialVersionUID = 1L;

    public String getRabbitNo() {
        return rabbitNo;
    }

    public void setRabbitNo(String rabbitNo) {
        this.rabbitNo = rabbitNo == null ? null : rabbitNo.trim();
    }

    public String getCageNo() {
        return cageNo;
    }

    public void setCageNo(String cageNo) {
        this.cageNo = cageNo == null ? null : cageNo.trim();
    }

    public Integer getBirthParity() {
        return birthParity;
    }

    public void setBirthParity(Integer birthParity) {
        this.birthParity = birthParity;
    }

    public Double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getCoatGloss() {
        return coatGloss;
    }

    public void setCoatGloss(String coatGloss) {
        this.coatGloss = coatGloss == null ? null : coatGloss.trim();
    }

    public String getRabbitHouseNo() {
        return rabbitHouseNo;
    }

    public void setRabbitHouseNo(String rabbitHouseNo) {
        this.rabbitHouseNo = rabbitHouseNo == null ? null : rabbitHouseNo.trim();
    }

    public Integer getIdenticalRabbits() {
        return identicalRabbits;
    }

    public void setIdenticalRabbits(Integer identicalRabbits) {
        this.identicalRabbits = identicalRabbits;
    }

    public String getEconomiType() {
        return economiType;
    }

    public void setEconomiType(String economiType) {
        this.economiType = economiType == null ? null : economiType.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getInitialAge() {
        return initialAge;
    }

    public void setInitialAge(String initialAge) {
        this.initialAge = initialAge == null ? null : initialAge.trim();
    }

    public String getFineHairType() {
        return fineHairType;
    }

    public void setFineHairType(String fineHairType) {
        this.fineHairType = fineHairType == null ? null : fineHairType.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public String getMainCoatColor() {
        return mainCoatColor;
    }

    public void setMainCoatColor(String mainCoatColor) {
        this.mainCoatColor = mainCoatColor == null ? null : mainCoatColor.trim();
    }

    public String getPaternalNo() {
        return paternalNo;
    }

    public void setPaternalNo(String paternalNo) {
        this.paternalNo = paternalNo == null ? null : paternalNo.trim();
    }

    public String getCoatFeature() {
        return coatFeature;
    }

    public void setCoatFeature(String coatFeature) {
        this.coatFeature = coatFeature == null ? null : coatFeature.trim();
    }

    public String getMaternalNo() {
        return maternalNo;
    }

    public void setMaternalNo(String maternalNo) {
        this.maternalNo = maternalNo == null ? null : maternalNo.trim();
    }

    public String getRoughType() {
        return roughType;
    }

    public void setRoughType(String roughType) {
        this.roughType = roughType == null ? null : roughType.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor == null ? null : coatColor.trim();
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Integer getNipplesNumber() {
        return nipplesNumber;
    }

    public void setNipplesNumber(Integer nipplesNumber) {
        this.nipplesNumber = nipplesNumber;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rabbitNo=").append(rabbitNo);
        sb.append(", cageNo=").append(cageNo);
        sb.append(", birthParity=").append(birthParity);
        sb.append(", initialWeight=").append(initialWeight);
        sb.append(", coatGloss=").append(coatGloss);
        sb.append(", rabbitHouseNo=").append(rabbitHouseNo);
        sb.append(", identicalRabbits=").append(identicalRabbits);
        sb.append(", economiType=").append(economiType);
        sb.append(", sex=").append(sex);
        sb.append(", initialAge=").append(initialAge);
        sb.append(", fineHairType=").append(fineHairType);
        sb.append(", origin=").append(origin);
        sb.append(", mainCoatColor=").append(mainCoatColor);
        sb.append(", paternalNo=").append(paternalNo);
        sb.append(", coatFeature=").append(coatFeature);
        sb.append(", maternalNo=").append(maternalNo);
        sb.append(", roughType=").append(roughType);
        sb.append(", age=").append(age);
        sb.append(", coatColor=").append(coatColor);
        sb.append(", bornDate=").append(bornDate);
        sb.append(", nipplesNumber=").append(nipplesNumber);
        sb.append(", photo=").append(photo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}