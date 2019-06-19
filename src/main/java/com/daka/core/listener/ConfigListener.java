package com.daka.core.listener;

import com.daka.utils.GeneralUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @description:
 * @author: zjt
 * @date: 2018-11-27 22:29
 */
@WebListener
public class ConfigListener implements ServletContextListener {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConfigListener.class);

    @Value("${sys.face.photo.path}")
    private String userPhotoPath;

    @Value("${sys.face.npy.path}")
    private String userNpyPath;

    /**
     * 功能: 初始化各种配置
     * 作者: zjt
     * 日期: 2018/11/27 22:30
     * 版本: 1.0
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        LOGGER.info("-------初始化系统参数 --- 开始");

        GeneralUtils.createDir(userPhotoPath);
        GeneralUtils.createDir(userNpyPath);

        LOGGER.info("-------初始化系统参数 --- 结束");
    }
}