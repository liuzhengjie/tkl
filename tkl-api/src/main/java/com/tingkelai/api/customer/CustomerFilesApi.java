package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 客户文件资料相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户文件资料相关api", tags = "customer/files")
@RequestMapping(value = "/v1")
public interface CustomerFilesApi<T> {
    @ApiOperation(value = "删除客户文件资料", nickname = "customerFilesDelete", notes = "", tags={ "customer/files", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.DELETE)
    ResponseMessage customerFilesDelete(T requestBody);


    @ApiOperation(value = "获取客户文件资料", nickname = "customerFilesGet", notes = "", tags={ "customer/files", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.GET)
    ResponseMessage customerFilesGet(T requestBody);


    @ApiOperation(value = "获取客户文件资料列表", nickname = "customerFilesListGet", notes = "", tags={ "customer/files", })
    @RequestMapping(value = "/customer/files/list",
            method = RequestMethod.GET)
    ResponseMessage customerFilesListGet(T requestBody);


    @ApiOperation(value = "添加客户文件资料", nickname = "customerFilesPost", notes = "", tags={ "customer/files", })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.POST)
    ResponseMessage customerFilesPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户文件资料", nickname = "customerFilesPut", notes = "", tags={ "customer/files", })
    @RequestMapping(value = "/customer/files",
            method = RequestMethod.PUT)
    ResponseMessage customerFilesPut(@Valid @RequestBody T requestBody);
}
