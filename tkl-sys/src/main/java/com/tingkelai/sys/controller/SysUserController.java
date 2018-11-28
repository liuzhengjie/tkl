package com.tingkelai.sys.controller;

import com.tingkelai.api.sys.SysUserApi;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户处理类
 *
 * @author liuzhengjie
 * @date 2018-11-23 16:32:49
 * @version 1.0
 */
@RestController
public class SysUserController implements SysUserApi {

    @Autowired
    private ISysUserService sysUserService;

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Override
    public List<User> sysUserListGet() {
        List<User> userList = sysUserService.sysUserListGet();
        return userList;
    }

    @Override
    public Map<String, String> sysUserDelete(HttpServletRequest request) {
        String id = request.getParameter("id");
        User user = sysUserService.sysUserDelete(Long.parseLong(id));
        Map<String, String> map = new HashMap<>();
        map.put("success", "删除成功！");
        return map;
    }

    public User sysUserGet(HttpServletRequest request) {
        String id = request.getParameter("id");
        User user = sysUserService.sysUserGet(Long.parseLong(id));
        return user;
    }

    @Override
    public User sysUserPost(HttpServletRequest request) {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        User tempUser = new User();
        tempUser.setUserName(username);
        sysUserService.sysUserPost(tempUser);
        return tempUser;
    }

    @Override
    public ResponseEntity<User>  sysUserPut(HttpServletRequest request) {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        User tempUser = new User();
        tempUser.setId(Long.parseLong(id));
        tempUser.setUserName(username);
        sysUserService.sysUserPut(tempUser);
        return new ResponseEntity<User>(tempUser, HttpStatus.OK);
    }

}
