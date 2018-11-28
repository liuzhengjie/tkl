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
import java.util.List;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
public interface SysDeptApi<T> {
    @ApiOperation(value = "删除部门", nickname = "sysDeptDelete", notes = "", tags={ "sys/dept", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> sysDeptDelete(HttpServletRequest request, T body);


    @ApiOperation(value = "获取部门信息", nickname = "sysDeptGet", notes = "", tags={ "sys/dept", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.GET)
    ApiResponseMessage<T> sysDeptGet(HttpServletRequest request, T body);


    @ApiOperation(value = "获取部门列表（树形结构）", nickname = "sysDeptListGet", notes = "", tags={ "sys/dept", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dept/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> sysDeptListGet(HttpServletRequest request, T body);


    @ApiOperation(value = "创建部门", nickname = "sysDeptPost", notes = "", tags={ "sys/dept", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.POST)
    ApiResponseMessage<T> sysDeptPost(HttpServletRequest request, T body);


    @ApiOperation(value = "修改部门信息", nickname = "sysDeptPut", notes = "", tags={ "sys/dept", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> sysDeptPut(HttpServletRequest request, T body);
}

