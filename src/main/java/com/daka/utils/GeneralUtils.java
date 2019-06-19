package com.daka.utils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import java.io.File;

/**
 * @description:
 * @author: zjt
 * @date: 2019-03-22 23:34
 */
@Component
public class GeneralUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(GeneralUtils.class);

    @Value("${sys.face.photo.path}")
    private String userPhotoPath;

    @Value("${sys.face.npy.path}")
    private String userNpyPath;

    /**
     * 功能: 获得图像的类型
     * 作者: zjt
     * 日期: 2018/11/21 22:25
     * 版本: 1.0
     */
    private static String getImageType(String fileName) {
        int dian = fileName.lastIndexOf(".");
        return fileName.substring(dian + 1);
    }

    public static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
            LOGGER.info("文件目录不存在" + path + "创建成功");
        }
    }

    /**
     * 功能: 上传人脸图片
     * 作者: zjt
     * 日期: 2019/3/23 0:50
     * 版本: 1.0
     */
    public String uploadFaceImage(String fileName, MultipartFile file) throws Exception {
        String imageType = getImageType(file.getOriginalFilename());
        String filePath = userPhotoPath + fileName + "." + imageType;
        FileUtils.writeByteArrayToFile(new File(filePath), file.getBytes());
        return filePath;
    }

}