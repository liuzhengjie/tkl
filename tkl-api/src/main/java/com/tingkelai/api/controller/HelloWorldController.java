package com.tingkelai.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "redirect:/swagger-ui.html";
    }
}
