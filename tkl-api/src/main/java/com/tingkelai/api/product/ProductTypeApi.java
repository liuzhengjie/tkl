package com.tingkelai.api.product;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * 动态模板相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "product", description = "商品分类相关api", tags = "product/type")
@RequestMapping(value = "/v1")
public interface ProductTypeApi<VO> {

    @ApiOperation(value = "商品分类列表list", nickname = "productTypeListGet", notes = "获取商品分类列表", tags={ "product/type", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "teamId", value = "公司id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product/type/list",
            method = RequestMethod.GET)
    ResponseMessage productTypeListGet(VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取商品分类信息", nickname = "productTypeGet", notes = "根据id获取商品分类信息", tags={ "product/type", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product/type",
            method = RequestMethod.GET)
    ResponseMessage productTypeGet(VO vo);


    @ApiOperation(value = "添加商品分类", nickname = "productTypePost", notes = "添加商品分类", tags={ "product/type", })
    @RequestMapping(value = "/product/type",
            method = RequestMethod.POST)
    ResponseMessage productTypePost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改商品分类", nickname = "productTypePut", notes = "修改商品分类", tags={ "product/type", })
    @RequestMapping(value = "/product/type",
            method = RequestMethod.PUT)
    ResponseMessage productTypePut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除商品分类", nickname = "productTypeDelete", notes = "删除商品分类", tags={ "product/type", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品分类id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/product/type",
            method = RequestMethod.DELETE)
    ResponseMessage productTypeDelete(VO vo);

    @ApiOperation(value = "获取商品分类树形结构", nickname = "productTypeTreeGet",
            notes = "异步：1（加载当前层），同步：0（加载所有）,同步加载需要参数parentId，没有默认加载root层", tags={ "product/type", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "async", value = "异步：1（加载当前层），同步：0（加载所有）", paramType = "query"),
    })
    @RequestMapping(value = "/product/type/tree",
            method = RequestMethod.GET)
    ResponseMessage productTypeTreeGet(ProductTypeVO productTypeVO, String async);
}

