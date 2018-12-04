package com.tingkelai.shiro.util;

import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.ISysButtonService;
import com.tingkelai.service.sys.ISysMenuService;
import com.tingkelai.service.sys.ISysRoleService;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.shiro.realm.UserRealm.Principal;
import com.tingkelai.util.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * 用户相关工具类，主要是使用redis缓存
 *
 * 2018-11-30 10:37:24
 * @author liuzhengjie
 * @version 1.0
 */
public class UserUtils {

	//用户管理service
	private static ISysUserService userService = SpringContextHolder.getBean(ISysUserService.class);
	//角色管理service
	private static ISysRoleService roleService = SpringContextHolder.getBean(ISysRoleService.class);
	//菜单管理service
	private static ISysMenuService menuService = SpringContextHolder.getBean(ISysMenuService.class);
	//按钮管理service
	private static ISysButtonService buttonService = SpringContextHolder.getBean(ISysButtonService.class);
	// 缓存名
	public static final String USER_CACHE = "userCache";
	// id
	public static final String USER_CACHE_ID_ = "id_";
	// url
	public static final String USER_CACHE_USER_NAME_ = "username_";
	// roleList
	public static final String CACHE_ROLE_LIST = "roleList";
	// menuList
	public static final String CACHE_MENU_LIST = "menuList";
	// buttonList
	public static final String CACHE_BUTTON_LIST = "buttonList";

	/**
	 * 根据ID获取用户
	 */
	public static User get(Long id) {
		return userService.getById(id);
//		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
//		if (user == null) {
//			user = userService.getById(id);
//			if (user == null) {
//				return null;
//			}
//			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
//			CacheUtils.put(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUserName(), user);
//		}
//		return user;
	}

	/**
	 * 根据用户名获取用户`
	 */
	public static User getByUserName(String username) {
		User user = (User) CacheUtils.get(USER_CACHE, USER_CACHE_USER_NAME_ + username);
		if (user == null) {
			user = userService.findByUsername(username);
			if (user == null) {
				return null;
			}
			CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUserName(), user);
		}
		return user;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearCache() {
		//清除角色缓存
		removeCache(CACHE_ROLE_LIST);
		//清除菜单缓存
		removeCache(CACHE_MENU_LIST);
		//清除按钮缓存
		removeCache(CACHE_BUTTON_LIST);
		//清除用户基本信息
		clearCache(getUser());
	}

	/**
	 * 清除指定用户缓存
	 * 
	 * @param user
	 */
	public static void clearCache(User user) {
		CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + user.getId());
		CacheUtils.remove(USER_CACHE, USER_CACHE_USER_NAME_ + user.getUserName());
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回
	 */
	public static User getUser() {
		Principal principal = getPrincipal();
		if (principal != null) {
			User user = get(principal.getId());
			if (user != null) {
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}

	/**
	 * 获取当前用户角色列表
	 */
	public static List<Role> getRoleList() {
		List<Role> roleList = (List<Role>) getCache(CACHE_ROLE_LIST);
		if (roleList == null) {
			User user = getUser();
			roleList = roleService.findListByUserId(user.getId());
			putCache(CACHE_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 获取当前用户所有角色code构成的set对象
	 */
	public static Set<String> getRoleCodeSets() {
		//获取当前用户所有角色
		List<Role> roleList = getRoleList();
		Set<String> set = new HashSet<>();
		for(Role role: roleList){
			set.add(role.getCode());
		}
		return set;
	}

	/**
	 * 获取当前用户授权菜单
	 */
	public static List<Menu> getMenuList() {
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		if (menuList == null) {
			User user = getUser();
			menuList = menuService.findMenuByUserId(user.getId());
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	/**
	 * 获取当前用户授权按钮
	 * @return 当前用户有权限的按钮列表
	 */
	public static List<Button> getButtonList() {
		//获取按钮list
		List<Button> buttonList = (List<Button>)getCache(CACHE_BUTTON_LIST);
		if (buttonList == null) {
			User user = getUser();
			buttonList = buttonService.findButtonByUserId(user.getId());
			putCache(CACHE_BUTTON_LIST, buttonList);
		}
		return buttonList;
	}

	/**
	 * 获取当前用户的所有权限
	 * @return 权限字符串构成的set
	 */
	public static Set<String> getPermissionsList() {
		//权限返回值
		Set<String> permissionsList = new ConcurrentSkipListSet<>();
		//添加菜单权限
		permissionsList.addAll(getMenuPermissionsList());
		//添加按钮权限
		permissionsList.addAll(getButtonPermissionsList());
		return permissionsList;
	}

	/**
	 * 获取当前用户所有菜单权限
	 * @return 菜单权限构成的set
	 */
	public static Set<String> getMenuPermissionsList() {
		List<Menu> list = UserUtils.getMenuList();
		Set<String> permissionsList = new ConcurrentSkipListSet<>();
		for (Menu menu : list) {
			if (StringUtils.isNotBlank(menu.getPermission())) {
				// 添加基于Permission的权限信息
				for (String permission : StringUtils.split(menu.getPermission(), ",")) {
					if (StringUtils.isNotBlank(permission)) {
						permissionsList.add(permission);
					}
				}
			}
		}
		return permissionsList;
	}

	/**
	 * 获取当前用户所有按钮权限
	 * @return 按钮权限构成的set
	 */
	public static Set<String> getButtonPermissionsList() {
		List<Button> list = UserUtils.getButtonList();
		Set<String> permissionsList = new ConcurrentSkipListSet<>();
		for (Button button : list) {
			if (StringUtils.isNotBlank(button.getPermission())) {
				// 添加基于Permission的权限信息
				for (String permission : StringUtils.split(button.getPermission(), ",")) {
					if (StringUtils.isNotBlank(permission)) {
						permissionsList.add(permission);
					}
				}
			}
		}
		return permissionsList;
	}

	/**
	 * 获取授权主要对象
	 */
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static Principal getPrincipal() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Object test = subject.getPrincipal();
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
		} catch (UnavailableSecurityManagerException e) {
			throw e;
		}
		return null;
	}

	public static Session getSession() {
		try {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	// ============== Cache ==============
	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}

}
