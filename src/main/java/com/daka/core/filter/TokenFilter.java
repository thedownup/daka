package com.daka.core.filter;

import com.daka.core.bean.ResultModel;
import com.daka.utils.JSONUtils;
import com.daka.webserver.bean.CallNum;
import com.daka.webserver.model.SysConsumer;
import com.daka.webserver.model.SysConsumerExample;
import com.daka.webserver.model.SysControll;
import com.daka.webserver.model.SysControllExample;
import com.daka.webserver.service.interfaces.SysConsumerService;
import com.daka.webserver.service.interfaces.SysControllService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.RequestFacade;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description:
 * @author: zjt
 * @date: 2019-04-23 21:01
 */
public class TokenFilter implements Filter {

    @Autowired
    private SysConsumerService sysConsumerService;
    @Autowired
    private SysControllService sysControllService;

    private boolean dataFlag;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(context);
        sysConsumerService = ac.getBean(SysConsumerService.class);
        sysControllService = ac.getBean(SysControllService.class);
        dataFlag = sysControllService.getDataFlag();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        if (!dataFlag) {
            filterChain.doFilter(request, response);
            return;
        }

        ResultModel resultModel = new ResultModel();
        String secretid = request.getParameter("secretid");
        if (secretid == null || "".equals(secretid)) {
            resultModel.setMessage("secretid 为空");
            wirteError(response, resultModel);
            return;
        }


        SysConsumerExample sysConsumerExample = new SysConsumerExample();
        SysConsumerExample.Criteria criteria = sysConsumerExample.createCriteria();
        criteria.andSecretidEqualTo(secretid);
        List<SysConsumer> sysConsumers = sysConsumerService.selectByExample(sysConsumerExample);
        if (sysConsumers.size() == 0) {
            resultModel.setMessage("secretid 无效");
            wirteError(response, resultModel);
            return;
        }

        //调用权限
        SysControllExample sysControllExample = new SysControllExample();
        SysControllExample.Criteria sysControllExampleCriteria = sysControllExample.createCriteria();
        sysControllExampleCriteria.andSecretidEqualTo(secretid);
        List<SysControll> sysControlls = sysControllService.selectByExample(sysControllExample);

        if (sysControlls.size() <= 0) {
            resultModel.setMessage("无调用权限");
            wirteError(response, resultModel);
            return;
        } else {
            SysControll sysControll = sysControlls.get(0);
            Integer permission = sysControll.getPermission();
            if (permission == 0) {
                resultModel.setMessage("无调用权限");
                wirteError(response, resultModel);
                return;
            }
        }

        //验证data
        String data = request.getParameter("data");
        StringBuffer value = new StringBuffer();
        if (data == null || "".equals(data)) {
            resultModel.setMessage("data 为空");
            wirteError(response, resultModel);
            return;
        }

        Map<String, String[]> sortMap = new TreeMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        sortMap.put("secretkey", new String[]{sysConsumers.get(0).getSecrekey()});
        while (parameterNames.hasMoreElements()) {
            String pName = parameterNames.nextElement();
            if ("data".equals(pName)) continue;
            if ("file".equals(pName)) continue;
            sortMap.put(pName, request.getParameterValues(pName));
        }

        for (String key : sortMap.keySet()) {
            value.append(DigestUtils.md5Hex(sortMap.get(key)[0]));
        }
        //相同放行
        if (value.toString().trim().equals(data)) {
            //记录调用次数
            SysControll sysControll = sysControlls.get(0);
            String json = sysControll.getCallNum();
            CallNum callNum = JSONUtils.getObject(json, CallNum.class);
            String servletPath = ((RequestFacade) request).getServletPath();
            servletPath = servletPath.substring(servletPath.lastIndexOf("/") + 1);

            switch (servletPath) {
                case "adduser":
                    callNum.setXzyg(callNum.getXzyg() + 1);
                    break;
                case "queryuserbydate":
                    callNum.setQbd(callNum.getQbd() + 1);
                    break;
                case "record":
                    callNum.setRe(callNum.getRe() + 1);
                    break;
                case "edituser":
                    callNum.setEuser(callNum.getEuser() + 1);
                    break;
                case "deleteuser":
                    callNum.setDuser(callNum.getDuser() + 1);
                    break;
                case "compareuser":
                    callNum.setDk(callNum.getDk() + 1);
                    break;
                case "queryuser":
                    callNum.setQuser(callNum.getQuser() + 1);
                    break;
                default:

            }

            SysControllExample example = new SysControllExample();
            example.createCriteria().andSecretidEqualTo(secretid);
            sysControll.setCallNum(JSONUtils.getJson(callNum));
            sysControllService.updateByExample(sysControll, example);

            filterChain.doFilter(request, response);
        } else {
            resultModel.setMessage("data 错误");
            wirteError(response, resultModel);
        }
    }

    @Override
    public void destroy() {

    }

    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private void wirteError(ServletResponse response, ResultModel resultModel) throws IOException {
        resultModel.setSuccess(false);
        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String json = convertObjectToJson(resultModel);
        OutputStream out = response.getOutputStream();
        out.write(json.getBytes("UTF-8"));
        out.flush();
    }

}