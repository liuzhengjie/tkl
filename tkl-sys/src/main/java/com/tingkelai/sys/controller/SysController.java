package com.tingkelai.sys.controller;

import com.tingkelai.api.ApiResponseMessage;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysApi;
import com.tingkelai.domain.sys.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统登录注销相关
 *
 * @author liuzhengjie
 * @date 2018-11-28 17:36:47
 * @version 1.0
 */
@RestController
public class SysController implements SysApi<User> {

    @Override
    public ApiResponseMessage<User> sysLoginPost(HttpServletRequest request, User body) {
        return null;
    }

    @Override
    public ApiResponseMessage<User> sysLogoutGet(HttpServletRequest request, User body) {
        return null;
    }

    @Override
    public ApiResponseMessage<User> sysRegisterPost(HttpServletRequest request, User body) {
        return null;
    }
}
