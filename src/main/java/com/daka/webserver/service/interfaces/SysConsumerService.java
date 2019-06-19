package com.daka.webserver.service.interfaces;

import com.daka.webserver.model.SysConsumer;
import com.daka.webserver.model.SysConsumerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-04-24 21:04
 */
public interface SysConsumerService {

    long countByExample(SysConsumerExample example);

    int deleteByExample(SysConsumerExample example);

    int insert(SysConsumer record);

    int insertSelective(SysConsumer record);

    List<SysConsumer> selectByExample(SysConsumerExample example);

    int updateByExampleSelective(@Param("record") SysConsumer record, @Param("example") SysConsumerExample example);

    int updateByExample(@Param("record") SysConsumer record, @Param("example") SysConsumerExample example);

}
