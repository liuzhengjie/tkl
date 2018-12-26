package com.tingkelai.service.sys;


import com.tingkelai.domain.sys.*;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

public interface ISysUserService extends ICommonService<User> {

    /** 根据用户名查找用户 */
    User findByUsername(String username);

    /** 根据邮箱查找用户 */
    User findByEmail(String email);

    /** 根据手机号查找用户 */
    User findByPhone(String phone);

    /** 根据手机号查找用户列表 */
    List<User> findListByPhone(String phone);

    /** 根据手机号和用户公司id获取用户信息 */
    User findByPhoneAndTeamId(String phone, String teamId);

    /** 根据用户id获取用户的所有角色 */
    List<Role> findRoleListByUserId(Long id);

    /** 根据用户id获取用户的所有角色 */
    List<Button> findButtonListByUserId(Long id);

    /** 根据用户id获取用户的所有角色 */
    List<Menu> findMenuListByUserId(Long id);

    /** 根据username重置密码 */
    boolean changePassword(String username, String password);

    /** 根据手机号重置密码 */
    boolean resetPassword(String phone, String password);

    /** 用户注册 */
    boolean regist(User user, Team team);
}
