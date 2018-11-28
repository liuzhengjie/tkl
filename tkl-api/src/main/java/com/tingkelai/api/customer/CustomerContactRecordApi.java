package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.domain.customer.ContactRecord;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户联系记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户联系记录相关api")
public interface CustomerContactRecordApi<T> {
    @ApiOperation(value = "删除客户联系记录", nickname = "customerContactRecordDelete", notes = "", tags={ "customer/contact-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerContactRecordDelete(T requestBody);


    @ApiOperation(value = "获取客户联系记录信息", nickname = "customerContactRecordGet", notes = "", tags={ "customer/contact-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerContactRecordGet(T requestBody);


    @ApiOperation(value = "获取客户联系记录列表", nickname = "customerContactRecordListGet", notes = "", tags={ "customer/contact-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/contact-record/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerContactRecordListGet(T requestBody);


    @ApiOperation(value = "添加客户联系记录", nickname = "customerContactRecordPost", notes = "", tags={ "customer/contact-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerContactRecordPost(T requestBody);


    @ApiOperation(value = "修改客户联系记录", nickname = "customerContactRecordPut", notes = "", tags={ "customer/contact-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerContactRecordPut(T requestBody);
}
