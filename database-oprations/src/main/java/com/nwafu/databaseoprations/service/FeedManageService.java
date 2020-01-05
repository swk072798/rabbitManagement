package com.nwafu.databaseoprations.service;

import com.nwafu.databaseoprations.entity.RabbitIngredients;
import com.nwafu.databaseoprations.entity.ResponseMessage;

import java.util.List;

public interface FeedManageService {
    ResponseMessage<Integer> addFeedInfo(String dbName, List<RabbitIngredients> rabbitIngredients);

}
