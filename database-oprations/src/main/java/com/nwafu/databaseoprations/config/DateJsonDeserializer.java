package com.nwafu.databaseoprations.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.util.StringUtils;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: rabbitmanagement
 * @description: 配置json日期类型转换
 * @author: liu qinchang
 * @create: 2020-01-03 16:50
 **/
public class DateJsonDeserializer  extends JsonDeserializer<Date> {
    public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            if (jsonParser != null && !StringUtils.isEmpty(jsonParser.getText())) {
                return format.parse(jsonParser.getText());
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
