package com.daka.webserver.dao;

import com.daka.webserver.model.SysControll;
import com.daka.webserver.model.SysControllExample;
import org.springframework.stereotype.Repository;

/**
 * SysControllDao继承基类
 */
@Repository
public interface SysControllDao extends MyBatisBaseDao<SysControll, String, SysControllExample> {
}