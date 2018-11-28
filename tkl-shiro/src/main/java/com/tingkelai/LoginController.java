package com.tingkelai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录相关controller
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:09:49
 * @version 1.0
 */
//@Controller
public class LoginController {

    @RequestMapping("/")
    public String index(){
        return "redirect:/swagger-ui.html";
    }
}
