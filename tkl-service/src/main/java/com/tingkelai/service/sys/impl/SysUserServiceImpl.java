package com.tingkelai.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysUserService")
public class SysUserServiceImpl extends CommonServiceImpl<User> implements ISysUserService {

    @Autowired
    private PasswordServiceImpl passwordService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return sysUserMapper.findByEmail(email);
    }

    @Override
    public User findByPhone(String phone) {
        return sysUserMapper.findByPhone(phone);
    }

    @Override
    public List<Role> findRoleListByUserId(Long id) {
        return sysUserMapper.findRoleListByUserId(id);
    }

    @Override
    public List<Button> findButtonListByUserId(Long id) {
        return sysUserMapper.findButtonByUserId(id);
    }

    @Override
    public List<Menu> findMenuListByUserId(Long id) {
        return sysUserMapper.findMenuByUserId(id);
    }

    @Override
    public boolean changePassword(String username, String password) {
        User user = sysUserMapper.findByUsername(username);
        user.setPassword(password);
        passwordService.encryptPassword(user);
        return saveOrUpdate(user);
    }

    @Override
    public boolean saveOrUpdate(User user) {
        passwordService.encryptPassword(user);
        return super.saveOrUpdate(user);
    }

    @Override
    public boolean save(User user) {
        passwordService.encryptPassword(user);
        return super.save(user);
    }
}
