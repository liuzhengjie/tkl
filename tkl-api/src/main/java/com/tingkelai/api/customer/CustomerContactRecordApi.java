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
 * 客户联系记录相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户联系记录相关api", tags = "customer/contact-record")
@RequestMapping(value = "/v1")
public interface CustomerContactRecordApi<T> {
    @ApiOperation(value = "删除客户联系记录", nickname = "customerContactRecordDelete", notes = "", tags={ "customer/contact-record", })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.DELETE)
    ResponseMessage customerContactRecordDelete(T requestBody);


    @ApiOperation(value = "获取客户联系记录信息", nickname = "customerContactRecordGet", notes = "", tags={ "customer/contact-record", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.GET)
    ResponseMessage customerContactRecordGet(T requestBody);


    @ApiOperation(value = "获取客户联系记录列表", nickname = "customerContactRecordListGet", notes = "必须有客户id，如果没有就会返回错误信息", tags={ "customer/contact-record", })
    @RequestMapping(value = "/customer/contact-record/list",
            method = RequestMethod.GET)
    ResponseMessage customerContactRecordListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加客户联系记录", nickname = "customerContactRecordPost", notes = "", tags={ "customer/contact-record", })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.POST)
    ResponseMessage customerContactRecordPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户联系记录", nickname = "customerContactRecordPut", notes = "", tags={ "customer/contact-record", })
    @RequestMapping(value = "/customer/contact-record",
            method = RequestMethod.PUT)
    ResponseMessage customerContactRecordPut(@Valid @RequestBody T requestBody);
}
