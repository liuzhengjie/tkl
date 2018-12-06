package com.tingkelai.shiro.authc;

import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 无状态token
 *
 * 2018-11-29 15:06:51
 * @author liuzhengjie
 * @version 1.0
 */
@Configuration
public class StatelessToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	public static final String TOKEN_NAME = "token";

	private String token;

	private Map<String, ?> params;

	public StatelessToken(){}

    public StatelessToken(String token, Map<String, ?> params){
	    this.token = token;
	    this.params = params;
    }

    public StatelessToken(String username, String password){
        super(username, password);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Map<String, ?> getParams() {
        return params;
    }

    public void setParams(Map<String, ?> params) {
        this.params = params;
    }
}