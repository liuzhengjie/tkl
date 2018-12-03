package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.domain.sys.RoleMenu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
//@RequestMapping(value = "/v1")
public interface SysRoleApi<T> {

    @ApiOperation(value = "删除角色", nickname = "sysRoleDelete", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.DELETE)
    ResponseMessage<T> sysRoleDelete(HttpServletRequest request, T body);

    @ApiOperation(value = "获取角色信息", nickname = "sysRoleGet", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.GET)
    ResponseMessage<T> sysRoleGet(HttpServletRequest request, T body);


    @ApiOperation(value = "获取角色列表", nickname = "sysRoleListGet", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/list",
            method = RequestMethod.GET)
    ResponseMessage<List<T>> sysRoleListGet(HttpServletRequest request, T body);


    @ApiOperation(value = "删除可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRoleDelete", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.DELETE)
    ResponseMessage<T> sysRoleLowerLevelRoleDelete(HttpServletRequest request, T body);


    @ApiOperation(value = "添加可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePost", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.POST)
    ResponseMessage<T> sysRoleLowerLevelRolePost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/lower-level-role",
            params = {"menuIds"},
            method = RequestMethod.PUT)
    ResponseMessage<T> sysRoleLowerLevelRolePut(HttpServletRequest request, T body);


//    @ApiOperation(value = "设置指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPost", notes = "", tags={ "sys/role", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 405, message = "Invalid input") })
//    @RequestMapping(value = "/sys/role/menu",
//            params = {"menuIds"},
//            method = RequestMethod.POST)
//    ResponseMessage<T> sysRoleMenuPost(HttpServletRequest request, RoleMenu body);


    @ApiOperation(value = "修改指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/menu",
            params = {"menuIds"},
            method = RequestMethod.PUT)
    ResponseMessage<T> sysRoleMenuPut(HttpServletRequest request, RoleMenu body);

//    @ApiOperation(value = "设置指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPost", notes = "", tags={ "sys/role", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 405, message = "Invalid input") })
//    @RequestMapping(value = "/sys/role/button",
//            params = {"buttonIds"},
//            method = RequestMethod.POST)
//    ResponseMessage<T> sysRoleButtonPost(HttpServletRequest request, RoleButton body);


    @ApiOperation(value = "修改指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role/button",
            params = {"buttonIds"},
            method = RequestMethod.PUT)
    ResponseMessage<T> sysRoleButtonPut(HttpServletRequest request, RoleButton body);


    @ApiOperation(value = "创建角色", nickname = "sysRolePost", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.POST)
    ResponseMessage<T> sysRolePost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改角色信息", nickname = "sysRolePut", notes = "", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.PUT)
    ResponseMessage<T> sysRolePut(HttpServletRequest request, T body);


}

