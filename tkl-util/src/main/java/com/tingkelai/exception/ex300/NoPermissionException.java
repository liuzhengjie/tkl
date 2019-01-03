package com.tingkelai.exception.ex300;

import com.tingkelai.exception.BaseException;

/**
 * 无权限查看
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class NoPermissionException extends BaseException {

    public final static int STATUS = 300002;

    public final static String REASON = "无操作权限";

    public NoPermissionException(){
        setCode(STATUS);
        setMessage(REASON);
    }

    public NoPermissionException(String message){
        super(message);
        setCode(STATUS);
    }
}
