package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysRoleMapper;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysRoleService;
import org.springframework.stereotype.Service;

@Service("sysRoleService")
public class SysRoleServiceImpl extends CommonServiceImpl<SysRoleMapper, Role> implements ISysRoleService {
}
