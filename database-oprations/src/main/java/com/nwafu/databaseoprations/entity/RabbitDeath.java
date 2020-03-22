package com.nwafu.databaseoprations.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @program: rabbitManagement
 * @description: 兔子死亡记录
 * @author: liu qinchang
 * @create: 2020-03-09 20:22
 **/
@Data
public class RabbitDeath {
    private String rabbitNo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date deathDate;

    private String rabbitHouseNo;

    private String cageNo;

    private String deathReason;
}
