package com.tingkelai.api.sys;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
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
public interface SysTeamApi<T> {

    @ApiOperation(value = "获取公司信息", nickname = "sysTeamGet", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.GET)
    ApiResponseMessage<T> sysTeamGet(HttpServletRequest request, T body);


    @ApiOperation(value = "创建公司", nickname = "sysTeamPost", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysTeamPost(HttpServletRequest request, T body);


    @ApiOperation(value = "更新公司信息", nickname = "sysTeamPut", notes = "", tags={ "sys/team", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/team",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysTeamPut(HttpServletRequest request, T body);

}

