package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysMenuMapper;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysMenuService;
import org.springframework.stereotype.Service;

@Service("sysMenuService")
public class SysMenuServiceImpl extends CommonServiceImpl<SysMenuMapper, Menu> implements ISysMenuService {
}
