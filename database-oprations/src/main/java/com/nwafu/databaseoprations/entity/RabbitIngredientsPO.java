package com.nwafu.databaseoprations.entity;


import lombok.Data;

import java.sql.Timestamp;


/**
 * @program: rabbitmanagement
 * @description: RabbitIngredients 存放数据库中的实例
 * @author: liu qinchang
 * @create: 2020-01-03 17:02
 **/
@Data
public class RabbitIngredientsPO{
    private Integer id;

    private String feedType;

    private String ingredientDates;

    private Integer ingredientNumber;

    private String remark;

    public RabbitIngredientsPO(){}

    public RabbitIngredientsPO(RabbitIngredients rabbitIngredients){
        this.id = rabbitIngredients.getId();
        this.feedType = rabbitIngredients.getFeedType();
        this.ingredientDates = new Timestamp(rabbitIngredients.getIngredientDates().getTime()).toString().split("\\.")[0];
        this.ingredientNumber = rabbitIngredients.getIngredientNumber();
        this.remark = rabbitIngredients.getRemark();
    }
}
