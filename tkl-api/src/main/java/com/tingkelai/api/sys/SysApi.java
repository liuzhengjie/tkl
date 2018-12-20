package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "sys", description = "系统相关api", tags = "sys")
@RequestMapping(value = "/admin/v1")
public interface SysApi<VO> {

    @ApiOperation(value = "登录接口", nickname = "sysLoginPost", notes = "", tags={ "sys", })
    @RequestMapping(value = "/sys/login",
            method = RequestMethod.POST)
    ResponseMessage sysLoginPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "注销接口", nickname = "sysLogoutGet", notes = "", tags={ "sys", })
    @RequestMapping(value = "/sys/logout",
            method = RequestMethod.GET)
    ResponseMessage sysLogoutGet(@Valid @RequestBody VO vo);

    @ApiOperation(value = "注册接口", nickname = "sysRegisterPost", notes = "注册用户时，需要做以下几件事：1、创建公司（是否显示由产品决定）；2、生成公司数据字典；3、生成公司管理员菜单；4、生成常用模块列表（默认全选）", tags={ "sys", })
    @RequestMapping(value = "/sys/register",
            method = RequestMethod.POST)
    ResponseMessage sysRegisterPost(@Valid @RequestBody VO vo);
}

