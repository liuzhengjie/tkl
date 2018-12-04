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
public interface SysButtonApi<VO> {

    @ApiOperation(value = "获取按钮列表（指定按钮下的按钮列表）", nickname = "sysButtonListGet", notes = "通过菜单id，获取该菜单下所有的按钮", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/button/list",
            method = RequestMethod.GET)
    ResponseMessage sysButtonListGet(VO body);

    @ApiOperation(value = "删除资源（按钮）详情", nickname = "sysButtonDelete", notes = "", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/button",
            method = RequestMethod.DELETE)
    ResponseMessage sysButtonDelete(VO vo);


    @ApiOperation(value = "获取资源（按钮）详情", nickname = "sysButtonGet", notes = "", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/button",
            method = RequestMethod.GET)
    ResponseMessage sysButtonGet(VO vo);

    @ApiOperation(value = "添加资源（按钮）", nickname = "sysButtonPost", notes = "树形结构的菜单", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/button",
            method = RequestMethod.POST)
    ResponseMessage sysMenuPost(@Valid @RequestBody VO vo);

    @ApiOperation(value = "修改资源（按钮）详情", nickname = "sysButtonPut", notes = "", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/button",
            method = RequestMethod.PUT)
    ResponseMessage sysButtonPut(@Valid @RequestBody VO vo);
}

