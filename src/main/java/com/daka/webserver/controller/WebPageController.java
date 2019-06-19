package com.daka.webserver.controller;

import com.alibaba.fastjson.JSON;
import com.daka.core.bean.ResultModel;
import com.daka.utils.JSONUtils;
import com.daka.webserver.bean.CallNum;
import com.daka.webserver.bean.TableResult;
import com.daka.webserver.model.SysConsumer;
import com.daka.webserver.model.SysConsumerExample;
import com.daka.webserver.model.SysControll;
import com.daka.webserver.model.SysControllExample;
import com.daka.webserver.service.interfaces.SysConsumerService;
import com.daka.webserver.service.interfaces.SysControllService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: zjt
 * @date: 2019-05-01 14:45
 */
@Controller
public class WebPageController {

    @Autowired
    private SysConsumerService sysConsumerService;
    @Autowired
    private SysControllService sysControllService;

//    public static final class Type{
//        public static final String
//    }


    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        SysConsumer user = (SysConsumer) session.getAttribute("user");
        if (user != null) {
            return "show";
        }
        return "login";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

    @RequestMapping("/loginoutAdmin")
    public String loginoutAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        return "admin";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request) {
        return "admin";
    }

    @RequestMapping("loginadmin")
    @ResponseBody
    public ResultModel loginAdmin(HttpServletRequest request) {
        ResultModel resultModel = new ResultModel();
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            if ("admin".equals(name) && "admin".equals(password)) {
                request.getSession().setAttribute("admin", "1");
                resultModel.setSuccess(true);
            } else {
                resultModel.setSuccess(false);
                resultModel.setMessage("账号或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultModel.setSuccess(false);
            resultModel.setMessage("错误" + e.getLocalizedMessage());
            return resultModel;
        }
        return resultModel;
    }

    @RequestMapping("/adminManager")
    public String adminManager(HttpServletRequest request) {
        String admin = (String) request.getSession().getAttribute("admin");
        if (admin == null || "".equals(admin)) {
            return "admin";
        } else {
            return "adminManager";
        }
    }

    @RequestMapping("/adminManagerN")
    public String adminManagerN(HttpServletRequest request) {
        String admin = (String) request.getSession().getAttribute("admin");
        if (admin == null || "".equals(admin)) {
            return "admin";
        } else {
            return "adminManagerN";
        }
    }


    /**
     * 功能: 登录检查
     * 作者: zjt
     * 日期: 2019/5/1 20:13
     * 版本: 1.0
     */
    @RequestMapping("checklogin")
    @ResponseBody
    public ResultModel checkLogin(HttpServletRequest request, SysConsumer sysConsumer) {
        ResultModel resultModel = new ResultModel();
        try {
            SysConsumerExample sysConsumerExample = new SysConsumerExample();
            SysConsumerExample.Criteria criteria = sysConsumerExample.createCriteria();
            criteria.andUserNameEqualTo(sysConsumer.getUserName());
            criteria.andPassWordEqualTo(sysConsumer.getPassWord());
            List<SysConsumer> sysConsumers = sysConsumerService.selectByExample(sysConsumerExample);
            if (sysConsumers.size() >= 1) {
                request.getSession().setAttribute("user", sysConsumers.get(0));
                resultModel.setSuccess(true);
            } else {
                resultModel.setSuccess(false);
                resultModel.setMessage("账号或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultModel.setSuccess(false);
            resultModel.setMessage("错误" + e.getLocalizedMessage());
            return resultModel;
        }
        return resultModel;
    }

    @RequestMapping("register")
    @ResponseBody
    public ResultModel register(HttpServletRequest request, SysConsumer sysConsumer) {
        ResultModel resultModel = new ResultModel();
        try {
            //检查用户名
            SysConsumerExample example = new SysConsumerExample();
            SysConsumerExample.Criteria criteria = example.createCriteria();
            criteria.andUserNameEqualTo(sysConsumer.getUserName());
            int size = sysConsumerService.selectByExample(example).size();
            if (size >= 1) {
                resultModel.setSuccess(false);
                resultModel.setMessage("用户名存在");
                return resultModel;
            }
            //检查邮箱格式
            String email = sysConsumer.getEmail();
            if (!email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
                resultModel.setSuccess(false);
                resultModel.setMessage("邮箱格式不正确");
                return resultModel;
            }
            String secretid = getsecretid();
            sysConsumer.setUpdateTime(new Date());
            sysConsumer.setCreateTime(new Date());
            sysConsumer.setSecretid(secretid);
            sysConsumer.setSecrekey(getsecrekey());
            sysConsumerService.insert(sysConsumer);

            SysControll sysControll = new SysControll();
            sysControll.setSecretid(secretid);
            sysControll.setPermission(1);
            sysControll.setCallNum(JSONUtils.getJson(new CallNum()));
            sysControll.setCreateTime(new Date());
            sysControll.setUpdateTime(new Date());
            sysControllService.insert(sysControll);

            request.getSession().setAttribute("user", sysConsumer);
        } catch (Exception e) {
            e.printStackTrace();
            resultModel.setSuccess(false);
            resultModel.setMessage("注册失败");
            return resultModel;
        }
        resultModel.setSuccess(true);
        return resultModel;
    }

    @RequestMapping("/show")
    public String show(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        SysConsumer user = (SysConsumer) session.getAttribute("user");
        if (user == null) return "login";
        String secretid = user.getSecretid();

        SysControllExample example = new SysControllExample();
        SysControllExample.Criteria criteria = example.createCriteria();
        criteria.andSecretidEqualTo(secretid);
        List<SysControll> sysControlls = sysControllService.selectByExample(example);
        SysControll sysControll = sysControlls.get(0);

        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("callNum", JSONUtils.getObject(sysControll.getCallNum(), CallNum.class));
        } else {
            return "login";
        }
        return "show";
    }

    @RequestMapping("/changesecrekey")
    @ResponseBody
    public ResultModel changeSecrekey(HttpServletRequest request, SysConsumer sysConsumer) {
        ResultModel resultModel = new ResultModel();
        try {
            SysConsumerExample consumerExample = new SysConsumerExample();
            SysConsumerExample.Criteria criteria = consumerExample.createCriteria();
            SysConsumer user = (SysConsumer) request.getSession().getAttribute("user");
            criteria.andSecretidEqualTo(user.getSecretid());
            user.setSecrekey(sysConsumer.getSecrekey());
            user.setUpdateTime(new Date());
            sysConsumerService.updateByExample(user, consumerExample);
            resultModel.setSuccess(true);
            resultModel.setMessage("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultModel.setSuccess(false);
            resultModel.setMessage("修改失败");
        }
        return resultModel;
    }

    @RequestMapping("/getTableData")
    @ResponseBody
    public Map<String, Object> getTableData(HttpServletRequest request) {
        Map<String, Object> resultModel = new HashMap<>();
        try {
            String admin = (String) request.getSession().getAttribute("admin");
            ArrayList<TableResult> tableResults = new ArrayList<>();
            if (admin == null || "".equals(admin)) {
                return resultModel;
            } else {
                SysControllExample sysControllExample = new SysControllExample();
                List<SysControll> sysControlls = sysControllService.selectByExample(sysControllExample);
                for (SysControll sysControll : sysControlls) {
                    TableResult tableResult = new TableResult();
                    CallNum callNum = JSONUtils.getObject(sysControll.getCallNum(), CallNum.class);
                    tableResult.setStatus(sysControll.getPermission() >= 1 ? "有权限" : "无权限");
                    tableResult.setDk(callNum.getDk());
                    tableResult.setDuser(callNum.getDuser());
                    tableResult.setEuser(callNum.getEuser());
                    tableResult.setQbd(callNum.getQbd());
                    tableResult.setQuser(callNum.getQuser());
                    tableResult.setXzyg(callNum.getXzyg());
                    tableResult.setRe(callNum.getRe());
                    tableResult.setSecretid(sysControll.getSecretid());
                    SysConsumerExample consumerExample = new SysConsumerExample();
                    consumerExample.createCriteria().andSecretidEqualTo(sysControll.getSecretid());
                    SysConsumer consumer = sysConsumerService.selectByExample(consumerExample).get(0);
                    tableResult.setName(consumer.getUserName());
                    tableResults.add(tableResult);
                }
            }

            resultModel.put("rows", tableResults);
            resultModel.put("total", tableResults.size());
        } catch (Exception e) {
            e.printStackTrace();
            return resultModel;
        }
        return resultModel;
    }

    @RequestMapping("/permissionchange")
    @ResponseBody
    public ResultModel getTableData(HttpServletRequest request, String secretid) {
        ResultModel resultModel = new ResultModel();
        try {
            String admin = (String) request.getSession().getAttribute("admin");
            if (admin == null || "".equals(admin)) {
                resultModel.setSuccess(false);
                resultModel.setMessage("无权限");
                return resultModel;
            } else {
                SysControllExample sysControllExample = new SysControllExample();
                sysControllExample.createCriteria().andSecretidEqualTo(secretid);
                SysControll sysControll = sysControllService.selectByExample(sysControllExample).get(0);
                sysControll.setPermission(sysControll.getPermission() == 1 ? 0 : 1);
                sysControll.setUpdateTime(new Date());
                sysControllService.updateByExample(sysControll, sysControllExample);
            }
            resultModel.setSuccess(true);
            resultModel.setMessage("更改成功");
        } catch (Exception e) {
            resultModel.setSuccess(true);
            resultModel.setMessage("更改失败");
            return resultModel;
        }
        return resultModel;
    }


    private static String getsecretid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    private static String getsecrekey() {
        return UUID.randomUUID().toString().replaceAll("-", "") + (System.currentTimeMillis() + "").substring(6);
    }

}