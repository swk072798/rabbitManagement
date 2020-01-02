package com.nwafu.databaseoprations.restconfig;

import lombok.Data;
import org.springframework.web.client.RestTemplate;

/**
 * @program: rabbitmanagement
 * @description: 使用RestTemplate调用其他模块的接口
 * @author: liu qinchang
 * @create: 2020-01-01 13:08
 **/

@Data
public class RestTemplateConfig {
    private RestTemplate restTemplate;

    public RestTemplateConfig(){
        restTemplate = new RestTemplate();
    }


}
