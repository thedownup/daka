package com.daka.webserver.service.impl;

import com.daka.webserver.dao.SysControllDao;
import com.daka.webserver.model.SysControll;
import com.daka.webserver.model.SysControllExample;
import com.daka.webserver.service.interfaces.SysControllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-05-14 19:57
 */
@Service
public class SysControllServiceImpl implements SysControllService {

    @Value("${dataFlag}")
    private boolean dataFlag;
    @Autowired
    private SysControllDao dao;

    @Override
    public long countByExample(SysControllExample example) {
        return dao.countByExample(example);
    }

    @Override
    public int deleteByExample(SysControllExample example) {
        return dao.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String secretid) {
        return dao.deleteByPrimaryKey(secretid);
    }

    @Override
    public int insert(SysControll record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(SysControll record) {
        return dao.insertSelective(record);
    }

    @Override
    public List<SysControll> selectByExample(SysControllExample example) {
        return dao.selectByExample(example);
    }

    @Override
    public SysControll selectByPrimaryKey(String secretid) {
        return dao.selectByPrimaryKey(secretid);
    }

    @Override
    public int updateByExampleSelective(SysControll record, SysControllExample example) {
        return dao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysControll record, SysControllExample example) {
        return dao.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(SysControll record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysControll record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public boolean getDataFlag() {
        return dataFlag;
    }
}