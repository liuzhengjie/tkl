package com.tingkelai.service.sys;


import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

public interface ISysUserService extends ICommonService<User> {

    User sysUserGet(Long id);

    User sysUserDelete(Long id);

    User sysUserPost(User user);

    User sysUserPut(User user);

    List<User> sysUserListGet();

    /** 根据用户名查找用户 */
    User findByUsername(String username);

    /** 根据邮箱查找用户 */
    User findByEmail(String email);

    /** 根据手机号查找用户 */
    User findByPhone(String phone);

    /** 根据用户id获取用户的所有角色 */
    List<Role> findRoleListByUserId(Long id);

    /** 根据用户id获取用户的所有角色 */
    List<Button> findButtonListByUserId(Long id);

    /** 根据用户id获取用户的所有角色 */
    List<Menu> findMenuListByUserId(Long id);

    boolean changePassword(String username, String password);
}
