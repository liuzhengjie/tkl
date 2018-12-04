package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户服务记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户服务记录相关api")
public interface CustomerServiceRecordApi<T> {

    @ApiOperation(value = "删除客户服务记录", nickname = "customerServiceRecordDelete", notes = "", tags={ "customer/service-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerServiceRecordDelete(T requestBody);


    @ApiOperation(value = "获取客户服务记录", nickname = "customerServiceRecordGet", notes = "", tags={ "customer/service-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.GET)
    ResponseMessage customerServiceRecordGet(T requestBody);


    @ApiOperation(value = "获取客户服务记录列表", nickname = "customerServiceRecordListGet", notes = "", tags={ "customer/service-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/service-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerServiceRecordListGet(T requestBody);


    @ApiOperation(value = "添加客户服务记录", nickname = "customerServiceRecordPost", notes = "", tags={ "customer/service-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.POST)
    ResponseMessage customerServiceRecordPost(T requestBody);


    @ApiOperation(value = "修改客户服务记录", nickname = "customerServiceRecordPut", notes = "", tags={ "customer/service-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.PUT)
    ResponseMessage customerServiceRecordPut(T requestBody);
}
