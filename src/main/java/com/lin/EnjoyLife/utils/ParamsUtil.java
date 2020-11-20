package com.lin.EnjoyLife.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ParamsUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    /**
     * json数据转为对象
     * @param jsonData	json格式的数据
     * @param bean		bean对象
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static <T> T jsonToPojo(String jsonData,Class<T> bean) throws JsonParseException, JsonMappingException, IOException{
        T t = OBJECT_MAPPER.readValue(jsonData, bean);
        return t;
    }

    /**
     * 将json数据转为对象集合
     * @param jsonData		json格式的字符串
     * @param beanType		bean对象
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) throws JsonParseException, JsonMappingException, IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
        return list;
    }

    /**
     * json对象转字符串
     * @param data
     * @return
     * @throws JsonProcessingException
     */
    public static String objectToJsonStr(Object data) throws JsonProcessingException {
        String string = OBJECT_MAPPER.writeValueAsString(data);
        return string;
    }
}