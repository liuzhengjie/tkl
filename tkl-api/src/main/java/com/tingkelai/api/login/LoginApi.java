package com.tingkelai.api.login;

import com.tingkelai.vo.user.LoginUserVO;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.user.RegistUserVO;
import com.tingkelai.vo.user.ResetUserVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "login", description = "登录相关(用户基本信息，注册)Api", tags = "login")
public interface LoginApi {

    @ApiOperation(value = "获取token", nickname = "getToken", notes = "获取token", tags={ "login", })
    @RequestMapping(value = "/getToken",
            method = RequestMethod.POST)
    ResponseMessage getToken(@RequestParam("username") String username,
                             @RequestParam("password") String password);

    @ApiOperation(value = "登录", nickname = "ajaxLogin", notes = "登录请求地址", tags={ "login", })
    @RequestMapping(value = "/ajaxLogin",
            method = RequestMethod.POST)
    ResponseMessage ajaxLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginUserVO loginUserVO);

    @ApiOperation(value = "注册", nickname = "regist", notes = "注册", tags={ "login", })
    @RequestMapping(value = "/regist",
            method = RequestMethod.POST)
    ResponseMessage regist(HttpServletRequest request, HttpServletResponse response, @RequestBody RegistUserVO registUserVO);

    @ApiOperation(value = "登录成功页面", nickname = "login", notes = "登录成功返回信息", tags={ "login", })
    @ApiImplicitParams({
            @ApiImplicitParam(name ="username",value="用户名",paramType="query",dataType="string",required=true),
            @ApiImplicitParam(name ="password",value="密码",paramType="query",dataType="string",required=true),
            @ApiImplicitParam(name = "rememberMe", value = "", required = false)
    })
    @RequestMapping(value = "/login",
            method = RequestMethod.GET)
    ResponseMessage login(HttpServletRequest request);

    @ApiOperation(value = "跳转到登录页面", nickname = "toLogin", notes = "跳转到登录页面", tags={ "login", })
    @RequestMapping(value = "/toLogin",
            method = RequestMethod.GET)
    ResponseMessage toLogin(HttpServletRequest request);


    @ApiOperation(value = "注销", nickname = "logout", notes = "注销访问", tags={ "login", })
    @RequestMapping(value = "/logout",
            method = RequestMethod.GET)
    ResponseMessage logout(HttpServletRequest request);

    @ApiOperation(value = "重置密码", nickname = "reset-password", notes = "重置密码", tags={ "login", })
    @RequestMapping(value = "/reset-password",
            method = RequestMethod.POST)
    ResponseMessage resetPassword(HttpServletRequest request, HttpServletResponse response, @RequestBody ResetUserVO resetUserVO);

    @ApiOperation(value = "手机号校验（判断系统是否存在该号码）", nickname = "verifyPhone", notes = "手机号校验", tags={ "login", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "body"),
    })
    @RequestMapping(value = "/verifyPhone",
            method = RequestMethod.POST)
    ResponseMessage verifyPhone(@RequestBody String phone);

}

