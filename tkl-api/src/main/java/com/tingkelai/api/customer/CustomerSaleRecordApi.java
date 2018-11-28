package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户销售记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户销售记录相关api")
public interface CustomerSaleRecordApi<T> {

    @ApiOperation(value = "删除销售记录", nickname = "customerSaleRecordDelete", notes = "", tags={ "customer/sale-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerSaleRecordDelete(T requestBody);


    @ApiOperation(value = "获取销售记录", nickname = "customerSaleRecordGet", notes = "", tags={ "customer/sale-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerSaleRecordGet(T requestBody);


    @ApiOperation(value = "获取销售记录列表", nickname = "customerSaleRecordListGet", notes = "", tags={ "customer/sale-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-record/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerSaleRecordListGet(T requestBody);


    @ApiOperation(value = "添加销售记录", nickname = "customerSaleRecordPost", notes = "", tags={ "customer/sale-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerSaleRecordPost(T requestBody);


    @ApiOperation(value = "修改销售记录", nickname = "customerSaleRecordPut", notes = "", tags={ "customer/sale-record", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerSaleRecordPut(T requestBody);
}
