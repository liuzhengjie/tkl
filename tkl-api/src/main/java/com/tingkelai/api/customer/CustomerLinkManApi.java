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
 * 客户联系人相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "客户联系人相关api", tags = "customer/linkman")
@RequestMapping(value = "/v1")
public interface CustomerLinkManApi<T> {

    @ApiOperation(value = "删除客户联系人", nickname = "customerLinkmanDelete", notes = "", tags={ "customer/linkman", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/linkman",
            method = RequestMethod.DELETE)
    ResponseMessage customerLinkmanDelete(T requestBody);


    @ApiOperation(value = "获取客户联系人信息", nickname = "customerLinkmanGet", notes = "", tags={ "customer/linkman", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/customer/linkman",
            method = RequestMethod.GET)
    ResponseMessage customerLinkmanGet(T requestBody);


    @ApiOperation(value = "获取指定客户的联系人列表", nickname = "customerLinkmanListGet", notes = "", tags={ "customer/linkman", })
    @RequestMapping(value = "/customer/linkman/list",
            method = RequestMethod.GET)
    ResponseMessage customerLinkmanListGet(T requestBody, BasePage basePage);


    @ApiOperation(value = "添加客户联系人", nickname = "customerLinkmanPost", notes = "", tags={ "customer/linkman", })
    @RequestMapping(value = "/customer/linkman",
            method = RequestMethod.POST)
    ResponseMessage customerLinkmanPost(@Valid @RequestBody T requestBody);


    @ApiOperation(value = "修改客户联系人", nickname = "customerLinkmanPut", notes = "", tags={ "customer/linkman", })
    @RequestMapping(value = "/customer/linkman",
            method = RequestMethod.PUT)
    ResponseMessage customerLinkmanPut(@Valid @RequestBody T requestBody);
}
