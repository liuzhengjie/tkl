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
public interface SysRoleApi<T> {

    @ApiOperation(value = "删除角色", nickname = "sysRoleDelete", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> sysRoleDelete(HttpServletRequest request, T body);

    @ApiOperation(value = "获取角色信息", nickname = "sysRoleGet", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.GET)
    ApiResponseMessage<T> sysRoleGet(HttpServletRequest request, T body);


    @ApiOperation(value = "获取角色列表", nickname = "sysRoleListGet", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> sysRoleListGet(HttpServletRequest request, T body);


    @ApiOperation(value = "删除可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRoleDelete", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> sysRoleLowerLevelRoleDelete(HttpServletRequest request, T body);


    @ApiOperation(value = "添加可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePost", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysRoleLowerLevelRolePost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysRoleLowerLevelRolePut(HttpServletRequest request, T body);


    @ApiOperation(value = "设置指定角色可以管理的资源列表（包含按钮权限）", nickname = "sysRoleMenuListPost", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/menu-list",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysRoleMenuListPost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改指定角色可以管理的资源列表（包含按钮权限）", nickname = "sysRoleMenuListPut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/menu-list",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysRoleMenuListPut(HttpServletRequest request, T body);


    @ApiOperation(value = "创建角色", nickname = "sysRolePost", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysRolePost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改角色信息", nickname = "sysRolePut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysRolePut(HttpServletRequest request, T body);


}

