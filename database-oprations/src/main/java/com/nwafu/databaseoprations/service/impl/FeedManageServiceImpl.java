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
import javax.management.relation.RoleUnresolved;
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
        if(dbName == null || username == null){
            throw new RuntimeException("必要参数不能为空");
        }
        List<String> permissions = redisUtils.getPermissionsToList(username);
        if(!permissions.contains("c")){
            throw new RuntimeException("getAllRabbitInfo 没有新增权限");
        }
        if(rabbitIngredients.size() == 0){
            throw new RuntimeException("addFeedInfo 列表不能为空");
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
    public ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(Integer limit, Integer page, String dbName, String username) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
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
    public ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(Integer limit, Integer page, String feedType, String dbName, String username) {
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(feedType == null || feedType.equals("")){
            throw new RuntimeException("查询条件不能为空");
        }
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(limit, page);
        List<RabbitIngredients> rabbitIngredients = rabbitIngredientsMapper.selectByName(feedType);
        log.info("getFeedInfoByName 总数：{}", rabbitIngredients.size());
        PageInfo<RabbitIngredients> pageInfo = new PageInfo<>(rabbitIngredients);
        return new ResponseMessage<>("success", pageInfo);
    }

    public ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value){
        if(dbName == null || username == null || limit == null || page == null){
            throw new RuntimeException("必要参数不能为空");
        }
        if(condition == null || condition.equals("")){
            throw new RuntimeException("查询条件不能为空");
        }
        if(!redisUtils.checkPermission("r", username)){
            throw new RuntimeException("没有查询权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        PageHelper.startPage(limit, page);
        List<RabbitIngredients> rabbitIngredients = rabbitIngredientsMapper.getInfoByCondition(condition, value);
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
        if(dbName == null || username == null ){
            throw new RuntimeException("必要参数不能为空");
        }
        if(deleteId == null || deleteId.size() == 0){
            throw new RuntimeException("删除列表不能为空");
        }
        if(!redisUtils.checkPermission("d", username)){
            throw new RuntimeException("没有删除权限");
        }
        DynamicDataSourceContextHolder.setDataSourceKey(dbName);
        int flag = rabbitIngredientsMapper.deleteById(deleteId);
        if(flag == 0){
            throw new RuntimeException("删除失败");
        }
        return new ResponseMessage<>("success", 1);
    }

}
