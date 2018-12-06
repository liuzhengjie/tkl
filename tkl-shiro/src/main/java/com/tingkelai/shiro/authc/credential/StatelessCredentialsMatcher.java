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
		Hash tokenHashedCredentials = (Hash)this.hashProvidedCredentials(token, info);
		Hash  accountCredentials = (Hash)this.getCredentials(info);
		System.out.println(tokenHashedCredentials.toHex());
		System.out.println(accountCredentials.toHex());

		String a = accountCredentials.toHex();
		super.doCredentialsMatch(token, info);

//		String password = (String)token.getCredentials();
		Hash simpleHash = new SimpleHash("md5", "123",
				ByteSource.Util.bytes("admin" + "d5c7539a44e6c1c9798037ab5693a6d8"), 2);

		String pas = new SimpleHash("md5", "123",
				ByteSource.Util.bytes("admin"), 2).toHex();

		String paasdfss = new SimpleHash("md5", "123",
				ByteSource.Util.bytes("d5c7539a44e6c1c9798037ab5693a6d8"), 2).toHex();

		return super.doCredentialsMatch(token, info);
	}

}
