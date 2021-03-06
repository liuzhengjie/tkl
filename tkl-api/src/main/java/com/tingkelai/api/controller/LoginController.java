package com.tingkelai.api.controller;

import com.tingkelai.api.login.LoginApi;
import com.tingkelai.constant.SystemConstant;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.sys.User;
import com.tingkelai.exception.ex200.MultipleTeamException;
import com.tingkelai.exception.ex200.PhoneNotFoundException;
import com.tingkelai.exception.ex200.VerifyCodeException;
import com.tingkelai.exception.ex300.AccountPasswordException;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.sys.impl.SysUserServiceImpl;
import com.tingkelai.shiro.authc.StatelessToken;
import com.tingkelai.shiro.jwt.JwtUtil;
import com.tingkelai.util.redis.RedisUtils;
import com.tingkelai.vo.sys.UserVO;
import com.tingkelai.vo.user.LoginUserVO;
import com.tingkelai.vo.user.RegistUserVO;
import com.tingkelai.vo.user.ResetUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

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

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String helloWorld(){
//        System.out.println(env.getProperty("justTest"));
//        System.out.println(env.getProperty("justTest2.tingkelai"));
//        System.out.println(env.getProperty("url"));
//        System.err.println(EnvUtil.getString("justTest"));
//        EnvUtil.getString("justTest");
//        System.out.println(        EnvUtil.getStringValue("url"));
        return "redirect:/swagger-ui.html";
    }


    @Override
    @ResponseBody
    @Deprecated
    public ResponseMessage getToken(String username, String password) {
        ResponseMessage<String> responseMessage = new ResponseMessage<>();
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        String token = JwtUtil.signSessionToken(map);
        responseMessage.setMessage("获取token成功");
        map.clear();
        map.put("token", token);
        responseMessage.setData(token);
        return responseMessage;
    }

    @Override
    @ResponseBody
    public ResponseMessage<Map<String, Object>> ajaxLogin(HttpServletRequest request, HttpServletResponse response, LoginUserVO loginUserVO) {
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage<>();
        try {
            // 登录账号
            String username = loginUserVO.getUsername();
            // 登录密码
            String password = loginUserVO.getPassword();
            // 登录公司id
            String teamId = loginUserVO.getTeamId();
            Subject subject = SecurityUtils.getSubject();
            StatelessToken statelessToken = new StatelessToken(username, password);
            if(teamId != null){
                Map<String, String> paramsMap = new HashMap<>();
                paramsMap.put(SystemConstant.TEAM_ID_NAME, teamId);
                statelessToken.setParams(paramsMap);
            }
            subject.login(statelessToken);
            responseMessage.setMessage("登录成功");

            //添加用户基本信息
            String tempUserName = (String)subject.getPrincipal();
            User user = sysUserService.findByUsername(tempUserName);
            Map<String, Object> map = new HashMap<>();
            UserVO userVO = new UserVO();
            map.put("user", userVO.toVO(user));
            responseMessage.setData(map);

            //生成token
            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("username", username);
            tokenMap.put("userId", user.getId());
            tokenMap.put("teamId", user.getTeamId());
            String token = JwtUtil.signSessionToken(tokenMap);
            response.setHeader(JwtUtil.TOKEN_NAME, token);
        } catch (LockedAccountException e){
            responseMessage.setMessage("账号已锁定");
        } catch (UnknownAccountException e){
            responseMessage.setMessage("没有找到该账号");
        } catch (MultipleTeamException e){
            responseMessage.setCode(200001);
            responseMessage.setMessage("当前账号属于多个公司，请选择要登录的公司！");
            Map<String, Object> map = new HashMap<>();
            map.put("teamList", e.getTeamList());
            responseMessage.setData(map);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseMessage<>(new AccountPasswordException());
        }
        return responseMessage;
    }

    @Override
    @ResponseBody
    public ResponseMessage<Map<String, Object>> regist(HttpServletRequest request, HttpServletResponse response, RegistUserVO registUserVO) {
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage<>();
        try {
            // 判断验证码是否存在
            if(registUserVO.getVerifyCode() == null){
                return new ResponseMessage<>(new VerifyCodeException());
            }else{
                // 校验验证码
                boolean verifyFlag = verifyCode(SystemConstant.REGIST_NAME_PRE + registUserVO.getPhone(), registUserVO.getVerifyCode());
                if(!verifyFlag){
                    return new ResponseMessage<>(new VerifyCodeException());
                }
                User user = new User();
                // 手机号、密码、公司名都必须存在
                if(registUserVO.getPhone() == null || registUserVO.getPassword() == null || registUserVO.getTeamName() == null){
                    return new ResponseMessage<>(new LackParamsException());
                }
                user.setPhone(registUserVO.getPhone());
                user.setUsername(UUID.randomUUID().toString());
                user.setPassword(registUserVO.getPassword());
                user.setRealname(registUserVO.getRealname());
                Team team = new Team();
                team.setName(registUserVO.getTeamName());
                boolean flag = sysUserService.regist(user, team);
                Map<String, Object> tokenMap = new HashMap<>();
                tokenMap.put("username", user.getUsername());
                tokenMap.put("userId", user.getId());
                tokenMap.put("teamId", user.getTeamId());
                String token = JwtUtil.signSessionToken(tokenMap);
                response.setHeader(JwtUtil.TOKEN_NAME, token);
                if(flag){
                    responseMessage.setMessage("注册成功");
                }else{
                    responseMessage.setCode(200002);
                    responseMessage.setMessage("注册失败");
                }
            }
        }catch (Exception e){
            responseMessage = new ResponseMessage<>(e);
        }
        return responseMessage;
    }

    /** 校验验证码是否正确 */
    private boolean verifyCode(String phone, String verifyCode) {
        String code = RedisUtils.getKey(phone);
        if(code == null){
            return false;
        }
        if(code.length() != 6 || !code.equals(verifyCode)){
            return false;
        }
        return true;
    }

    @Override
    @ResponseBody
    public ResponseMessage login(HttpServletRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("登录成功");
        return responseMessage;
    }

    @Override
    @ResponseBody
    public ResponseMessage toLogin(HttpServletRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("没有登录，需要去登录页");
        return responseMessage;
    }

    @Override
    @ResponseBody
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

    @Override
    @ResponseBody
    public ResponseMessage<Map<String, Object>> resetPassword(HttpServletRequest request, HttpServletResponse response, ResetUserVO resetUserVO) {
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage<>();
        try {
            String phone = resetUserVO.getPhone();
            String verifyCode = resetUserVO.getVerifyCode();
            if(verifyCode(SystemConstant.RESET_NAME_PRE + phone,verifyCode)){
                sysUserService.resetPassword(resetUserVO.getPhone(), resetUserVO.getPassword());
            }else{
                return new ResponseMessage<>(new VerifyCodeException());
            }
            responseMessage.setMessage("重置密码成功");
            return responseMessage;
        }catch (Exception e){
            responseMessage = new ResponseMessage<>(e);
        }
        return responseMessage;
    }

    @Override
    @ResponseBody
    public ResponseMessage verifyPhone(String phone) {
        ResponseMessage<Map<String, Object>> responseMessage = new ResponseMessage<>();
        try {
            List<User> userList = sysUserService.findListByPhone(phone);
            if(userList == null || userList.size() == 0){
                return new ResponseMessage(new PhoneNotFoundException());
            }
            responseMessage.setMessage("ok");
            return responseMessage;
        }catch (Exception e){
            return new ResponseMessage<>(e);
        }
    }


}
