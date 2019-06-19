package com.daka.webserver.bean;

import com.daka.webserver.model.SysClock;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-23 1:28
 */
@Data
public class User {
    private String name;
    private List<SysClock> sysClocks;
}