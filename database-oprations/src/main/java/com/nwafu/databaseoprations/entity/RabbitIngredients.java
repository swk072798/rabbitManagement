package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nwafu.databaseoprations.config.DateJsonDeserializer;

import java.io.Serializable;
import java.util.Date;

public class RabbitIngredients implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_ingredients.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_ingredients.feedType
     *
     * @mbg.generated
     */
    private String feedType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_ingredients.ingredientDates
     *
     * @mbg.generated
     */
    @JsonDeserialize(using = DateJsonDeserializer.class)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date ingredientDates;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_ingredients.ingredientNumber
     *
     * @mbg.generated
     */
    private Integer ingredientNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rabbit_ingredients.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rabbit_ingredients
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_ingredients.id
     *
     * @return the value of rabbit_ingredients.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_ingredients.id
     *
     * @param id the value for rabbit_ingredients.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_ingredients.feedType
     *
     * @return the value of rabbit_ingredients.feedType
     *
     * @mbg.generated
     */
    public String getFeedType() {
        return feedType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_ingredients.feedType
     *
     * @param feedType the value for rabbit_ingredients.feedType
     *
     * @mbg.generated
     */
    public void setFeedType(String feedType) {
        this.feedType = feedType == null ? null : feedType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_ingredients.ingredientDates
     *
     * @return the value of rabbit_ingredients.ingredientDates
     *
     * @mbg.generated
     */
    public Date getIngredientDates() {
        return ingredientDates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_ingredients.ingredientDates
     *
     * @param ingredientDates the value for rabbit_ingredients.ingredientDates
     *
     * @mbg.generated
     */
    public void setIngredientDates(Date ingredientDates) {
        this.ingredientDates = ingredientDates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_ingredients.ingredientNumber
     *
     * @return the value of rabbit_ingredients.ingredientNumber
     *
     * @mbg.generated
     */
    public Integer getIngredientNumber() {
        return ingredientNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_ingredients.ingredientNumber
     *
     * @param ingredientNumber the value for rabbit_ingredients.ingredientNumber
     *
     * @mbg.generated
     */
    public void setIngredientNumber(Integer ingredientNumber) {
        this.ingredientNumber = ingredientNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rabbit_ingredients.remark
     *
     * @return the value of rabbit_ingredients.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rabbit_ingredients.remark
     *
     * @param remark the value for rabbit_ingredients.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_ingredients
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
        sb.append(", ingredientDates=").append(ingredientDates);
        sb.append(", ingredientNumber=").append(ingredientNumber);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}