package com.tingkelai.shiro.filter;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.exception.TokenFailureException;
import com.tingkelai.shiro.authc.StatelessToken;
import com.tingkelai.shiro.jwt.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 无状态过滤器
 */
public class StatelessAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 创建自定义token
	 */
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		return new StatelessToken(getUsername(request), getPassword(request));
	}

	/**
	 * 使用无状态认证，如果请求含有token，且token中含有系统指定apikey，则认证通过，否则拒绝访问
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
		try {
			//获取token
			String token = getToken(request);
			//token为空，拒绝访问
			if(token == null){
				return false;
			}
			//解析token
			Map<String, Object> map = JwtUtil.verifySessionToken(token);
			//token不含apikey，非法登录，拒绝访问
			if(map.get(JwtUtil.TOKEN_NAME) == null){
				logger.warn("====非法访问！伪造的token：" + map);
				return false;
			}else{
				//判断token到期时间，如果快要到期，则更新token
                String refreshToken = JwtUtil.refreshToken(token, map);
                if(refreshToken == null){
                    //token已过期，抛出异常
                    throw new TokenFailureException();
                }else{
                    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                    httpServletResponse.setHeader(JwtUtil.TOKEN_NAME, refreshToken);
                }
				return true;
			}
		}catch (Exception e){
			return false;
		}
	}

	/** 获取请求token */
	private String getToken(ServletRequest request){
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String token = httpServletRequest.getHeader(JwtUtil.TOKEN_NAME);
		if(token == null || token.length() == 0){
			token = httpServletRequest.getParameter(JwtUtil.TOKEN_NAME);
		}
		return StringUtils.clean(token);
	}

	/**
	 * 访问被拒绝
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		return super.onAccessDenied(request, response);
	}

	/**
	 * 登录成功
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
		return super.onLoginSuccess(token, subject, request, response);
	}

	/**
	 * 登录失败
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		return super.onLoginFailure(token, e, request, response);
	}
}