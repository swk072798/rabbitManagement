package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface FeedManageService {
    ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients, String username);
    ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(Integer limit, Integer page, String dbName, String username);
    ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(Integer limit, Integer page, String feedType, String dbName, String username);
    ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByCondition(String dbName, String username, Integer limit, Integer page, String condition, String value);
    ResponseMessage<Integer> deleteFeedInfo(List<String> deleteId, String dbName, String username);
}
