package com.tingkelai.api.dict;

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
 * 数据字典分组相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "dict/item", description = "数据字典项相关api", tags = "dict")
@RequestMapping(value = "/v1")
public interface DictItemApi<VO> {

    @ApiOperation(value = "获取数据字典项列表", nickname = "dictItemListGet", notes = "获取数据字典项列表,dictGroupId和dictGroupCode至少要有一个", tags={ "dict", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "teamId", value = "公司id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/item/list",
            method = RequestMethod.GET)
    ResponseMessage dictItemListGet(VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取数据字典项信息", nickname = "dictItemGet", notes = "根据id获取数据字典项信息", tags={ "dict", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "字典项id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/item",
            method = RequestMethod.GET)
    ResponseMessage dictItemGet(VO vo);


    @ApiOperation(value = "添加数据字典项", nickname = "dictItemPost", notes = "添加数据字典项", tags={ "dict", })
    @RequestMapping(value = "/dict/item",
            method = RequestMethod.POST)
    ResponseMessage dictItemPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改数据字典项信息", nickname = "dictItemPut", notes = "修改数据字典项信息", tags={ "dict", })
    @RequestMapping(value = "/dict/item",
            method = RequestMethod.PUT)
    ResponseMessage dictItemPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除数据字典项信息", nickname = "dictItemDelete", notes = "删除数据字典项信息", tags={ "dict", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "分组id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/item",
            method = RequestMethod.DELETE)
    ResponseMessage dictItemDelete(VO vo);
}

