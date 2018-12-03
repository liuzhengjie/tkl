package com.tingkelai.shiro.authc;

import org.springframework.context.annotation.Configuration;

/**
 * 用户名密码管理token
 *
 * 2018-11-29 15:06:51
 * @author liuzhengjie
 * @version 1.0
 */
@Configuration
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	private boolean mobileLogin;

	public UsernamePasswordToken() {
	}

	public UsernamePasswordToken(String username, String password) {
		super(username, password);
	}

	public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha,
			boolean mobileLogin) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.mobileLogin = mobileLogin;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public boolean isMobileLogin() {
		return mobileLogin;
	}

}