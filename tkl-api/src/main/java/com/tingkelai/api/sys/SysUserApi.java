package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.User;
import com.tingkelai.vo.sys.UserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
@RequestMapping(value = "/")
public interface SysUserApi<VO> {

    @ApiOperation(value = "获取用户列表", nickname = "sysUserListGet", notes = "获取用户列表", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user/list",
            method = RequestMethod.GET)
    ResponseMessage sysUserListGet(VO vo);

    @ApiOperation(value = "删除用户", nickname = "sysUserDelete", notes = "删除用户", tags={ "sys/user", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.DELETE)
    ResponseMessage sysUserDelete(VO vo);


    @ApiOperation(value = "获取用户信息", nickname = "sysUserGet", notes = "获取用户信息", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user",
            params = {"id"},
            method = RequestMethod.GET)
    ResponseMessage sysUserGet(VO vo);


    @ApiOperation(value = "添加用户", nickname = "sysUserPost", notes = "添加用户", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user",
            method = RequestMethod.POST)
    ResponseMessage sysUserPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改用户信息", nickname = "sysUserPut", notes = "修改用户信息", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user",
            method = RequestMethod.PUT)
    ResponseMessage sysUserPut(@Valid @RequestBody VO vo);

    @ApiOperation(value = "设置指定用户的角色", nickname = "sysUserRolePost", notes = "设置指定用户的角色", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user/role",
            method = RequestMethod.PUT)
    ResponseMessage sysUserRolePost(@Valid @RequestBody UserRoleVO body);

    @ApiOperation(value = "修改密码", nickname = "changePassword", notes = "修改密码", tags={ "sys/user", })
    @RequestMapping(value = "/sys/user/changePassword",
            method = RequestMethod.POST)
    ResponseMessage changePassword(@RequestParam("username") String username,
                                   @RequestParam("password") String password);
}

