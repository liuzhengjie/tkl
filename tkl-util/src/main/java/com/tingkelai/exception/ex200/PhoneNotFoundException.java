package com.tingkelai.exception.ex200;

import com.tingkelai.exception.BaseException;

/**
 * 手机号不存在错误 200003
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class PhoneNotFoundException extends BaseException {

    public final static int STATUS = 200003;

    public final static String REASON = "该手机号不存在，请先注册！";

    public PhoneNotFoundException(){
        setCode(STATUS);
        setMessage(REASON);
    }

    public PhoneNotFoundException(String message){
        super(message);
        setCode(STATUS);
    }
}
