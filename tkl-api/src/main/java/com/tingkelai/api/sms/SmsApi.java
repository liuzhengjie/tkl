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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * 短信相关api
 *
 * 2018-12-17 11:21:40
 * @author liuzhengjie
 * @version 1.0
 */
@Api(value = "sms", description = "短信相关api", tags = "sms")
public interface SmsApi {

    @ApiOperation(value = "手机注册发送短信", nickname = "sendRegistVerifyCode", notes = "手机注册发送短信", tags={ "sms", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "body"),
    })
    @RequestMapping(value = "/sms/sendRegistVerifyCode",
            method = RequestMethod.POST)
    ResponseMessage sendRegistVerifyCode(@RequestBody String phone);

    @ApiOperation(value = "重置密码发送短信", nickname = "sendResetPwdVerifyCode", notes = "重置密码", tags={ "sms", })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "body"),
    })
    @RequestMapping(value = "/sendResetPwdVerifyCode",
            method = RequestMethod.POST)
    ResponseMessage sendResetPwdVerifyCode(@RequestBody String phone);

}

