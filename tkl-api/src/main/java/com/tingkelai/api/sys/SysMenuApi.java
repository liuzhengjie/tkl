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
import java.util.List;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
public interface SysMenuApi<T> {

    @ApiOperation(value = "删除资源（菜单）详情", nickname = "sysMenuDelete", notes = "", tags={ "sys/menu", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> sysMenuDelete(HttpServletRequest request, T body);


    @ApiOperation(value = "获取资源（菜单）详情", nickname = "sysMenuGet", notes = "", tags={ "sys/menu", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.GET)
    ApiResponseMessage<T> sysMenuGet(HttpServletRequest request, T body);


    @ApiOperation(value = "获取资源列表（登录人所在公司的菜单列表）", nickname = "sysMenuListGet", notes = "公司管理人员可以获取所有的资源列表，普通用户资源列表受管理员限制", tags={ "sys/menu", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/menu/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> sysMenuListGet(HttpServletRequest request, T body);


    @ApiOperation(value = "添加资源（菜单）", nickname = "sysMenuPost", notes = "树形结构的菜单", tags={ "sys/menu", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysMenuPost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改资源（菜单）详情", nickname = "sysMenuPut", notes = "", tags={ "sys/menu", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysMenuPut(HttpServletRequest request, T body);
}

