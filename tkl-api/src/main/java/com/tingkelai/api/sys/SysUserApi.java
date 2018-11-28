package com.tingkelai.api.sys;

import com.tingkelai.domain.sys.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
public interface SysUserApi {

    @ApiOperation(value = "获取用户列表", nickname = "sysUserListGet", notes = "", response = List.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user/list",
            method = RequestMethod.GET)
    List<User> sysUserListGet();

    @ApiOperation(value = "删除用户", nickname = "sysUserDelete", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.DELETE)
    Map<String, String> sysUserDelete(HttpServletRequest request);


    @ApiOperation(value = "获取用户信息", nickname = "sysUserGet", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.GET)
    User sysUserGet(HttpServletRequest request);


    @ApiOperation(value = "添加用户", nickname = "sysUserPost", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"username" },
            method = RequestMethod.POST)
    User sysUserPost(HttpServletRequest request);


    @ApiOperation(value = "修改用户信息", nickname = "sysUserPut", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"username" ,"id"},
            method = RequestMethod.PUT)
    ResponseEntity<User> sysUserPut(HttpServletRequest request);

}

