package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface FeedManageService {
    ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients, String username);
    ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(int limit, int page, String dbName, String username);
    ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(int limit, int page, String feedType, String dbName, String username);
    ResponseMessage<Integer> deleteFeedInfo(List<String> deleteId, String dbName, String username);
}
