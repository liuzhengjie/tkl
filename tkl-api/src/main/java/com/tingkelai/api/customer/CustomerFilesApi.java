package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 客户文件资料相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户文件资料相关api")
public interface CustomerFilesApi<T> {
    @ApiOperation(value = "删除客户文件资料", nickname = "customerFilesDelete", notes = "", tags={ "customer/files", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerFilesDelete(T requestBody);


    @ApiOperation(value = "获取客户文件资料", nickname = "customerFilesGet", notes = "", tags={ "customer/files", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerFilesGet(T requestBody);


    @ApiOperation(value = "获取客户文件资料列表", nickname = "customerFilesListGet", notes = "", tags={ "customer/files", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/files/list",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerFilesListGet(T requestBody);


    @ApiOperation(value = "添加客户文件资料", nickname = "customerFilesPost", notes = "", tags={ "customer/files", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerFilesPost(T requestBody);


    @ApiOperation(value = "修改客户文件资料", nickname = "customerFilesPut", notes = "", tags={ "customer/files", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerFilesPut(T requestBody);
}
