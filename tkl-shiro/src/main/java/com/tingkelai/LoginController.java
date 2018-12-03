package com.tingkelai;

import com.tingkelai.api.login.LoginApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.User;
import com.tingkelai.service.sys.impl.SysUserServiceImpl;
import com.tingkelai.shiro.authc.UsernamePasswordToken;
import com.tingkelai.shiro.util.UserUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录相关controller
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:09:49
 * @version 1.0
 */
@Controller
public class LoginController implements LoginApi {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping("/")
    public String helloWorld(){
        return "redirect:/swagger-ui.html";
    }

    @Override
    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public ResponseMessage ajaxLogin(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            subject.login(usernamePasswordToken);
            responseMessage.setMessage("登录成功");

            User user = UserUtils.getUser();

            Map map = new HashMap();
            map.put("button", sysUserService.findButtonListByUserId(user.getId()));
            map.put("menu", sysUserService.findMenuListByUserId(user.getId()));
            map.put("role", sysUserService.findRoleListByUserId(user.getId()));

            responseMessage.setData(map);
        } catch (UnavailableSecurityManagerException e) {

        } catch (InvalidSessionException e) {

        } catch (LockedAccountException e){
            responseMessage.setMessage("账号已锁定");
        } catch (UnknownAccountException e){
            responseMessage.setMessage("没有找到该账号");
        } catch (Exception e){
            System.err.print(e.getClass() + e.getMessage());
            e.printStackTrace();
            responseMessage.setMessage("账号或密码错误");
        }
        return responseMessage;
    }

    @Override
    @RequestMapping("/login")
    @ResponseBody
    public ResponseMessage login(HttpServletRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("登录成功");
        return responseMessage;
    }

    @Override
    @RequestMapping("/toLogin")
    @ResponseBody
    public ResponseMessage toLogin(HttpServletRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("没有登录，需要去登录页");
        return responseMessage;
    }

    @Override
    public ResponseMessage logout(HttpServletRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            responseMessage.setMessage("注销成功");
        }catch (Exception e) {
            e.printStackTrace();
            responseMessage.setMessage("注销失败");
        }
        return responseMessage;
    }


}
