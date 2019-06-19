package com.daka.core.bean;

import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

/**
 * @description:1
 * @author: zjt
 * @date: 2019-03-23 12:19
 */
@Data
public class HttpClientResult {
    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public HttpClientResult(){}

    public HttpClientResult(int code) {
        this.code = code;
    }

    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }
}