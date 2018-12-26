package com.tingkelai.api.sms;

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
 * 短信模板api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "smsTemplate", description = "短信模板相关api", tags = "smsTemplate")
@RequestMapping(value = "/v1")
public interface SmsTemplateApi<VO> {

    @ApiOperation(value = "短信模板列表list", nickname = "smsTemplateListGet", notes = "获取短信模板列表", tags={ "smsTemplate", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = false, paramType = "query"),
    })
    @RequestMapping(value = "/smsTemplate/list",
            method = RequestMethod.POST)
    ResponseMessage smsTemplateListGet(@RequestBody VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取短信模板信息", nickname = "smsTemplateGet", notes = "根据id获取短信模板信息", tags={ "smsTemplate", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "短信模板id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/smsTemplate",
            method = RequestMethod.GET)
    ResponseMessage smsTemplateGet(VO vo);


    @ApiOperation(value = "添加短信模板", nickname = "smsTemplatePost", notes = "添加短信模板", tags={ "smsTemplate", })
    @RequestMapping(value = "/smsTemplate",
            method = RequestMethod.POST)
    ResponseMessage smsTemplatePost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改短信模板", nickname = "smsTemplatePut", notes = "修改短信模板", tags={ "smsTemplate", })
    @RequestMapping(value = "/smsTemplate",
            method = RequestMethod.PUT)
    ResponseMessage smsTemplatePut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除短信模板", nickname = "smsTemplateDelete", notes = "删除短信模板", tags={ "smsTemplate", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "商品id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/smsTemplate",
            method = RequestMethod.DELETE)
    ResponseMessage smsTemplateDelete(VO vo);
}

