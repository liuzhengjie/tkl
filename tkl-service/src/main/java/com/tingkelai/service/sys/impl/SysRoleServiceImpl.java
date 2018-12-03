package com.tingkelai.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.tingkelai.dao.sys.SysRoleMapper;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysRoleButtonService;
import com.tingkelai.service.sys.ISysRoleMenuService;
import com.tingkelai.service.sys.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色service实现类
 *
 * 2018-11-30 10:10:34
 * @author liuzhengjie
 * @version 1.0
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends CommonServiceImpl<Role> implements ISysRoleService {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    @Autowired
    private ISysRoleButtonService sysRoleButtonService;

    @Override
    public void sysRoleMenuPost(Role body) {

    }

    @Override
    public void sysRoleMenuPut(Role body) {

    }

    @Override
    public void sysRoleButtonPost(Role body) {

    }

    @Override
    public void sysRoleButtonPut(Role body) {

    }

    @Override
    public List<Role> findListByUserId(Long id) {
        return sysUserService.findRoleListByUserId(id);
    }
}
