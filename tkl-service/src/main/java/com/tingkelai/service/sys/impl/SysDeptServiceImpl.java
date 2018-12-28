package com.tingkelai.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.dao.sys.SysDeptMapper;
import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysDeptService")
public class SysDeptServiceImpl extends CommonServiceImpl<Dept> implements ISysDeptService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Override
    public List<Dept> getShopList(Long userId, Long teamId) throws Exception{
        // TODO
        return sysDeptMapper.getShopList(userId, teamId);
    }


    public List<User> getDeptUser(Long teamId, Long userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User entity = new User();
        queryWrapper.setEntity(entity);
        queryWrapper.eq("team_id", teamId);
        return sysUserService.list(queryWrapper);
    }

    public List<Dept> getDeptList(Long teamId, Long userId) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        Dept dept = new Dept();
        queryWrapper.setEntity(dept);
        queryWrapper.eq("team_id", teamId);
        return sysDeptMapper.selectList(queryWrapper);
    }
}
