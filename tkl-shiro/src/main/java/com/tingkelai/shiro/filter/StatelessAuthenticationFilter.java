package com.tingkelai.shiro.filter;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.shiro.authc.StatelessToken;
import com.tingkelai.shiro.jwt.JwtUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 无状态过滤器
 */
public class StatelessAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 使用无状态认证，所以每次都要进行验证
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue){
		return false;
	}

	/**
	 * 访问被拒绝
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		//token
		String token = getToken(request);
		//请求参数
		Map<String, String[]> paramsMap = request.getParameterMap();
		//无状态token
		Map<String, Object> map = JwtUtil.verifySessionToken(token);
		String username = (String)map.get("username");
		String password = (String)map.get("password");
		StatelessToken statelessToken = new StatelessToken(username, password);
		//进行登录验证
		try{
			getSubject(request, response).login(statelessToken);
		}catch (Exception e){
			ResponseMessage responseMessage = new ResponseMessage(e);
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.getWriter().write(responseMessage.toString());
			return false;
		}
		return true;
	}

	/** 获取请求token */
	private String getToken(ServletRequest request){
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String token = httpServletRequest.getHeader(StatelessToken.TOKEN_NAME);
		if(token == null || token.length() == 0){
			token = httpServletRequest.getParameter(StatelessToken.TOKEN_NAME);
		}
		return StringUtils.clean(token);
	}

	/**
	 * 登录失败调用事件
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		//定义返回信息
		ResponseMessage responseMessage = new ResponseMessage();
		super.onLoginFailure(token, e, request, response);
		//异常类型
		String className = e.getClass().getName();
		//返回消息体
		String message = "";
		if (IncorrectCredentialsException.class.getName().equals(className)
				|| UnknownAccountException.class.getName().equals(className)) {
			message = "用户或密码错误, 请重试.";
		} else if (UnknownAccountException.class.getName().equals(className)) {
			message = "请勿重复提交认证.";
		} else if (ExcessiveAttemptsException.class.getName().equals(className)) {
			message = "请勿重复提交认证,请半小时之后登录";
		} else {
			message = "系统出现点问题，请稍后再试！";
			logger.error("====登录出现问题：" + token.getPrincipal());
		}
		e.printStackTrace();
		responseMessage.setMessage(message);
		return true;
	}
}