package com.tingkelai.api.customer;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.domain.customer.SaleChance;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 客户销售机会相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户销售机会相关api")
public interface CustomerSaleChanceApi<T> {

    @ApiOperation(value = "删除销售机会", nickname = "customerSaleChanceDelete", notes = "", tags={ "customer/sale-chance", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.DELETE)
    ApiResponseMessage<T> customerSaleChanceDelete(T requestBody);


    @ApiOperation(value = "获取销售机会", nickname = "customerSaleChanceGet", notes = "", tags={ "customer/sale-chance", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.GET)
    ApiResponseMessage<T> customerSaleChanceGet(T requestBody);


    @ApiOperation(value = "获取客户销售机会列表", nickname = "customerSaleChanceListGet", notes = "", tags={ "customer/sale-chance", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-chance/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> customerSaleChanceListGet(T requestBody);


    @ApiOperation(value = "添加销售机会", nickname = "customerSaleChancePost", notes = "", tags={ "customer/sale-chance", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.POST)
    ApiResponseMessage<T> customerSaleChancePost(T requestBody);


    @ApiOperation(value = "修改销售机会", nickname = "customerSaleChancePut", notes = "", tags={ "customer/sale-chance", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.PUT)
    ApiResponseMessage<T> customerSaleChancePut(T requestBody);
}
