package com.daka.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.weaver.patterns.PerFromSuper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-23 12:35
 */
public class JSONUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

    /**
     * JSON 转 POJO
     */
    public static <T> T getObject(String pojo, Class<T> tclass) {
        try {
            return JSONObject.parseObject(pojo, tclass);
        } catch (Exception e) {
            LOGGER.error(tclass + "转 JSON 失败");
        }
        return null;
    }

    /**
     * POJO 转 JSON
     */
    public static <T> String getJson(T tResponse) {
        String pojo = JSONObject.toJSONString(tResponse);
        return pojo;
    }
}