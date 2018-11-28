package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户预约计划相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户预约计划相关api")
public interface CustomerSubscribePlanApi<T> {

    @ApiOperation(value = "删除客户预约计划", nickname = "customerSubscribePlanDelete", notes = "", tags={ "customer/subscribe-plan", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerSubscribePlanDelete(T requestBody);


    @ApiOperation(value = "获取客户预约计划", nickname = "customerSubscribePlanGet", notes = "", tags={ "customer/subscribe-plan", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerSubscribePlanGet(T requestBody);


    @ApiOperation(value = "获取客户预约计划列表", nickname = "customerSubscribePlanListGet", notes = "", tags={ "customer/subscribe-plan", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/subscribe-plan/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerSubscribePlanListGet(T requestBody);


    @ApiOperation(value = "添加客户预约计划", nickname = "customerSubscribePlanPost", notes = "", tags={ "customer/subscribe-plan", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerSubscribePlanPost(T requestBody);


    @ApiOperation(value = "修改客户预约计划", nickname = "customerSubscribePlanPut", notes = "", tags={ "customer/subscribe-plan", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerSubscribePlanPut(T requestBody);
}
