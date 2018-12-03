package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
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
@Api(value = "v1/customer",
        description = "客户信息相关api",
        tags = "customer")
@RequestMapping(value = "/v1")
public interface CustomerApi<T> {

    @ApiOperation(value = "获取客户列表（不带查询条件,带有排序）", nickname = "customerListGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a", required = false),
    })
    @RequestMapping(value = "/customer/list",
            method = RequestMethod.GET)
    ResponseMessage<List<T>> customerListGet(HttpServletRequest request);


    @ApiOperation(value = "获取客户列表（带有查询条件，高级查询功能）", nickname = "customerQueryListGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/query/list",
            method = RequestMethod.GET)
    ResponseMessage<List<T>> customerQueryListGet(HttpServletRequest request);

    @ApiOperation(value = "删除客户信息", nickname = "customerDelete", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.DELETE)
    ResponseMessage<T> customerDelete(HttpServletRequest request);

    @ApiOperation(value = "获取客户信息", nickname = "customerGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.GET)
    ResponseMessage<T> customerGet(HttpServletRequest request);

    @ApiOperation(value = "添加客户信息", nickname = "customerPost", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.POST)
    ResponseMessage<T> customerPost(HttpServletRequest request);


    @ApiOperation(value = "修改客户信息", nickname = "customerPut", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer",
            method = RequestMethod.PUT)
    ResponseMessage<T> customerPut(HttpServletRequest request);

    @ApiOperation(value = "批量删除客户信息", nickname = "customerUpdateDelete", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.DELETE)
    ResponseMessage<T> customerUpdateDelete(HttpServletRequest request);


    @ApiOperation(value = "批量获取客户信息", nickname = "customerUpdateGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.GET)
    ResponseMessage<T> customerUpdateGet(HttpServletRequest request);


    @ApiOperation(value = "批量添加客户信息", nickname = "customerUpdatePost", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.POST)
    ResponseMessage<T> customerUpdatePost(HttpServletRequest request);


    @ApiOperation(value = "批量修改客户信息", nickname = "customerUpdatePut", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/update",
            method = RequestMethod.PUT)
    ResponseMessage<T> customerUpdatePut(HttpServletRequest request);
}
