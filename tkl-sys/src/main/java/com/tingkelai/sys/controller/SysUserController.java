package com.tingkelai.sys.controller;

import com.tingkelai.api.sys.SysUserApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.User;
import com.tingkelai.domain.sys.UserRole;
import com.tingkelai.service.sys.ISysUserRoleService;
import com.tingkelai.service.sys.ISysUserService;
import com.tingkelai.service.sys.impl.SysUserRoleServiceImpl;
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
public class SysUserController implements SysUserApi<User> {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private SysUserRoleServiceImpl sysUserRoleService;

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
    public User sysUserPost(HttpServletRequest request, User user) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("eamil");
//        String phone = request.getParameter("phone");
//        String realname = request.getParameter("realname");
//        User tempUser = new User();
//        tempUser.setUserName(username);
//        tempUser.setPassword(password);
//        tempUser.setEmail(email);
//        tempUser.setPhone(phone);
//        tempUser.setRealName(realname);
        User tempUser = sysUserService.sysUserPost(user);
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

    @Override
    public ResponseMessage<User> sysUserRolePost(HttpServletRequest request, UserRole body) {
        ResponseMessage<User> roleResponseMessage = new ResponseMessage<>();
        roleResponseMessage.success("权限设置成功");
        try {
            //获取用户id
            Long userId = body.getUserId();
            Map<String, Object> map = new HashMap<>();
            map.put("user_id", userId);
            sysUserRoleService.removeByMap(map);
            String roleIds = request.getParameter("roleIds");
            if(roleIds != null){
                String[] arr = roleIds.split(",");
                for(int i = 0; i < arr.length; i++){
                    UserRole temp = new UserRole();
                    temp.setId(body.getId());
                    String roleId = arr[i];
                    temp.setRoleId(Long.parseLong(roleId));
                    temp.setUserId(body.getUserId());
                    sysUserRoleService.saveOrUpdate(temp);
                }
            }else{
                sysUserRoleService.saveOrUpdate(body);
            }
            //保存用户按钮权限
//            UserUtils.clearCache();
        } catch (Exception e) {
            e.printStackTrace();
            roleResponseMessage.fail("权限设置失败");
        }
        return roleResponseMessage;
    }

}
