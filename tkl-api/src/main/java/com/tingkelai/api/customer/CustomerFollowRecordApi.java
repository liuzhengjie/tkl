package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户跟进记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户跟进记录相关api", tags = "customer/follow-record")
@RequestMapping(value = "/v1")
public interface CustomerFollowRecordApi<T> {

    @ApiOperation(value = "删除客户跟进记录", nickname = "customerFollowRecordDelete", notes = "", tags={ "customer/follow-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/follow-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerFollowRecordDelete(@RequestBody T requestBody);


    @ApiOperation(value = "获取客户跟进记录", nickname = "customerFollowRecordGet", notes = "", tags={ "customer/follow-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/follow-record",
            method = RequestMethod.GET)
    ResponseMessage customerFollowRecordGet(T requestBody);


    @ApiOperation(value = "获取客户跟进记录列表", nickname = "customerFollowRecordListGet", notes = "", tags={ "customer/follow-record", })
    @RequestMapping(value = "/customer/follow-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerFollowRecordListGet(T requestBody);


    @ApiOperation(value = "添加客户跟进记录", nickname = "customerFollowRecordPost", notes = "", tags={ "customer/follow-record", })
    @RequestMapping(value = "/customer/follow-record",
            method = RequestMethod.POST)
    ResponseMessage customerFollowRecordPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户跟进记录", nickname = "customerFollowRecordPut", notes = "", tags={ "customer/follow-record", })
    @RequestMapping(value = "/customer/follow-record",
            method = RequestMethod.PUT)
    ResponseMessage customerFollowRecordPut(@Valid @RequestBody T requestBody);
}
