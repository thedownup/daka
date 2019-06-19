package com.daka.webserver.service.impl;

import com.daka.webserver.dao.SysUserDao;
import com.daka.webserver.model.SysUser;
import com.daka.webserver.model.SysUserExample;
import com.daka.webserver.service.interfaces.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-23 0:25
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao dao;

    @Override
    public long countByExample(SysUserExample example) {
        return dao.countByExample(example);
    }

    @Override
    public int deleteByExample(SysUserExample example) {
        return dao.deleteByExample(example);
    }


    @Override
    public int insert(SysUser record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return dao.insertSelective(record);
    }

    @Override
    public List<SysUser> selectByExample(SysUserExample example) {
        return dao.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(SysUser record, SysUserExample example) {
        return dao.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(SysUser record, SysUserExample example) {
        return dao.updateByExample(record, example);
    }
}