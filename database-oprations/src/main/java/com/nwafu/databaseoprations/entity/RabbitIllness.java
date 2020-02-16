package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nwafu.databaseoprations.config.DateJsonDeserializer;

import java.io.Serializable;
import java.util.Date;

public class RabbitIllness implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.illnessName
     *
     * @mbg.generated
     */
    private String illnessName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.pathogen
     *
     * @mbg.generated
     */
    private String pathogen;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.drugResistance
     *
     * @mbg.generated
     */
    private String drugResistance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.infectionTime
     *
     * @mbg.generated
     */
    @JsonDeserialize(using = DateJsonDeserializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date infectionTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.medicine
     *
     * @mbg.generated
     */
    private String medicine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.farmUuid
     *
     * @mbg.generated
     */
    private String farmUuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_illness.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rabbit_illness
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.id
     *
     * @return the value of rabbit_illness.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.id
     *
     * @param id the value for rabbit_illness.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.illnessName
     *
     * @return the value of rabbit_illness.illnessName
     *
     * @mbg.generated
     */
    public String getIllnessName() {
        return illnessName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.illnessName
     *
     * @param illnessName the value for rabbit_illness.illnessName
     *
     * @mbg.generated
     */
    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName == null ? null : illnessName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.pathogen
     *
     * @return the value of rabbit_illness.pathogen
     *
     * @mbg.generated
     */
    public String getPathogen() {
        return pathogen;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.pathogen
     *
     * @param pathogen the value for rabbit_illness.pathogen
     *
     * @mbg.generated
     */
    public void setPathogen(String pathogen) {
        this.pathogen = pathogen == null ? null : pathogen.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.drugResistance
     *
     * @return the value of rabbit_illness.drugResistance
     *
     * @mbg.generated
     */
    public String getDrugResistance() {
        return drugResistance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.drugResistance
     *
     * @param drugResistance the value for rabbit_illness.drugResistance
     *
     * @mbg.generated
     */
    public void setDrugResistance(String drugResistance) {
        this.drugResistance = drugResistance == null ? null : drugResistance.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.infectionTime
     *
     * @return the value of rabbit_illness.infectionTime
     *
     * @mbg.generated
     */
    public Date getInfectionTime() {
        return infectionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.infectionTime
     *
     * @param infectionTime the value for rabbit_illness.infectionTime
     *
     * @mbg.generated
     */
    public void setInfectionTime(Date infectionTime) {
        this.infectionTime = infectionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.medicine
     *
     * @return the value of rabbit_illness.medicine
     *
     * @mbg.generated
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.medicine
     *
     * @param medicine the value for rabbit_illness.medicine
     *
     * @mbg.generated
     */
    public void setMedicine(String medicine) {
        this.medicine = medicine == null ? null : medicine.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.farmUuid
     *
     * @return the value of rabbit_illness.farmUuid
     *
     * @mbg.generated
     */
    public String getFarmUuid() {
        return farmUuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.farmUuid
     *
     * @param farmUuid the value for rabbit_illness.farmUuid
     *
     * @mbg.generated
     */
    public void setFarmUuid(String farmUuid) {
        this.farmUuid = farmUuid == null ? null : farmUuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_illness.remark
     *
     * @return the value of rabbit_illness.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_illness.remark
     *
     * @param remark the value for rabbit_illness.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_illness
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", illnessName=").append(illnessName);
        sb.append(", pathogen=").append(pathogen);
        sb.append(", drugResistance=").append(drugResistance);
        sb.append(", infectionTime=").append(infectionTime);
        sb.append(", medicine=").append(medicine);
        sb.append(", farmUuid=").append(farmUuid);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}