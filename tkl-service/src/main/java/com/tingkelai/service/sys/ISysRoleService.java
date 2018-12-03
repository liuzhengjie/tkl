package com.tingkelai.service.sys;

import com.tingkelai.domain.sys.Role;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

/**
 * 角色相关service
 *
 * @author liuzhengjie
 * @date 2018-11-28 17:17:18
 * @version 1.0
 */
public interface ISysRoleService extends ICommonService<Role> {

    /** 新增角色菜单权限 */
    void sysRoleMenuPost(Role body);

    /** 修改角色菜单权限 */
    void sysRoleMenuPut(Role body);

    /** 新增角色按钮权限 */
    void sysRoleButtonPost(Role body);

    /** 修改角色菜单权限 */
    void sysRoleButtonPut(Role body);

    List<Role> findListByUserId(Long id);
}
