package com.nwafu.databaseoprations.entity;

import java.io.Serializable;
import java.util.Date;

public class RabbitMaterialsRecord implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.feedType
     *
     * @mbg.generated
     */
    private String feedType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.outboundDate
     *
     * @mbg.generated
     */
    private Date outboundDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.outboundNumber
     *
     * @mbg.generated
     */
    private Integer outboundNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.uploadUser
     *
     * @mbg.generated
     */
    private String uploadUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_materials_record.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rabbit_materials_record
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.id
     *
     * @return the value of rabbit_materials_record.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.id
     *
     * @param id the value for rabbit_materials_record.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.feedType
     *
     * @return the value of rabbit_materials_record.feedType
     *
     * @mbg.generated
     */
    public String getFeedType() {
        return feedType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.feedType
     *
     * @param feedType the value for rabbit_materials_record.feedType
     *
     * @mbg.generated
     */
    public void setFeedType(String feedType) {
        this.feedType = feedType == null ? null : feedType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.outboundDate
     *
     * @return the value of rabbit_materials_record.outboundDate
     *
     * @mbg.generated
     */
    public Date getOutboundDate() {
        return outboundDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.outboundDate
     *
     * @param outboundDate the value for rabbit_materials_record.outboundDate
     *
     * @mbg.generated
     */
    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.outboundNumber
     *
     * @return the value of rabbit_materials_record.outboundNumber
     *
     * @mbg.generated
     */
    public Integer getOutboundNumber() {
        return outboundNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.outboundNumber
     *
     * @param outboundNumber the value for rabbit_materials_record.outboundNumber
     *
     * @mbg.generated
     */
    public void setOutboundNumber(Integer outboundNumber) {
        this.outboundNumber = outboundNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.price
     *
     * @return the value of rabbit_materials_record.price
     *
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.price
     *
     * @param price the value for rabbit_materials_record.price
     *
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.uploadUser
     *
     * @return the value of rabbit_materials_record.uploadUser
     *
     * @mbg.generated
     */
    public String getUploadUser() {
        return uploadUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.uploadUser
     *
     * @param uploadUser the value for rabbit_materials_record.uploadUser
     *
     * @mbg.generated
     */
    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser == null ? null : uploadUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_materials_record.remark
     *
     * @return the value of rabbit_materials_record.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_materials_record.remark
     *
     * @param remark the value for rabbit_materials_record.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_materials_record
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
        sb.append(", feedType=").append(feedType);
        sb.append(", outboundDate=").append(outboundDate);
        sb.append(", outboundNumber=").append(outboundNumber);
        sb.append(", price=").append(price);
        sb.append(", uploadUser=").append(uploadUser);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}