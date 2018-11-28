package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysButtonMapper;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysButtonService;
import org.springframework.stereotype.Service;

@Service("sysButtonService")
public class SysButtonServiceImpl extends CommonServiceImpl<SysButtonMapper, Button> implements ISysButtonService {
}
