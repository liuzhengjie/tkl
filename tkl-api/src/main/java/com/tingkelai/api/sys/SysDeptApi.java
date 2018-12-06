package com.tingkelai.api.sys;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
@RequestMapping(value = "/v1")
public interface SysDeptApi<VO> {
    @ApiOperation(value = "删除部门", nickname = "sysDeptDelete", notes = "", tags={ "sys/dept", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.DELETE)
    ResponseMessage sysDeptDelete(VO vo);


    @ApiOperation(value = "获取部门信息", nickname = "sysDeptGet", notes = "", tags={ "sys/dept", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.GET)
    ResponseMessage sysDeptGet(VO vo);


    @ApiOperation(value = "获取部门列表（树形结构）", nickname = "sysDeptListGet", notes = "", tags={ "sys/dept", })
    @RequestMapping(value = "/sys/dept/list",
            method = RequestMethod.GET)
    ResponseMessage sysDeptListGet(VO vo);


    @ApiOperation(value = "创建部门", nickname = "sysDeptPost", notes = "", tags={ "sys/dept", })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.POST)
    ResponseMessage sysDeptPost(@Valid @RequestBody VO vo);


    @ApiOperation(value = "修改部门信息", nickname = "sysDeptPut", notes = "", tags={ "sys/dept", })
    @RequestMapping(value = "/sys/dept",
            method = RequestMethod.PUT)
    ResponseMessage sysDeptPut(@Valid @RequestBody VO vo);
}

