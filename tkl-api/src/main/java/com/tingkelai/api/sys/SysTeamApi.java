package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统公司相关api", tags = "sys/team")
@RequestMapping(value = "/admin/v1")
public interface SysTeamApi<VO> {

    @ApiOperation(value = "获取公司信息", nickname = "sysTeamGet", notes = "获取公司信息", tags={ "sys/team", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司id", required = true),
    })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.GET)
    ResponseMessage sysTeamGet(VO vo);


    @ApiOperation(value = "创建公司", nickname = "sysTeamPost", notes = "创建公司", tags={ "sys/team", })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.POST)
    ResponseMessage sysTeamPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "更新公司信息", nickname = "sysTeamPut", notes = "更新公司信息", tags={ "sys/team", })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.PUT)
    ResponseMessage sysTeamPut(@Valid @RequestBody VO vo);

}

