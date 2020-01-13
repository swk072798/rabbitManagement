package com.nwafu.databaseoprations.dao;

import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.RabbitIngredientsPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RabbitIngredientsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_ingredients
     *
     * @mbg.generated
     */
    int insert(List<RabbitIngredientsPO> record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rabbit_ingredients
     *
     * @mbg.generated
     */
    List<RabbitIngredients> selectAll();

    List<RabbitIngredients> selectByName(String feedType);

    int deleteById(List<String> id);
}