package com.daka.webserver.service.interfaces;

import com.daka.webserver.model.SysClock;
import com.daka.webserver.model.SysClockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-23 0:27
 */
public interface SysClockService {

    long countByExample(SysClockExample example);

    int deleteByExample(SysClockExample example);

    int insert(SysClock record);

    int insertSelective(SysClock record);

//    List<SysClock> selectTodayData(String date);

    List<SysClock> selectByExample(SysClockExample example);

    int updateByExampleSelective(@Param("record") SysClock record, @Param("example") SysClockExample example);

    int updateByExample(@Param("record") SysClock record, @Param("example") SysClockExample example);

}
