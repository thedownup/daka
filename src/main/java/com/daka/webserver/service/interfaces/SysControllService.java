package com.daka.webserver.service.interfaces;

import com.daka.webserver.model.SysControll;
import com.daka.webserver.model.SysControllExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-05-14 19:57
 */
public interface SysControllService {
    long countByExample(SysControllExample example);

    int deleteByExample(SysControllExample example);

    int deleteByPrimaryKey(String callId);

    int insert(SysControll record);

    int insertSelective(SysControll record);

    List<SysControll> selectByExample(SysControllExample example);

    SysControll selectByPrimaryKey(String callId);

    int updateByExampleSelective(@Param("record") SysControll record, @Param("example") SysControllExample example);

    int updateByExample(@Param("record") SysControll record, @Param("example") SysControllExample example);

    int updateByPrimaryKeySelective(SysControll record);

    int updateByPrimaryKey(SysControll record);

    boolean getDataFlag();
}
