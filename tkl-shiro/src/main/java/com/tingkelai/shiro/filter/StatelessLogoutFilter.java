package com.tingkelai.shiro.filter;

import com.tingkelai.shiro.jwt.JwtUtil;
import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登出过滤器，用来注销token
 *
 * 2018-12-6 14:35:26
 * @author liuzhengjie
 * @version 1.0
 */
public class StatelessLogoutFilter extends LogoutFilter {

    /** 退出之前要将token设置为失效 */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String token = httpServletRequest.getHeader(JwtUtil.TOKEN_NAME);
        JwtUtil.expireToken(token);
        return super.preHandle(request, response);
    }
}
