package com.tingkelai.api.user;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public interface UserApi{

    @ApiOperation(value = "获取用户信息", nickname = "userGet", notes = "获取用户信息", tags={ "user", })
    @RequestMapping(value = "/user",
            method = RequestMethod.GET)
    ResponseMessage userGet();

    @ApiOperation(value = "获取用户能看到的门店信息", nickname = "shopGet", notes = "获取用户能看到的门店信息", tags={ "user", })
    @RequestMapping(value = "/user/shop",
            method = RequestMethod.GET)
    ResponseMessage shopGet();
}

