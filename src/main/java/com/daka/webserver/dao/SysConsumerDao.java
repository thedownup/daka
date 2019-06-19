package com.daka.webserver.dao;

import com.daka.webserver.model.SysConsumer;
import com.daka.webserver.model.SysConsumerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConsumerDao {
    long countByExample(SysConsumerExample example);

    int deleteByExample(SysConsumerExample example);

    int insert(SysConsumer record);

    int insertSelective(SysConsumer record);

    List<SysConsumer> selectByExample(SysConsumerExample example);

    int updateByExampleSelective(@Param("record") SysConsumer record, @Param("example") SysConsumerExample example);

    int updateByExample(@Param("record") SysConsumer record, @Param("example") SysConsumerExample example);
}