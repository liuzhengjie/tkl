package com.tingkelai.shiro.filter;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.shiro.authc.UsernamePasswordToken;
import com.tingkelai.util.StringUtils;
import com.tingkelai.util.http.IpUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录认证处理类
 */
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(getClass());

	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
	public static final String DEFAULT_MESSAGE_ERROR_PARAM = "error";
	public static final String DEFAULT_MESSAGE_SUCCESS_PARAM = "success";
	public static final String DEFAULT_MESSAGE_NORMAL_PARAM = "normal";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	private String mobileLoginParam = DEFAULT_MOBILE_PARAM;
	private String messageErrorParam = DEFAULT_MESSAGE_ERROR_PARAM;
	private String messageSuccessParam = DEFAULT_MESSAGE_SUCCESS_PARAM;
	private String messageNormallParam = DEFAULT_MESSAGE_NORMAL_PARAM;

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		//用户名
		String username = getUsername(request);
		//密码
		String password = getPassword(request);
		if (password == null) {
			password = "";
		}
		//记住我功能
		boolean rememberMe = isRememberMe(request);
		//
		String host = IpUtils.getIpAddr((HttpServletRequest) request);
		//
		String captcha = getCaptcha(request);
		boolean mobile = isMobileLogin(request);
		return new com.tingkelai.shiro.authc.UsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha, mobile);
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}

	public void setMobileLoginParam(String mobileLoginParam) {
		this.mobileLoginParam = mobileLoginParam;
	}

	public void setMessageErrorParam(String messageErrorParam) {
		this.messageErrorParam = messageErrorParam;
	}

	public void setMessageSuccessParam(String messageSuccessParam) {
		this.messageSuccessParam = messageSuccessParam;
	}

	public void setMessageNormallParam(String messageNormallParam) {
		this.messageNormallParam = messageNormallParam;
	}

	public String getMessageErrorParam() {
		return messageErrorParam;
	}

	public String getMessageSuccessParam() {
		return messageSuccessParam;
	}

	public String getMessageNormallParam() {
		return messageNormallParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	public String getMobileLoginParam() {
		return mobileLoginParam;
	}

	protected boolean isMobileLogin(ServletRequest request) {
		return WebUtils.isTrue(request, getMobileLoginParam());
	}

	/**
	 * 登录成功之后跳转URL
	 */
	public String getSuccessUrl() {
		return super.getSuccessUrl();
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
		com.tingkelai.shiro.authc.UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		if (!authcToken.isMobileLogin()) {
			//web登录失败
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
			} else if (StringUtils.isNoneBlank(e.getMessage())) {
				message = e.getMessage();
			} else {
				message = "系统出现点问题，请稍后再试！";
				logger.error(e.getMessage());
			}
			request.setAttribute(getFailureKeyAttribute(), className);
			request.setAttribute(getMessageErrorParam(), message);
			return true;
		} else {
			responseMessage.setMessage("登录失败!");
			StringUtils.printJson((HttpServletResponse) response, responseMessage.toString());
			return false;
		}


	}

}