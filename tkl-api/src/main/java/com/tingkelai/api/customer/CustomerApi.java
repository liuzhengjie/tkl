package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.domain.customer.Customer;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 客户相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户信息相关api")
public interface CustomerApi<T> {

    @ApiOperation(value = "获取客户列表（不带查询条件,带有排序）", nickname = "customerListGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", required = false),
    })
    @RequestMapping(value = "/customer/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerListGet(HttpServletRequest request);


    @ApiOperation(value = "获取客户列表（带有查询条件，高级查询功能）", nickname = "customerQueryListGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/query/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerQueryListGet(HttpServletRequest request);

    @ApiOperation(value = "删除客户信息", nickname = "customerDelete", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerDelete(HttpServletRequest request);

    @ApiOperation(value = "获取客户信息", nickname = "customerGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerGet(HttpServletRequest request);

    @ApiOperation(value = "添加客户信息", nickname = "customerPost", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerPost(HttpServletRequest request);


    @ApiOperation(value = "修改客户信息", nickname = "customerPut", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerPut(HttpServletRequest request);

    @ApiOperation(value = "批量删除客户信息", nickname = "customerUpdateDelete", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerUpdateDelete(HttpServletRequest request);


    @ApiOperation(value = "批量获取客户信息", nickname = "customerUpdateGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerUpdateGet(HttpServletRequest request);


    @ApiOperation(value = "批量添加客户信息", nickname = "customerUpdatePost", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerUpdatePost(HttpServletRequest request);


    @ApiOperation(value = "批量修改客户信息", nickname = "customerUpdatePut", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerUpdatePut(HttpServletRequest request);
}
