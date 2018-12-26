package com.tingkelai.api.user;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户信息相关api
 * 2018-11-27 11:41:26
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "user", description = "用户相关api", tags = "user")
@RequestMapping(value = "/v1")
public interface UserApi<VO> {

    @ApiOperation(value = "获取用户信息（通过id或phone）", nickname = "userGet", notes = "获取用户信息", tags={ "user", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @RequestMapping(value = "/user/id-info",
            method = RequestMethod.GET)
    ResponseMessage userGetById();

    @ApiOperation(value = "获取用户信息（通过id或phone）", nickname = "userGet", notes = "获取用户信息", tags={ "user", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "phone", required = true),
    })
    @RequestMapping(value = "/user/phone-info",
            method = RequestMethod.GET)
    ResponseMessage userGetByPhone();
}

