package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户经手人变更记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户经手人变更记录相关api")
public interface CustomerHandlerRecordApi<T> {

    @ApiOperation(value = "删除客户经手人变更记录", nickname = "customerHandlerRecordDelete", notes = "", tags={ "customer/handler-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/handler-record",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerHandlerRecordDelete(T requestBody);


    @ApiOperation(value = "获取客户经手人变更记录", nickname = "customerHandlerRecordGet", notes = "", tags={ "customer/handler-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/handler-record",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerHandlerRecordGet(T requestBody);


    @ApiOperation(value = "获取客户经手人变更记录列表", nickname = "customerHandlerRecordListGet", notes = "", tags={ "customer/handler-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/handler-record/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerHandlerRecordListGet(T requestBody);


    @ApiOperation(value = "添加客户经手人变更记录", nickname = "customerHandlerRecordPost", notes = "", tags={ "customer/handler-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/handler-record",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerHandlerRecordPost(T requestBody);


    @ApiOperation(value = "修改客户经手人变更记录", nickname = "customerHandlerRecordPut", notes = "", tags={ "customer/handler-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/handler-record",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerHandlerRecordPut(T requestBody);
}
