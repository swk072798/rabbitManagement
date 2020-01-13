package com.nwafu.databaseoprations.service;

import com.github.pagehelper.PageInfo;
import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface FeedManageService {
    ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients);
    ResponseMessage<PageInfo<RabbitIngredients>> getAllFeedInfo(int limit, int page, String dbName);
    ResponseMessage<PageInfo<RabbitIngredients>> getFeedInfoByName(int limit, int page, String feedType, String dbName);
    ResponseMessage<Integer> deleteFeedInfo(List<String> deleteId, String dbName);
}
