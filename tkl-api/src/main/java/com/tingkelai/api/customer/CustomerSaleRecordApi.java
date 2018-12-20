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
 * 客户销售记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户销售记录相关api", tags = "customer/sale-record")
@RequestMapping(value = "/v1")
public interface CustomerSaleRecordApi<T> {

    @ApiOperation(value = "删除销售记录", nickname = "customerSaleRecordDelete", notes = "", tags={ "customer/sale-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerSaleRecordDelete(T requestBody);


    @ApiOperation(value = "获取销售记录", nickname = "customerSaleRecordGet", notes = "", tags={ "customer/sale-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.GET)
    ResponseMessage customerSaleRecordGet(T requestBody);


    @ApiOperation(value = "获取销售记录列表", nickname = "customerSaleRecordListGet", notes = "", tags={ "customer/sale-record", })
    @RequestMapping(value = "/customer/sale-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerSaleRecordListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加销售记录", nickname = "customerSaleRecordPost", notes = "", tags={ "customer/sale-record", })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.POST)
    ResponseMessage customerSaleRecordPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改销售记录", nickname = "customerSaleRecordPut", notes = "", tags={ "customer/sale-record", })
    @RequestMapping(value = "/customer/sale-record",
            method = RequestMethod.PUT)
    ResponseMessage customerSaleRecordPut(@Valid @RequestBody T requestBody);
}
