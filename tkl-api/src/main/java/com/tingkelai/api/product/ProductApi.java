package com.tingkelai.api.product;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.BasePage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 动态模板相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "product", description = "商品相关api", tags = "product")
@RequestMapping(value = "/v1")
public interface ProductApi<VO> {

    @ApiOperation(value = "商品列表list", nickname = "productListGet", notes = "获取商品列表", tags={ "product", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = false, paramType = "query"),
    })
    @RequestMapping(value = "/product/list",
            method = RequestMethod.POST)
    ResponseMessage productListGet(@RequestBody VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取商品信息", nickname = "productGet", notes = "根据id获取商品信息", tags={ "product", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product",
            method = RequestMethod.GET)
    ResponseMessage productGet(VO vo);


    @ApiOperation(value = "添加商品", nickname = "productPost", notes = "添加商品", tags={ "product", })
    @RequestMapping(value = "/product",
            method = RequestMethod.POST)
    ResponseMessage productPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改商品", nickname = "productPut", notes = "修改商品", tags={ "product", })
    @RequestMapping(value = "/product",
            method = RequestMethod.PUT)
    ResponseMessage productPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除商品", nickname = "productDelete", notes = "删除商品", tags={ "product", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product",
            method = RequestMethod.DELETE)
    ResponseMessage productDelete(VO vo);
}

