package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nwafu.databaseoprations.config.DateJsonDeserializer;
import lombok.Data;

import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 兔子淘汰记录
 * @author: liu qinchang
 * @create: 2020-03-21 14:38
 **/
@Data
public class RabbitEliminate {

    private String rabbitNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date eliminateDate;

    private String rabbitHouseNo;

    private String cageNo;

    private String eliminateReason;

}
