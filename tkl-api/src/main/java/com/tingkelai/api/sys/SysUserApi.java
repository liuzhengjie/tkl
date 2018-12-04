package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.User;
import com.tingkelai.domain.sys.UserRole;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.*;
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
public interface SysUserApi<VO> {

    @ApiOperation(value = "获取用户列表", nickname = "sysUserListGet", notes = "", response = List.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user/list",
            method = RequestMethod.GET)
    List<User> sysUserListGet(VO vo);

    @ApiOperation(value = "删除用户", nickname = "sysUserDelete", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.DELETE)
    Map<String, String> sysUserDelete(VO vo);


    @ApiOperation(value = "获取用户信息", nickname = "sysUserGet", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.GET)
    User sysUserGet(VO vo);


    @ApiOperation(value = "添加用户", nickname = "sysUserPost", notes = "", response = User.class, tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "", required = true),
//            @ApiImplicitParam(name = "password", value = "", required = true),
//            @ApiImplicitParam(name = "realname", value = "", required = false),
//            @ApiImplicitParam(name = "email", value = "", required = false),
//            @ApiImplicitParam(name = "phone", value = "", required = false)
//    })
    @RequestMapping(value = "/sys/user",
            method = RequestMethod.POST)
    User sysUserPost(VO vo);


    @ApiOperation(value = "修改用户信息", nickname = "sysUserPut", notes = "", tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"username" ,"id"},
            method = RequestMethod.PUT)
    ResponseEntity sysUserPut(VO vo);

    @ApiOperation(value = "设置指定用户的角色", nickname = "sysUserRolePost", notes = "", tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user/role",
            params = {"roleIds"},
            method = RequestMethod.PUT)
    ResponseMessage sysUserRolePost(UserRole body);
}

