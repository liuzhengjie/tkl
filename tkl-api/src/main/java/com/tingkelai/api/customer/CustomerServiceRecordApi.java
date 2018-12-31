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
 * 客户服务记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户服务记录相关api", tags = "customer/service-record")
@RequestMapping(value = "/v1")
public interface CustomerServiceRecordApi<T> {

    @ApiOperation(value = "删除客户服务记录", nickname = "customerServiceRecordDelete", notes = "", tags={ "customer/service-record", })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerServiceRecordDelete(T requestBody);


    @ApiOperation(value = "获取客户服务记录", nickname = "customerServiceRecordGet", notes = "", tags={ "customer/service-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.GET)
    ResponseMessage customerServiceRecordGet(T requestBody);


    @ApiOperation(value = "获取客户服务记录列表", nickname = "customerServiceRecordListGet", notes = "", tags={ "customer/service-record", })
    @RequestMapping(value = "/customer/service-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerServiceRecordListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加客户服务记录", nickname = "customerServiceRecordPost", notes = "", tags={ "customer/service-record", })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.POST)
    ResponseMessage customerServiceRecordPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户服务记录", nickname = "customerServiceRecordPut", notes = "", tags={ "customer/service-record", })
    @RequestMapping(value = "/customer/service-record",
            method = RequestMethod.PUT)
    ResponseMessage customerServiceRecordPut(@Valid @RequestBody T requestBody);
}
