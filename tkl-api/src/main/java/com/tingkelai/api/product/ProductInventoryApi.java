package com.tingkelai.api.product;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 商品库存（出库入库）相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "product", description = "商品库存（出库入库）相关api", tags = "product/inventory")
@RequestMapping(value = "/v1")
public interface ProductInventoryApi<VO> {

    @ApiOperation(value = "库存列表list", nickname = "productInventoryListGet", notes = "获取库存列表", tags={ "product/inventory", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = false, paramType = "query"),
    })
    @RequestMapping(value = "/product/inventory/list",
            method = RequestMethod.POST)
    ResponseMessage productInventoryListGet(@RequestBody VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取库存信息", nickname = "productInventoryGet", notes = "根据id获取库存信息", tags={ "product/inventory", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product/inventory",
            method = RequestMethod.GET)
    ResponseMessage productInventoryGet(VO vo);


    @ApiOperation(value = "添加库存", nickname = "productInventoryPost", notes = "添加库存", tags={ "product/inventory", })
    @RequestMapping(value = "/product/inventory",
            method = RequestMethod.POST)
    ResponseMessage productInventoryPost(@Valid @RequestBody ProductOrderVO vo);


    @ApiOperation(value = "修改库存", nickname = "productInventoryPut", notes = "修改库存", tags={ "product/inventory", })
    @RequestMapping(value = "/product/inventory",
            method = RequestMethod.PUT)
    ResponseMessage productInventoryPut(@Valid @RequestBody ProductOrderVO vo);


    @ApiOperation(value = "删除库存", nickname = "productInventoryDelete", notes = "删除库存", tags={ "product/inventory", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product/inventory",
            method = RequestMethod.DELETE)
    ResponseMessage productInventoryDelete(VO vo);
}

