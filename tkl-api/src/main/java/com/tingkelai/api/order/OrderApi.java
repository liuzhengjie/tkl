package com.tingkelai.api.order;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.order.OrderVO;
import com.tingkelai.vo.order.SaleOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 客户销售记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "order", description = "订单（账单）相关api", tags = "order")
@RequestMapping(value = "/v1")
public interface OrderApi<T> {

    @ApiOperation(value = "删除订单（账单）", nickname = "orderDelete", notes = "", tags={ "order", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/order",
            method = RequestMethod.DELETE)
    ResponseMessage orderDelete(T requestBody);


    @ApiOperation(value = "获取订单（账单）", nickname = "orderGet", notes = "", tags={ "order", })
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "id", required = true),
//    })
    @RequestMapping(value = "/order",
            method = RequestMethod.GET)
    ResponseMessage orderGet(T requestBody);


    @ApiOperation(value = "获取订单（账单）列表", nickname = "orderListGet", notes = "", tags={ "order", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = false, paramType = "query"),
    })
    @RequestMapping(value = "/order/list",
            method = RequestMethod.POST)
    ResponseMessage orderListGet(@RequestBody OrderVO requestBody, BasePage basePage);


    @ApiOperation(value = "添加订单（账单）", nickname = "orderPost", notes = "", tags={ "order", })
    @RequestMapping(value = "/order",
            method = RequestMethod.POST)
    ResponseMessage orderPost(@RequestBody SaleOrderVO requestBody);


    @ApiOperation(value = "修改订单（账单）", nickname = "orderPut", notes = "", tags={ "order", })
    @RequestMapping(value = "/order",
            method = RequestMethod.PUT)
    ResponseMessage orderPut(@Valid @RequestBody SaleOrderVO requestBody);

}
