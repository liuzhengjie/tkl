package com.tingkelai.service.sys.impl;

import com.tingkelai.domain.sys.User;
import com.tingkelai.util.env.EnvConfig;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * 加密方法
 *
 * 2018-11-29 20:22:37
 * @author liuzhengjie
 * @version 1.0
 */
@Configuration("passwordService")
@PropertySource(value = "file:${TKL_CONFIG_PATH}/application-test.properties")
public class PasswordServiceImpl {

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
//	@Value(value = "${shiro.credentials.hashAlgorithmName}")
	private String algorithmName = EnvConfig.getPropertyString("shiro.credentials.hashAlgorithmName");
//	@Value(value = "${shiro.credentials.hashIterations}")
	private final Integer hashIterations = EnvConfig.getPropertyInteger("shiro.credentials.hashIterations");

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		System.out.println(user.getCredentialsSalt());
		System.out.println(ByteSource.Util.bytes(user.getCredentialsSalt()));
		user.setPassword(newPassword);
	}
}
