package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.*;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sys.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl extends CommonServiceImpl<User> implements ISysUserService {

    private static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private PasswordServiceImpl passwordService;

    @Autowired
    private SysTeamServiceImpl sysTeamService;

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
    public List<User> findListByPhone(String phone) {
        return sysUserMapper.findListByPhone(phone);
    }

    @Override
    public User findByPhoneAndTeamId(String phone, String teamId) {
        return sysUserMapper.findByPhoneAndTeamId(phone, teamId);
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
    public boolean resetPassword(String phone, String password) {
        List<User> userList = sysUserMapper.findListByPhone(phone);
        //重设密码
        for(User user : userList){
            user.setPassword(password);
            saveOrUpdate(user);
        }
        return true;
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

    @Override
    public boolean regist(User user, Team team) {
        try {
            //保存公司信息
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 30);
            team.setDeadline(calendar.getTime());
            sysTeamService.save(team);
            Long teamId = team.getId();
            //保存用户信息
            user.setTeamId(teamId);
            save(user);
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
}
