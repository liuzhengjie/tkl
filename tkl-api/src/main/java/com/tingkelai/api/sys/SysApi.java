package com.tingkelai.api.sys;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
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
@Api(value = "sys", description = "系统相关api")
public interface SysApi<T> {

    @ApiOperation(value = "登录接口", nickname = "sysLoginPost", notes = "", tags={ "sys", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/login",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysLoginPost(HttpServletRequest request, T body);


    @ApiOperation(value = "注销接口", nickname = "sysLogoutGet", notes = "", tags={ "sys", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/logout",
            method = RequestMethod.GET)
    ApiResponseMessage<T> sysLogoutGet(HttpServletRequest request, T body);

    @ApiOperation(value = "注册接口", nickname = "sysRegisterPost", notes = "注册用户时，需要做以下几件事：1、创建公司（是否显示由产品决定）；2、生成公司数据字典；3、生成公司管理员菜单；4、生成常用模块列表（默认全选）", tags={ "sys", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/register",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysRegisterPost(HttpServletRequest request, T body);
}

