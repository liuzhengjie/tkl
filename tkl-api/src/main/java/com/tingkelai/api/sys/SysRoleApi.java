package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.vo.sys.RoleButtonVO;
import com.tingkelai.vo.sys.RoleMenuVO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统角色相关api", tags = "sys/role")
@RequestMapping(value = "/admin/v1")
public interface SysRoleApi<VO> {

    @ApiOperation(value = "删除角色", nickname = "sysRoleDelete", notes = "删除角色", tags={ "sys/role", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.DELETE)
    ResponseMessage sysRoleDelete(VO vo);

    @ApiOperation(value = "获取角色信息", nickname = "sysRoleGet", notes = "获取角色信息", tags={ "sys/role", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.GET)
    ResponseMessage sysRoleGet(VO vo);


    @ApiOperation(value = "获取角色列表", nickname = "sysRoleListGet", notes = "获取角色列表", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/list",
            method = RequestMethod.GET)
    ResponseMessage sysRoleListGet(VO vo);


    @ApiOperation(value = "删除可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRoleDelete", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.DELETE)
    ResponseMessage sysRoleLowerLevelRoleDelete(VO vo);


    @ApiOperation(value = "添加可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePost", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/lower-level-role",
            method = RequestMethod.POST)
    ResponseMessage sysRoleLowerLevelRolePost(VO vo);


    @ApiOperation(value = "修改可以管理的下级角色(用于管理数据权限)", nickname = "sysRoleLowerLevelRolePut", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/lower-level-role",
            params = {"menuIds"},
            method = RequestMethod.PUT)
    ResponseMessage sysRoleLowerLevelRolePut(VO vo);



    @ApiOperation(value = "修改指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPut", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/menu",
            method = RequestMethod.PUT)
    ResponseMessage sysRoleMenuPut(@Valid @RequestBody RoleMenuVO body);

    @ApiOperation(value = "修改指定角色可以管理的资源列表（菜单）", nickname = "sysRoleMenuListPut", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role/button",
            method = RequestMethod.PUT)
    ResponseMessage sysRoleButtonPut(@Valid @RequestBody RoleButtonVO body);


    @ApiOperation(value = "创建角色", nickname = "sysRolePost", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.POST)
    ResponseMessage sysRolePost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改角色信息", nickname = "sysRolePut", notes = "", tags={ "sys/role", })
    @RequestMapping(value = "/sys/role",
            method = RequestMethod.PUT)
    ResponseMessage sysRolePut(@Valid @RequestBody VO vo);


}

