package com.tingkelai.api.user;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 部门信息相关api
 * 2018-11-27 11:41:26
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "dept", description = "部门相关api", tags = "dept")
@RequestMapping(value = "/v1")
public interface DeptApi {

    @ApiOperation(value = "获取用户能看到的所有部门（包含门店和部门）", nickname = "shopGet", notes = "获取用户能看到的部门信息（包括门店和部门）", tags={ "dept", })
    @RequestMapping(value = "/dept/list",
            method = RequestMethod.GET)
    ResponseMessage deptListGet();

    @ApiOperation(value = "获取部门所有的用户", nickname = "deptUserListGet", notes = "获取部门所有的用户", tags={ "dept", })
    @RequestMapping(value = "/dept/user/list",
            method = RequestMethod.GET)
    ResponseMessage deptUserListGet();
}

