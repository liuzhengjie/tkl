package com.tingkelai.sys.controller;

import com.tingkelai.TklConfigApplication;
import com.tingkelai.TklSysApplicationTest;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.service.sys.impl.SysUserRoleServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

@Rollback
public class SysUserControllerTest extends TklSysApplicationTest{

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserRoleServiceImpl sysUserRoleService;

    @Test
    public void sysUserListGet() throws Exception {
        String testStr = "asdf";
        assertEquals(testStr, testStr);

        assertThat("a", startsWith("a"));

    }

    @Test
    public void sysUserDelete() throws Exception {
    }

    @Test
    public void sysUserGet() throws Exception {
    }

    @Test
    public void sysUserPost() throws Exception {
    }

    @Test
    public void sysUserPut() throws Exception {
    }

    @Test
    public void sysUserRolePost() throws Exception {
    }

    @Test
    public void changePassword() throws Exception {
    }

}