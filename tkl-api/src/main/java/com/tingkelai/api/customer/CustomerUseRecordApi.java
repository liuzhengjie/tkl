package com.tingkelai.api.customer;

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
 * 机器使用情况相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "customer", description = "机器使用情况相关api", tags = "customer/use-record")
@RequestMapping(value = "/v1")
public interface CustomerUseRecordApi<VO> {

    @ApiOperation(value = "机器使用情况列表list", nickname = "useRecordListGet", notes = "获取机器使用列表", tags={ "customer/use-record", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "teamId", value = "公司id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/customer/use-record/list",
            method = RequestMethod.GET)
    ResponseMessage useRecordListGet(VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取机器使用情况", nickname = "useRecordGet", notes = "根据id获取机器使用情况", tags={ "customer/use-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "使用情况id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/customer/use-record",
            method = RequestMethod.GET)
    ResponseMessage useRecordGet(VO vo);


    @ApiOperation(value = "添加使用情况", nickname = "useRecordPost", notes = "添加使用情况", tags={ "customer/use-record", })
    @RequestMapping(value = "/customer/use-record",
            method = RequestMethod.POST)
    ResponseMessage useRecordPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改使用情况", nickname = "useRecordPut", notes = "修改使用情况", tags={ "customer/use-record", })
    @RequestMapping(value = "/customer/use-record",
            method = RequestMethod.PUT)
    ResponseMessage useRecordPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除使用情况", nickname = "useRecordDelete", notes = "删除使用情况", tags={ "customer/use-record", })
    @RequestMapping(value = "/customer/use-record",
            method = RequestMethod.DELETE)
    ResponseMessage useRecordDelete(VO vo);
}

