package com.tingkelai.shiro.realm;

import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.ISysMenuService;
import com.tingkelai.service.sys.ISysRoleMenuService;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.shiro.authc.UsernamePasswordToken;
import com.tingkelai.shiro.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * realm处理类
 *
 * 2018-11-29 14:46:29
 * @author liuzhengjie
 * @version 1.0
 *
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService userService;

	/**
	 * 授权的回调方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Principal principal = (Principal) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if(principal != null){
			authorizationInfo.setRoles(UserUtils.getRoleCodeSets());
			authorizationInfo.setStringPermissions(UserUtils.getPermissionsList());
		}
		return authorizationInfo;
	}

	/**
	 * 认证的回调方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取认证token
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		//用户名
		String username = authcToken.getUsername();

		//通过用户名查找
		User user = userService.findByUsername(username);
		if (user == null) {
			//通过邮箱查找
			user = userService.findByEmail(username);
			if (user == null) {
				//通过手机号查找
				user = userService.findByPhone(username);
			}
		}
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}

		// 判断账号是否锁定
		if (User.STATUS_LOCKED == user.getUserStatus()) {
			throw new LockedAccountException(); // 帐号锁定
		}

		Principal principal = new Principal(user, false);

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				principal, // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		// 记录登录日志
//		LogUtils.saveLog(ServletUtils.getRequest(), "系统登录");
		return authenticationInfo;
	}

	/**
	 * 授权用户信息
	 */
	public static class Principal implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id; // 编号
		private String username; // 登录名
		private String realname; // 姓名
		private boolean mobileLogin; // 是否手机登录

		public Principal(User user, boolean mobileLogin) {
			this.id = user.getId();
			this.username = user.getUserName();
			this.realname = user.getRealName();
			this.mobileLogin = mobileLogin;
		}

		public Long getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

		public String getRealname() {
			return realname;
		}

		public boolean isMobileLogin() {
			return mobileLogin;
		}

		/**
		 * 获取SESSIONID
		 */
		public String getSessionid() {
			try {
				return (String) UserUtils.getSession().getId();
			} catch (Exception e) {
				return "";
			}
		}

		@Override
		public String toString() {
			return id + "";
		}

	}
}
