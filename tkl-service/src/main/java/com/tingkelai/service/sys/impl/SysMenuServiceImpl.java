package com.tingkelai.service.sys.impl;

import com.tingkelai.domain.sys.Menu;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单service实现类
 *
 * 2018-11-28 17:16:27
 * @author liuzhengjie
 * @version 1.0
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends CommonServiceImpl<Menu> implements ISysMenuService {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    public List<Menu> findMenuByUserId(Long id) {
        return sysUserService.findMenuListByUserId(id);
    }
}
