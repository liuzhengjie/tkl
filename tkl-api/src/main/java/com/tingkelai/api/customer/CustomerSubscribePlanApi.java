package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.BasePage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户预约计划相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户预约计划相关api", tags = "customer/subscribe-plan")
@RequestMapping(value = "/v1")
public interface CustomerSubscribePlanApi<T> {

    @ApiOperation(value = "删除客户预约计划", nickname = "customerSubscribePlanDelete", notes = "", tags={ "customer/subscribe-plan", })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.DELETE)
    ResponseMessage customerSubscribePlanDelete(T requestBody);


    @ApiOperation(value = "获取客户预约计划", nickname = "customerSubscribePlanGet", notes = "", tags={ "customer/subscribe-plan", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.GET)
    ResponseMessage customerSubscribePlanGet(T requestBody);


    @ApiOperation(value = "获取客户预约计划列表", nickname = "customerSubscribePlanListGet", notes = "", tags={ "customer/subscribe-plan", })
    @RequestMapping(value = "/customer/subscribe-plan/list",
            method = RequestMethod.GET)
    ResponseMessage customerSubscribePlanListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加客户预约计划", nickname = "customerSubscribePlanPost", notes = "", tags={ "customer/subscribe-plan", })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.POST)
    ResponseMessage customerSubscribePlanPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户预约计划", nickname = "customerSubscribePlanPut", notes = "", tags={ "customer/subscribe-plan", })
    @RequestMapping(value = "/customer/subscribe-plan",
            method = RequestMethod.PUT)
    ResponseMessage customerSubscribePlanPut(@Valid @RequestBody T requestBody);
}
