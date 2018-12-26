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
 * 发送短信记录相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "smsSendLog", description = "短信记录相关api", tags = "smsSendLog")
@RequestMapping(value = "/v1")
public interface SmsSendLogApi<VO> {

    @ApiOperation(value = "短信记录列表list", nickname = "smsSendLogListGet", notes = "获取短信记录列表", tags={ "smsSendLog", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数", required = false, paramType = "query"),
    })
    @RequestMapping(value = "/smsSendLog/list",
            method = RequestMethod.POST)
    ResponseMessage smsSendLogListGet(@RequestBody VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取短信记录信息", nickname = "smsSendLogGet", notes = "根据id获取短信记录信息", tags={ "smsSendLog", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "短信记录id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/smsSendLog",
            method = RequestMethod.GET)
    ResponseMessage smsSendLogGet(VO vo);


    @ApiOperation(value = "添加短信记录", nickname = "smsSendLogPost", notes = "添加短信记录", tags={ "smsSendLog", })
    @RequestMapping(value = "/smsSendLog",
            method = RequestMethod.POST)
    ResponseMessage smsSendLogPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改短信记录", nickname = "smsSendLogPut", notes = "修改短信记录", tags={ "smsSendLog", })
    @RequestMapping(value = "/smsSendLog",
            method = RequestMethod.PUT)
    ResponseMessage smsSendLogPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除短信记录", nickname = "smsSendLogDelete", notes = "删除短信记录", tags={ "smsSendLog", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "短信记录id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/smsSendLog",
            method = RequestMethod.DELETE)
    ResponseMessage smsSendLogDelete(VO vo);
}

