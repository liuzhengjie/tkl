package com.tingkelai.exception.ex300;

import com.tingkelai.exception.BaseException;

/**
 * 账号或密码错误
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class AccountPasswordException extends BaseException {

    public final static int STATUS = 300001;

    public final static String REASON = "账号或密码错误";

    public AccountPasswordException(){
        setCode(STATUS);
        setMessage(REASON);
    }

    public AccountPasswordException(String message){
        super(message);
        setCode(STATUS);
    }
}
