package org.smart4j.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Json 工具类
 */
public class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /*
    POJO 转为Json
     */

    public static <T> String toJson(T obj){
        String json;
        try{
            json = OBJECT_MAPPER.writeValueAsString(obj);

        }catch (Exception e){
            LOGGER.error("convert pojo to json failed!",e);
            throw new RuntimeException(e);
        }
        return json;
    }

    /*
    Json 转换为PoJo
    */
    public static <T>T fromJson(String json,Class<T>type){
        T pojo;
        try{
            pojo = OBJECT_MAPPER.readValue(json,type);
        }catch (Exception e){
            LOGGER.error("convert json to pojo failed!",e);
            throw new RuntimeException(e);
        }
        return pojo;
    }


}
