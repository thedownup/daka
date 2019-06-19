package com.daka.webserver.dao;

import com.daka.webserver.model.SysClock;
import com.daka.webserver.model.SysClockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysClockDao {
    long countByExample(SysClockExample example);

    int deleteByExample(SysClockExample example);

    int insert(SysClock record);

    int insertSelective(SysClock record);

    List<SysClock> selectByExample(SysClockExample example);

    int updateByExampleSelective(@Param("record") SysClock record, @Param("example") SysClockExample example);

    int updateByExample(@Param("record") SysClock record, @Param("example") SysClockExample example);
}