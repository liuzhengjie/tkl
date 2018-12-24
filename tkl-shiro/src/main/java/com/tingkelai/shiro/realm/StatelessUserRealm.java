package com.tingkelai.shiro.realm;

import com.tingkelai.constant.SystemConstant;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.exception.ex200.MultipleTeamException;
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

import java.util.*;

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
		//获取用户登录名（手机号）
		String username = authcToken.getUsername();
		//用户id不存在，抛出认证异常错误
		if(username == null){
			throw new AuthenticationException();
		}

		User user = null;
		//如果是选择公司之后再次登录，则用选择的公司登录，否则要判断账号是否存在多公司情况
		if(authcToken.getParams() != null && authcToken.getParams().containsKey(SystemConstant.TEAM_ID_NAME)){
			String teamId = (String) authcToken.getParams().get(SystemConstant.TEAM_ID_NAME);
			user = userService.findByPhoneAndTeamId(username, teamId);
		}else{
			//判断当前登陆账号是否存在多个公司
			List<User> userList = userService.findListByPhone(username);
			if(userList != null && userList.size() > 1){
				// 返回公司信息让用户选择
				List<Map<String, String>> teamList = new ArrayList<>();
				for(User temp : userList){
					Map<String, String> tempMap = new HashMap<>();
					tempMap.put(SystemConstant.TEAM_ID_NAME, temp.getTeamId() + "");
					tempMap.put("teamName", temp.getTeamName());
					teamList.add(tempMap);
				}
				MultipleTeamException multipleTeamException = new MultipleTeamException();
				multipleTeamException.setTeamList(teamList);
				throw multipleTeamException;
			}else if(userList != null && userList.size() == 1){
				user = userList.get(0);
			}
		}

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
		return authenticationInfo;
	}
}
