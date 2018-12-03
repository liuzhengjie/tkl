package com.tingkelai.sys.controller;

import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.api.sys.SysApi;
import com.tingkelai.domain.sys.User;
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
    public ResponseMessage<User> sysLoginPost(HttpServletRequest request, User body) {
        return null;
    }

    @Override
    public ResponseMessage<User> sysLogoutGet(HttpServletRequest request, User body) {
        return null;
    }

    @Override
    public ResponseMessage<User> sysRegisterPost(HttpServletRequest request, User body) {
        return null;
    }
}
