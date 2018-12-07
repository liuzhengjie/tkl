package com.tingkelai.shiro.realm;

import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.shiro.authc.StatelessToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 无状态user认证处理类
 *
 * 2018-12-5 11:16:17
 * @author liuzhengjie
 * @version 1.0
 *
 */
public class StatelessUserRealm extends AuthorizingRealm {

	@Autowired
	private ISysUserService userService;

	/**
	 * 设置只支持StatelessToken
	 */
	public boolean supports(AuthenticationToken token) {
		//仅支持 StatelessToken 类型的 Token
		return token instanceof StatelessToken;
	}

	/**
	 * 授权的回调方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//认证时放入的是username
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		if(user != null){
			Long id = user.getId();
			//获取所有角色
			List<Role> roleList = userService.findRoleListByUserId(id);
			//获取菜单权限
			List<Menu> menuList = userService.findMenuListByUserId(id);
			//获取按钮权限
			List<Button> buttonList = userService.findButtonListByUserId(id);

			//后面可以转成lambda表达式
			Set<String> roleSet = new HashSet<>();
			Set<String> permissionSet = new HashSet<>();

			//添加角色code
			for(Role role : roleList){
				roleSet.add(role.getCode());
			}
			//添加菜单权限
			for(Menu menu : menuList){
				permissionSet.add(menu.getPermission());
			}
			//添加按钮权限
			for(Button button : buttonList){
				permissionSet.add(button.getPermission());
			}
			authorizationInfo.setRoles(roleSet);
			authorizationInfo.setStringPermissions(permissionSet);
		}
		return authorizationInfo;
	}

	/**
	 * 认证的回调方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取认证token
		StatelessToken authcToken = (StatelessToken) token;
		//获取用户登录名
		String username = authcToken.getUsername();
		//用户id不存在，抛出认证异常错误
		if(username == null){
			throw new AuthenticationException();
		}

		//通过用户名查找
		User user = userService.findByUsername(username);
		if (user == null) {
			throw new AuthenticationException();
		}

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUsername(), // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		System.out.println("====username:" + username);
		return authenticationInfo;
	}
}
