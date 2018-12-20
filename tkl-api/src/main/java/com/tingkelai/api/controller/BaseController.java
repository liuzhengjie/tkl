package com.tingkelai.api.controller;

import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.sys.User;
import com.tingkelai.shiro.jwt.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通用controller
 * @author liuzhengjie
 * @date 2018-11-28 12:15:22
 * @version 1.0
 */
public class BaseController {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 封装常用参数，request，response，modelmap
     */
    private static final ThreadLocal<HttpServletRequest> requestContainer = new ThreadLocal<>();
    private static final ThreadLocal<HttpServletResponse> responseContainer = new ThreadLocal<>();
    private static final ThreadLocal<Model> modelContainer = new ThreadLocal<>();
//    private static final ThreadLocal<BindingResult> bindingResultContainer = new ThreadLocal<>();

    /**
     * 初始化response
     */
    @ModelAttribute
    private void initResponse(HttpServletResponse response) {
        responseContainer.set(response);
    }

    /**
     * 初始化request
     */
    @ModelAttribute
    private void initRequest(HttpServletRequest request) {
        requestContainer.set(request);
    }

    /**
     * 初始化model
     */
    @ModelAttribute
    private void initModel(Model model) {
        modelContainer.set(model);
    }

//    @ModelAttribute
//    private void initBindingResult(BindingResult bindingResult){
//        bindingResultContainer.set(bindingResult);
//    }

    /**
     * 获取当前线程的response对象
     */
    protected final HttpServletResponse getResponse() {
        return responseContainer.get();
    }

    /**
     * 获取当前线程的request对象
     */
    protected final HttpServletRequest getRequest() {
        return requestContainer.get();
    }

    /**
     * 获取当前线程的modelMap对象
     */
    protected final Model getModel() {
        return modelContainer.get();
    }

//    /**
//     * 获取bindingResult
//     */
//    protected final BindingResult getBindingResult(){
//        return bindingResultContainer.get();
//    }

    /**
     * 获取请求参数
     * @param key 参数名
     * @return 参数值
     */
    protected final String getParameter(String key) {
        HttpServletRequest request = getRequest();
        return request.getParameter(key);
    }

    /**
     * 获取请求参数（header里的）
     * @param key 参数名
     * @return 参数值
     */
    protected final String getHeader(String key) {
        HttpServletRequest request = getRequest();
        return request.getHeader(key);
    }

    /**
     * 获取当前用户所在公司
     * @return 当前用户所在公司id
     */
    protected final Long getCurrentUserTeamId() {
        HttpServletResponse response = getResponse();
        String teamId = response.getHeader(JwtUtil.TEAM_ID_NAME);
        return Long.parseLong(teamId);
    }

    /**
     * 获取当前用户id
     * @return 当前用户id
     */
    protected final Long getCurrentUserId(){
        HttpServletResponse response = getResponse();
        String userId = response.getHeader(JwtUtil.USER_ID_NAME);
        return Long.parseLong(userId);
    }
}
