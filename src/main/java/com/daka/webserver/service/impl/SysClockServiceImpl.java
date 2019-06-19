package com.daka.webserver.service.impl;

import com.daka.webserver.dao.SysClockDao;
import com.daka.webserver.model.SysClock;
import com.daka.webserver.model.SysClockExample;
import com.daka.webserver.service.interfaces.SysClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-23 0:27
 */
@Service
public class SysClockServiceImpl implements SysClockService {

    @Autowired
    private SysClockDao dao;

    @Override
    public long countByExample(SysClockExample example) {
        return dao.countByExample(example);
    }

    @Override
    public int deleteByExample(SysClockExample example) {
        return dao.deleteByExample(example);
    }

    @Override
    public int insert(SysClock record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(SysClock record) {
        return dao.insertSelective(record);
    }

//    @Override
//    public List<SysClock> selectTodayData(String date) {
//        return dao.selectTodayData(date);
//    }

    @Override
    public List<SysClock> selectByExample(SysClockExample example) {
        return dao.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysClock record, SysClockExample example) {
        return dao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysClock record, SysClockExample example) {
        return dao.updateByExample(record, example);
    }
}
