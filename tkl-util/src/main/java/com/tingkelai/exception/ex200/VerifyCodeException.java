package com.tingkelai.exception.ex200;

import com.tingkelai.exception.BaseException;

/**
 * 手机验证码错误 200002
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class VerifyCodeException extends BaseException {

    public final static int STATUS = 200002;

    public final static String REASON = "手机验证码错误！";

    public VerifyCodeException(){
        setCode(STATUS);
        setMessage(REASON);
    }

    public VerifyCodeException(String message){
        super(message);
        setCode(STATUS);
    }
}
