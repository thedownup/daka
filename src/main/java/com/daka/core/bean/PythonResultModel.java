package com.daka.core.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 调用python返回的模型
 * @author: zjt
 * @date: 2018-12-04 17:26
 */
@Data
public class PythonResultModel implements Serializable {
    private boolean success;
    private String message;
    private boolean havepersion;
    private String data;
    private int persionNum;
}