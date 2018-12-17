package com.tingkelai.service.sys.impl;

import com.tingkelai.dao.sys.SysUserMapper;
import com.tingkelai.domain.sys.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

//@ContextConfiguration(locations = {"classpath:application.yml"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SysUserServiceImpl.class)
public class SysUserServiceImplTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void sysUserGet() throws Exception {
        Long id = 1L;
        User user = sysUserMapper.sysUserGet(id);
        assertThat(user, notNullValue());
    }

    @Test
    public void sysUserDelete() throws Exception {
    }

    @Test
    public void sysUserPost() throws Exception {
    }

    @Test
    public void sysUserPut() throws Exception {
    }

    @Test
    public void sysUserListGet() throws Exception {
    }

    @Test
    public void findByUsername() throws Exception {
    }

    @Test
    public void findByEmail() throws Exception {
    }

    @Test
    public void findByPhone() throws Exception {
    }

    @Test
    public void findRoleListByUserId() throws Exception {
    }

    @Test
    public void findButtonListByUserId() throws Exception {
    }

    @Test
    public void findMenuListByUserId() throws Exception {
    }

    @Test
    public void changePassword() throws Exception {
    }

}