package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends CommonServiceImpl<User> implements ISysUserService {

    @Autowired
    private PasswordServiceImpl passwordService;

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
        passwordService.encryptPassword(user);
        save(user);
        return user;
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

    @Override
    public User findByUsername(String username) {
        return getById(username);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByPhone(String phone) {
        return null;
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

}
