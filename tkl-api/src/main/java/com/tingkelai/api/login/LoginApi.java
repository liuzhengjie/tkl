package com.tingkelai.api.login;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "login", description = "登录相关Api", tags = "login")
public interface LoginApi {

    @ApiOperation(value = "登录", nickname = "ajaxLogin", notes = "", tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name ="username",value="用户名",paramType="query",dataType="string",required=true),
            @ApiImplicitParam(name ="password",value="密码",paramType="query",dataType="string",required=true),
    })
    @RequestMapping(value = "/ajaxLogin",
            method = RequestMethod.POST)
    ResponseMessage ajaxLogin(HttpServletRequest request);

//    @ApiOperation(value = "跳转到登录认证页面", nickname = "toLogin", notes = "", tags={ "login", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 405, message = "Invalid input") })
//    @ApiImplicitParams({
//            @ApiImplicitParam(name ="username",value="用户名",paramType="query",dataType="string",required=true),
//            @ApiImplicitParam(name ="password",value="密码",paramType="query",dataType="string",required=true),
//            @ApiImplicitParam(name = "rememberMe", value = "", required = false)
//    })
    @RequestMapping(value = "/login",
            method = RequestMethod.GET)
    ResponseMessage login(HttpServletRequest request);

    @ApiOperation(value = "登录认证", nickname = "login", notes = "", tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/toLogin",
            method = RequestMethod.GET)
    ResponseMessage toLogin(HttpServletRequest request);


    @ApiOperation(value = "注销", nickname = "logout", notes = "", tags={ "login", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/logout",
            method = RequestMethod.GET)
    ResponseMessage logout(HttpServletRequest request);

}

