package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户销售产品相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户销售产品相关api")
@RequestMapping(value = "/v1")
public interface CustomerSaleProductRecordApi<T> {

    @ApiOperation(value = "删除销售产品记录", nickname = "customerSaleProductRecordDelete", notes = "", tags={ "customer/sale-product-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/sale-product-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerSaleProductRecordDelete(T requestBody);


    @ApiOperation(value = "获取销售产品记录", nickname = "customerSaleProductRecordGet", notes = "", tags={ "customer/sale-product-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/sale-product-record",
            method = RequestMethod.GET)
    ResponseMessage customerSaleProductRecordGet(T requestBody);


    @ApiOperation(value = "获取销售产品记录列表", nickname = "customerSaleProductRecordListGet", notes = "", tags={ "customer/sale-product-record", })
    @RequestMapping(value = "/customer/sale-product-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerSaleProductRecordListGet(T requestBody);


    @ApiOperation(value = "添加销售产品记录", nickname = "customerSaleProductRecordPost", notes = "", tags={ "customer/sale-product-record", })
    @RequestMapping(value = "/customer/sale-product-record",
            method = RequestMethod.POST)
    ResponseMessage customerSaleProductRecordPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改销售产品记录", nickname = "customerSaleProductRecordPut", notes = "", tags={ "customer/sale-product-record", })
    @RequestMapping(value = "/customer/sale-product-record",
            method = RequestMethod.PUT)
    ResponseMessage customerSaleProductRecordPut(@Valid @RequestBody T requestBody);
}
