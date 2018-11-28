package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends CommonServiceImpl<SysUserMapper, User> implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User sysUserGet(Long id) {
        return sysUserMapper.sysUserGet(id);
    }

    @Override
    public User sysUserDelete(Long id) {
        sysUserMapper.sysUserDelete(id);
        return null;
    }

    @Override
    public User sysUserPost(User user){
        sysUserMapper.sysUserPost(user.getUserName());
        return null;
    }

    @Override
    public User sysUserPut(User user) {
        sysUserMapper.sysUserPut(user.getId(), user.getUserName());
        return null;
    }

    @Override
    public List<User> sysUserListGet() {
        List<User> userList = sysUserMapper.sysUserListGet();
//        List<User> userList = list();
        return userList;
    }
}
