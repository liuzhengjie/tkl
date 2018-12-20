package com.tingkelai.api.template;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
@Api(value = "template", description = "动态模板相关api", tags = "template")
@RequestMapping(value = "/v1")
public interface TemplateApi<VO> {

    @ApiOperation(value = "获取指定公司动态模板list", nickname = "templateListGet", notes = "获取指定公司动态模板列表", tags={ "template", })
    @ApiImplicitParams({
//            @ApiImplicitParam(name = "teamId", value = "公司id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/template/list",
            method = RequestMethod.GET)
    ResponseMessage templateListGet(VO vo, BasePage basePage);

    @ApiOperation(value = "根据id获取动态模板", nickname = "templateGet", notes = "根据id获取动态模板", tags={ "template", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态模板id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/template",
            method = RequestMethod.GET)
    ResponseMessage templateGet(VO vo);


    @ApiOperation(value = "创建公司动态模板", nickname = "templatePost", notes = "创建公司动态模板", tags={ "template", })
    @RequestMapping(value = "/template",
            method = RequestMethod.POST)
    ResponseMessage templatePost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "更新公司动态模板", nickname = "templatePut", notes = "更新公司动态模板", tags={ "template", })
    @RequestMapping(value = "/template",
            method = RequestMethod.PUT)
    ResponseMessage templatePut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除公司动态模板", nickname = "templateDelete", notes = "删除公司动态模板", tags={ "template", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态模板id", required = true, paramType = "query"),
    })
    @RequestMapping(value = "/template",
            method = RequestMethod.DELETE)
    ResponseMessage templateDelete(VO vo);
}

