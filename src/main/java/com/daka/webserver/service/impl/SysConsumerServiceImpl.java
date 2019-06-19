package com.daka.webserver.service.impl;

import com.daka.webserver.dao.SysConsumerDao;
import com.daka.webserver.model.SysConsumer;
import com.daka.webserver.model.SysConsumerExample;
import com.daka.webserver.service.interfaces.SysConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-04-24 21:04
 */
@Service
public class SysConsumerServiceImpl implements SysConsumerService {

    @Autowired
    private SysConsumerDao dao;

    @Override
    public long countByExample(SysConsumerExample example) {
        return dao.countByExample(example);
    }

    @Override
    public int deleteByExample(SysConsumerExample example) {
        return dao.deleteByExample(example);
    }

    @Override
    public int insert(SysConsumer record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(SysConsumer record) {
        return dao.insert(record);
    }

    @Override
    public List<SysConsumer> selectByExample(SysConsumerExample example) {
        return dao.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysConsumer record, SysConsumerExample example) {
        return dao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysConsumer record, SysConsumerExample example) {
        return dao.updateByExample(record, example);
    }
}