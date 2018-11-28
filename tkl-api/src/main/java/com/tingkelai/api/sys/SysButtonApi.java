package com.tingkelai.api.sys;

import com.tingkelai.api.ApiResponseMessage;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
public interface SysButtonApi<T> {

    @ApiOperation(value = "获取按钮列表（指定菜单下的按钮列表）", nickname = "sysButtonListGet", notes = "通过菜单id，获取该菜单下所有的按钮", tags={ "sys/button", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/button/list",
            method = RequestMethod.GET)
    ApiResponseMessage<List<T>> sysButtonListGet(HttpServletRequest request, T body);
}

