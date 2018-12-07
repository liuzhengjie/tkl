package com.tingkelai.shiro.authc.credential;

import com.tingkelai.shiro.authc.StatelessToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

/**
 *
 * 多次登录处理类
 *
 * 2018-11-29 15:03:16
 * @author liuzhengjie
 * @version 1.0
 */
@Component
public class StatelessCredentialsMatcher extends HashedCredentialsMatcher {

	public StatelessCredentialsMatcher() {
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		return super.doCredentialsMatch(token, info);
	}

}
