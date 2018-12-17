package com.tingkelai.api.template;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 动态模板字段相关api
 *
 * @author liuzhengjie
 * @date 2018-12-17 10:16:41
 * @version 1.0
 */
@Api(value = "template/field", description = "动态模板字段相关api")
public interface TemplateFieldApi<VO> {

    @ApiOperation(value = "获取指定动态模板的所有字段list", nickname = "templateFieldListGet", notes = "获取指定动态模板的所有字段list", tags={ "template", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "templateId", value = "动态模板id", required = true),
    })
    @RequestMapping(value = "/template/field/list",
            method = RequestMethod.GET)
    ResponseMessage templateFieldListGet(VO vo);


    @ApiOperation(value = "获取动态模板字段", nickname = "templateFieldGet", notes = "获取动态模板字段", tags={ "template", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "动态模板字段id", required = true),
    })
    @RequestMapping(value = "/template/field",
            method = RequestMethod.GET)
    ResponseMessage templateFieldGet(VO vo);


    @ApiOperation(value = "创建公司动态模板", nickname = "templateFieldPost", notes = "创建公司动态模板", tags={ "template", })
    @RequestMapping(value = "/template/field",
            method = RequestMethod.POST)
    ResponseMessage templateFieldPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "更新公司动态模板", nickname = "templateFieldPut", notes = "更新公司动态模板", tags={ "template", })
    @RequestMapping(value = "/template/field",
            method = RequestMethod.PUT)
    ResponseMessage templateFieldPut(@Valid @RequestBody VO vo);


    @ApiOperation(value = "删除公司动态模板", nickname = "templateFieldDelete", notes = "删除公司动态模板", tags={ "template", })
    @RequestMapping(value = "/template/field",
            method = RequestMethod.DELETE)
    ResponseMessage templateFieldDelete(@Valid @RequestBody VO vo);
}

