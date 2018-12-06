package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
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
@Api(value = "sys", description = "系统相关api")
@RequestMapping(value = "/v1")
public interface SysMenuApi<VO> {

    @ApiOperation(value = "删除资源（菜单）详情", nickname = "sysMenuDelete", notes = "", tags={ "sys/menu", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.DELETE)
    ResponseMessage sysMenuDelete(VO vo);


    @ApiOperation(value = "获取资源（菜单）详情", nickname = "sysMenuGet", notes = "", tags={ "sys/menu", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.GET)
    ResponseMessage sysMenuGet(VO vo);


    @ApiOperation(value = "获取资源列表（登录人所在公司的菜单列表）", nickname = "sysMenuListGet", notes = "公司管理人员可以获取所有的资源列表，普通用户资源列表受管理员限制", tags={ "sys/menu", })
    @RequestMapping(value = "/sys/menu/list",
            method = RequestMethod.GET)
    ResponseMessage sysMenuListGet(VO vo);


    @ApiOperation(value = "添加资源（菜单）", nickname = "sysMenuPost", notes = "树形结构的菜单", tags={ "sys/menu", })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.POST)
    ResponseMessage sysMenuPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改资源（菜单）详情", nickname = "sysMenuPut", notes = "", tags={ "sys/menu", })
    @RequestMapping(value = "/sys/menu",
            method = RequestMethod.PUT)
    ResponseMessage sysMenuPut(@Valid @RequestBody VO vo);
}

