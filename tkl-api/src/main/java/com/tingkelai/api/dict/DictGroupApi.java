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
@Api(value = "dict/group", description = "数据字典分组相关api", tags = "dict")
@RequestMapping(value = "/v1")
public interface DictGroupApi<VO> {

    @ApiOperation(value = "获取数据字典分组列表", nickname = "dictGroupListGet", notes = "获取数据字典分组列表", tags={ "dict", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "teamId", value = "公司id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/group/list",
            method = RequestMethod.GET)
    ResponseMessage dictGroupListGet(VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取数据字典分组信息", nickname = "dictGroupGet", notes = "根据id获取数据字典分组信息", tags={ "dict", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "code", value = "分组id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/group",
            method = RequestMethod.GET)
    ResponseMessage dictGroupGet(VO vo);


    @ApiOperation(value = "添加数据字典分组", nickname = "dictGroupPost", notes = "添加数据字典分组", tags={ "dict", })
    @RequestMapping(value = "/dict/group",
            method = RequestMethod.POST)
    ResponseMessage dictGroupPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改数据字典分组信息", nickname = "dictGroupPut", notes = "修改数据字典分组信息", tags={ "dict", })
    @RequestMapping(value = "/dict/group",
            method = RequestMethod.PUT)
    ResponseMessage dictGroupPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除数据字典分组信息", nickname = "dictGroupDelete", notes = "删除数据字典分组信息", tags={ "dict", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "分组id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/dict/group",
            method = RequestMethod.DELETE)
    ResponseMessage dictGroupDelete(VO vo);
}

