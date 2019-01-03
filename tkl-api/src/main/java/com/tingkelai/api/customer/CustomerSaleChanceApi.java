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
 * 客户销售机会相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户销售机会相关api", tags = "customer/sale-chance")
@RequestMapping(value = "/v1")
public interface CustomerSaleChanceApi<T> {

    @ApiOperation(value = "删除销售机会", nickname = "customerSaleChanceDelete", notes = "", tags={ "customer/sale-chance", })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.DELETE)
    ResponseMessage customerSaleChanceDelete(T requestBody);


    @ApiOperation(value = "获取销售机会", nickname = "customerSaleChanceGet", notes = "", tags={ "customer/sale-chance", })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.GET)
    ResponseMessage customerSaleChanceGet(T requestBody);


    @ApiOperation(value = "获取客户销售机会列表", nickname = "customerSaleChanceListGet", notes = "", tags={ "customer/sale-chance", })
    @RequestMapping(value = "/customer/sale-chance/list",
            method = RequestMethod.GET)
    ResponseMessage customerSaleChanceListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加销售机会", nickname = "customerSaleChancePost", notes = "", tags={ "customer/sale-chance", })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.POST)
    ResponseMessage customerSaleChancePost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改销售机会", nickname = "customerSaleChancePut", notes = "", tags={ "customer/sale-chance", })
    @RequestMapping(value = "/customer/sale-chance",
            method = RequestMethod.PUT)
    ResponseMessage customerSaleChancePut(@Valid @RequestBody T requestBody);
}
