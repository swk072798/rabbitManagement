package com.nwafu.databaseoprations.service.impl;

import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitIngredientsMapper;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.RabbitIngredientsPO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.service.FeedManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: rabbitmanagement
 * @description: 饲料管理
 * @author: liu qinchang
 * @create: 2020-01-03 16:24
 **/

@Service
@Slf4j
public class FeedManageServiceImpl implements FeedManageService {

    @Resource
    RabbitIngredientsMapper rabbitIngredientsMapper;

    @Override
    public ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients) {
        if(rabbitIngredients.size() == 0){
            throw new RuntimeException("addFeedInfo 列表不为空");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        List<RabbitIngredientsPO> rabbitIngredientsPOList = new ArrayList<>();
        for(RabbitIngredients rabbitIngredient : rabbitIngredients){
            RabbitIngredientsPO rabbitIngredientsPO = new RabbitIngredientsPO(rabbitIngredient);
            log.info(rabbitIngredientsPO.toString());
            rabbitIngredientsPOList.add(rabbitIngredientsPO);
        }
        rabbitIngredientsMapper.insert(rabbitIngredientsPOList);
        return new ResponseMessage<>("success", 1);
    }
}
