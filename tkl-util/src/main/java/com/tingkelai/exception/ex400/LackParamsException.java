package com.tingkelai.exception.ex400;

import com.tingkelai.exception.BaseException;

/**
 * 缺少参数 400001
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class LackParamsException extends BaseException {

    public LackParamsException(){
        setCode(400001);
        setMessage("====缺少参数");
    }

    public LackParamsException(String message){
        super(message);
        setCode(400001);
    }
}
