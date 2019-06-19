package com.daka.webserver.controller;

import com.daka.core.bean.HttpClientResult;
import com.daka.core.bean.PythonResultModel;
import com.daka.core.bean.ResultModel;
import com.daka.utils.GeneralUtils;
import com.daka.utils.HttpClientUtils;
import com.daka.utils.JSONUtils;
import com.daka.webserver.bean.User;
import com.daka.webserver.model.SysClock;
import com.daka.webserver.model.SysClockExample;
import com.daka.webserver.model.SysUser;
import com.daka.webserver.model.SysUserExample;
import com.daka.webserver.service.interfaces.SysClockService;
import com.daka.webserver.service.interfaces.SysConsumerService;
import com.daka.webserver.service.interfaces.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.client.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @description: 打卡的一系列操作
 * @author: zjt
 * @date: 2019-03-22 23:09
 */
@Controller
@RequestMapping("daka")
@Transactional
@Api(description = "打卡接口")
public class DakaController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DakaController.class);

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysClockService sysClockService;
    @Autowired
    private SysConsumerService sysConsumerService;
    @Autowired
    private GeneralUtils generalUtils;
    @Value("${sys.face.photo.path}")
    private String userPhotoPath;
    @Value("${sys.face.npy.path}")
    private String userNpyPath;
    @Value("${sys.python.url}")
    private String baseUrl;
    @Value("${sys.show.path}")
    private String showPath;

    /**
     * 功能: 传入员工编号、员工姓名、照片，添加一个员工信息到数据库，返回成功/失败
     * 作者: zjt
     * 日期: 2019/3/22 23:10
     * 版本: 1.0
     */
    @ApiOperation(value = "新增员工", notes = "传入 userName(员工姓名), userId(员工编号),file(照片) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("/adduser")
    @ResponseBody
    public ResultModel addUser(SysUser sysUser, @RequestParam("file") MultipartFile file) {
        ResultModel resultModel = new ResultModel();
        try {
            SysUserExample userExample = new SysUserExample();
            SysUserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserIdEqualTo(sysUser.getUserId());
            criteria.andSecretidEqualTo(sysUser.getSecretid());
            long count = sysUserService.countByExample(userExample);
            if (count >= 1) {
                resultModel.setMessage("检查员工编号重复");
                resultModel.setSuccess(false);
                return resultModel;
            }
            String uuid = UUID.randomUUID().toString();
            String photoPath = generalUtils.uploadFaceImage(uuid, file);
            sysUser.setCreateTime(new Date());
            sysUser.setUpdateTime(new Date());
            sysUser.setUserPhotoPath(photoPath);

            HashMap<String, String> map = new HashMap<>();
            map.put("input_images_path", photoPath);
            map.put("input_data_path", userNpyPath);
            map.put("data_name", uuid);
            HttpClientResult post = HttpClientUtils.doPost(baseUrl + "insertpersion", map);
            PythonResultModel pythonResultModel = JSONUtils.getObject(post.getContent(), PythonResultModel.class);
            if (pythonResultModel.isSuccess()) {
                if (!pythonResultModel.isHavepersion()) {
                    resultModel.setMessage("找不到人脸");
                    resultModel.setSuccess(false);
                    return resultModel;
                }
                sysUser.setUserDataPath(userNpyPath + uuid + ".npy");
                sysUserService.insert(sysUser);
            } else {
                resultModel.setMessage(pythonResultModel.getMessage());
                resultModel.setSuccess(false);
                return resultModel;
            }
        } catch (Exception e) {
            LOGGER.error("添加员工失败 检查工号是否重复" + e.getMessage());
            resultModel.setMessage("添加员工失败");
            resultModel.setSuccess(false);
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }

    /**
     * 功能: 传入姓名、照片，修改员工信息（工号不可改），返回成功/失败
     * 作者: zjt
     * 日期: 2019/3/22 23:10
     * 版本: 1.0
     */
    @ApiOperation(value = "修改员工", notes = "传入 userName(员工姓名), userId(员工编号),file(照片) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("/edituser")
    @ResponseBody
    public ResultModel editUser(SysUser sysUser, @RequestParam(value = "file", required = false) MultipartFile file) {
        ResultModel resultModel = new ResultModel();
        try {

            SysUserExample userExample = new SysUserExample();
            SysUserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserIdEqualTo(sysUser.getUserId());
            criteria.andSecretidEqualTo(sysUser.getSecretid());
            long countByExample = sysUserService.countByExample(userExample);
            if (countByExample != 1) {
                resultModel.setMessage("无此工号");
                resultModel.setSuccess(false);
                return resultModel;
            }
            SysUser localUser = sysUserService.selectByExample(userExample).get(0);
            String userName = sysUser.getUserName();
            if (file == null && userName != null) {
                localUser.setUpdateTime(new Date());
                if ("".equals(userName)) {
                    resultModel.setMessage("用户名不能为空");
                    resultModel.setSuccess(false);
                    return resultModel;
                }
                localUser.setUserName(userName);
                sysUserService.updateByExample(localUser, userExample);
                resultModel.setSuccess(true);
                resultModel.setMessage("修改成功");
                return resultModel;
            } else {
                localUser.setUpdateTime(new Date());
                String uuid = UUID.randomUUID().toString();
                String photoPath = generalUtils.uploadFaceImage(uuid, file);
                HashMap<String, String> map = new HashMap<>();
                map.put("input_images_path", photoPath);
                map.put("input_data_path", userNpyPath);
                map.put("data_name", uuid);
                HttpClientResult post = HttpClientUtils.doPost(baseUrl + "insertpersion", map);
                PythonResultModel pythonResultModel = JSONUtils.getObject(post.getContent(), PythonResultModel.class);
                if (pythonResultModel.isSuccess()) {
                    if (!pythonResultModel.isHavepersion()) {
                        resultModel.setMessage("找不到人脸 修改失败");
                        resultModel.setSuccess(false);
                        return resultModel;
                    }
                    localUser.setUpdateTime(new Date());
                    localUser.setUserDataPath(userNpyPath + uuid + ".npy");
                    localUser.setUserPhotoPath(photoPath);
                    if (!("".equals(userName) || userName == null))
                        localUser.setUserName(userName);
                    sysUserService.updateByExample(localUser, userExample);
                } else {
                    resultModel.setMessage(pythonResultModel.getMessage());
                    resultModel.setSuccess(false);
                    return resultModel;
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setMessage("erro" + e.getMessage());
            resultModel.setSuccess(false);
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;

    }

    /**
     * 功能: 传入员工编号，删除员工信息，返回成功/失败
     * 作者: zjt
     * 日期: 2019/3/22 23:13
     * 版本: 1.0
     */
    @ApiOperation(value = "删除员工", notes = "传入  userId(员工编号) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("deleteuser")
    @ResponseBody
    public ResultModel deleteUser(SysUser sysUser) {
        ResultModel resultModel = new ResultModel();
        try {
            SysUserExample userExample = new SysUserExample();
            userExample.createCriteria().andSecretidEqualTo(sysUser.getSecretid());
            userExample.createCriteria().andUserIdEqualTo(sysUser.getUserId());
            sysUserService.deleteByExample(userExample);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setSuccess(false);
            resultModel.setMessage("删除信息失败" + e.getMessage());
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }

    /**
     * 功能: 查询所有员工信息，返回所有员工的信息
     * 作者: zjt
     * 日期: 2019/3/22 23:13
     * 版本: 1.0
     */
    @ApiOperation(value = "查询员工", notes = "传入 page(从 0 开始 ) , pageSize(一次返回的数量) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("queryuser")
    @ResponseBody
    public ResultModel queryUser(String secretid, int page, int pageSize) {
        ResultModel resultModel = new ResultModel();
        try {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.setLimit(pageSize);
            sysUserExample.setOffset(Long.parseLong(page + ""));
            sysUserExample.createCriteria().andSecretidEqualTo(secretid);
            List<SysUser> sysUsers = sysUserService.selectByExample(sysUserExample);
            for (SysUser sysUser : sysUsers) {
                sysUser.setUserPhotoPath(showPath + sysUser.getUserPhotoPath());
            }
            resultModel.setObj(sysUsers);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setMessage(e.getMessage());
            resultModel.setSuccess(false);
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }

    /**
     * 功能: 1.传入照片、日期、时间，跟数据库当中的数据做对比，没
     * 有数据就返回一个错误信息，有就返回员工信息，记录表加一条数据
     * (人脸比对) 打卡
     * 作者: zjt
     * 日期: 2019/3/22 23:16
     * 版本: 1.0
     */
    @ApiOperation(value = "打卡接口", notes = "传入 late(0 为迟到 1为不迟到) , file(照片) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("compareuser")
    @ResponseBody
    public ResultModel compareUser(SysClock sysClock, @RequestParam(value = "file") MultipartFile file) {
        ResultModel resultModel = new ResultModel();
        try {
            HashMap<String, String> map = new HashMap<>();
            StringBuffer inputOtherNpyPaths = new StringBuffer();

            //先进行存储
            String uuid = UUID.randomUUID().toString();
            String photoPath = generalUtils.uploadFaceImage(uuid, file);
            map.put("input_images_path", photoPath);
            map.put("input_data_path", userNpyPath);
            map.put("data_name", uuid);
            HttpClientResult insertPost = HttpClientUtils.doPost(baseUrl + "insertpersion", map);
            PythonResultModel insertResult = JSONUtils.getObject(insertPost.getContent(), PythonResultModel.class);
            if (insertResult.isSuccess()) {
                String tmpUserNpyPath = userNpyPath + uuid + ".npy";
                SysUserExample sysUserExample = new SysUserExample();
                sysUserExample.createCriteria().andSecretidEqualTo(sysClock.getSecretid());
                List<SysUser> sysUsers = sysUserService.selectByExample(sysUserExample);
                for (SysUser sysUser : sysUsers) {
                    inputOtherNpyPaths.append(sysUser.getUserDataPath()).append(",");
                }
                map.clear();
                map.put("input_npy_path", tmpUserNpyPath);
                map.put("input_other_npy_paths", inputOtherNpyPaths.toString());
                HttpClientResult post = HttpClientUtils.doPost(baseUrl + "facecompare", map);
                PythonResultModel pythonResultModel = JSONUtils.getObject(post.getContent(), PythonResultModel.class);
                if (pythonResultModel.isSuccess()) {
                    if (pythonResultModel.isHavepersion()) {
                        String data = pythonResultModel.getData();
                        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
                        criteria.andUserDataPathEqualTo(data);
                        sysUsers = sysUserService.selectByExample(sysUserExample);
                        sysClock.setClockTime(new Date());
                        sysClock.setUserId(sysUsers.get(0).getUserId());
                        sysClock.setSecretid(sysClock.getSecretid());
                        sysClockService.insert(sysClock);
                        resultModel.setObj(sysUsers.get(0));
                    } else {
                        resultModel.setMessage("打卡失败 找不到此人");
                        resultModel.setSuccess(true);
                        return resultModel;
                    }
                } else {
                    resultModel.setSuccess(false);
                    return resultModel;
                }
            } else {
                resultModel.setSuccess(false);
                return resultModel;
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setMessage(e.getMessage());
            resultModel.setSuccess(false);
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }


    /**
     * 功能: 传入员工编号，查询该员工对应的打卡记录，返回记录表里的数据
     * 作者: zjt
     * 日期: 2019/3/22 23:19
     * 版本: 1.0
     */
    @ApiOperation(value = "查询该员工对应的打卡记录", notes = "传入 page(从 0 开始 ) , pageSize(一次返回的数量) userId(工号) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))",
            httpMethod = "POST")
    @RequestMapping("record")
    @ResponseBody
    public ResultModel record(String secretid, String userId, int page, int pageSize) {

        ResultModel resultModel = new ResultModel();
        try {
            SysClockExample sysClockExample = new SysClockExample();
            SysClockExample.Criteria criteria = sysClockExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            criteria.andSecretidEqualTo(secretid);
            sysClockExample.setLimit(pageSize);
            sysClockExample.setOffset(Long.parseLong(page + ""));
            sysClockExample.setOrderByClause("CLOCK_TIME DESC");
            List<SysClock> sysClocks = sysClockService.selectByExample(sysClockExample);
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andSecretidEqualTo(secretid)
                    .andUserIdEqualTo(userId);
            SysUser sysUser = sysUserService.selectByExample(sysUserExample).get(0);
            User user = new User();
            user.setName(sysUser.getUserName());
            user.setSysClocks(sysClocks);
            resultModel.setObj(user);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setMessage(e.getMessage());
            resultModel.setSuccess(false);
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;

    }

    /**
     * 功能: 传入日期，查询指定日期的记录，返回记录表里的数据
     * 作者: zjt
     * 日期: 2019/3/22 23:20
     * 版本: 1.0
     */
    @ApiOperation(value = "查询指定日期的记录，返回记录表里的数据 date(格式（2019-03-23）) secretid（调用凭证） data(md5值(各各参数 + secrekey(加密标识)))", notes = "不用传",
            httpMethod = "POST")
    @RequestMapping("queryuserbydate")
    @ResponseBody
    public ResultModel queryUserByDate(String date, String secretid) {
        ResultModel resultModel = new ResultModel();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String begDate = date + " 00:00:00";
            String endDate = date + " 23:59:59";
            SysClockExample clockExample = new SysClockExample();
            clockExample.createCriteria().andSecretidEqualTo(secretid).andClockTimeBetween(formatter.parse(begDate), formatter.parse(endDate));
            List<SysClock> sysClocks = sysClockService.selectByExample(clockExample);
            resultModel.setObj(sysClocks);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            resultModel.setMessage("erro" + e.getMessage());
            resultModel.setSuccess(false);
            return resultModel;
        }

        resultModel.setSuccess(true);
        return resultModel;
    }


}