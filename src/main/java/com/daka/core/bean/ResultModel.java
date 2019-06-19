package com.daka.core.bean;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zjt
 * @date: 2018-11-19 20:19
 */
@ToString
public class ResultModel {
    private String message;//提示信息
    private boolean success;//是否成功
    private String params;//参数
    private Object obj;//参数对象
    private Map<String, Object> paramMap = new HashMap<String, Object>();//其他参数

    public ResultModel() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ResultModel(String message, boolean success) {
        super();
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public void addParams(String key, Object value) {
        this.getParamMap().put(key, value);
    }

    public Object getParamByKey(String key) {
        return this.getParamMap().get(key);
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }


    public static ResultModel ok() {
        ResultModel resultModel = new ResultModel();
        resultModel.setSuccess(true);
        resultModel.setMessage("");
        return resultModel;
    }


}