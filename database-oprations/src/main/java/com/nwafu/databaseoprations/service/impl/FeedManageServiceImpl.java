package com.nwafu.databaseoprations.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.config.DynamicDataSourceContextHolder;
import com.nwafu.databaseoprations.dao.RabbitIngredientsMapper;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.RabbitIngredientsPO;
import com.nwafu.databaseoprations.entity.ResponseMessage;
import com.nwafu.databaseoprations.redis.RedisUtils;
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

    RedisUtils redisUtils = new RedisUtils();
    /**
    * @Description: 添加饲料
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @Override
    public ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients, String username) {
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("r")){
            throw new RuntimeException("getAllRabbitInfo 没有相关操作权限");
        }
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

    /**
    * @Description:  获取所有饲料列表
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @Override
    public ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(int limit, int page, String dbName, String username) {
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(limit, page);
        List<RabbitIngredients> rabbitIngredients = rabbitIngredientsMapper.selectAll();
        log.info("getAllFeedInfo 总数：{}", rabbitIngredients.size());
        PageInfo<RabbitIngredients> pageInfo = new PageInfo<>(rabbitIngredients);
        return new ResponseMessage<>("success", pageInfo);
    }

    /**
    * @Description: 根据名称查询
    * @Param:
    * @return:
    * @Author: liu qinchang
    * @Date: 2020/1/13
    */
    @Override
    public ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(int limit, int page, String feedType, String dbName, String username) {
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(limit, page);
        List<RabbitIngredients> rabbitIngredients = rabbitIngredientsMapper.selectByName(feedType);
        log.info("getFeedInfoByName 总数：{}", rabbitIngredients.size());
        PageInfo<RabbitIngredients> pageInfo = new PageInfo<>(rabbitIngredients);
        return new ResponseMessage<>("success", pageInfo);
    }

    /** 
    * @Description: 删除饲料信息
    * @Param:  
    * @return:  
    * @Author: liu qinchang
    * @Date: 2020/1/13 
    */
    @Override
    public ResponseMessage<Integer> deleteFeedInfo(List<String> deleteId, String dbName, String username) {
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitIngredientsMapper.deleteById(deleteId);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }

}
