package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysDeptMapper;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDeptService")
public class SysDeptServiceImpl extends CommonServiceImpl<Dept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<Dept> getShopList(Long userId, Long teamId) throws Exception{
        // TODO
        return sysDeptMapper.getShopList(userId, teamId);
    }
}
