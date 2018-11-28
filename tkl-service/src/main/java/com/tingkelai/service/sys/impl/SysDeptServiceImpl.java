package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysDeptMapper;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysDeptService;
import org.springframework.stereotype.Service;

@Service("sysDeptService")
public class SysDeptServiceImpl extends CommonServiceImpl<SysDeptMapper, Dept> implements ISysDeptService {
}
