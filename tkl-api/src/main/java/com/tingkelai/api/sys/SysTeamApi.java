package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
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
public interface SysTeamApi<VO> {

    @ApiOperation(value = "获取公司信息", nickname = "sysTeamGet", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司id", required = true),
    })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.GET)
    ResponseMessage sysTeamGet(VO vo);


    @ApiOperation(value = "创建公司", nickname = "sysTeamPost", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.POST)
    ResponseMessage sysTeamPost(VO vo);


    @ApiOperation(value = "更新公司信息", nickname = "sysTeamPut", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.PUT)
    ResponseMessage sysTeamPut(VO vo);

}

