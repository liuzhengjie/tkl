package com.tingkelai.api.customer;

import com.tingkelai.domain.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 常用设置相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:30:50
 * @version 1.0
 */
@Api(value = "customer", description = "常用设置相关api")
public interface CustomerSettingApi<T> {

    @ApiOperation(value = "获取用户设置的常用模块列表", nickname = "customerSettingListGet", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/setting/list",
            method = RequestMethod.GET)
    ResponseMessage<T> customerSettingListGet(T requestBody);


    @ApiOperation(value = "修改用户常用模块", nickname = "customerSettingPut", notes = "", tags={ "customer", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/customer/setting",
            method = RequestMethod.PUT)
    ResponseMessage<T> customerSettingPut(T requestBody);
}
