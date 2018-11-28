package com.tingkelai.api;

/**
 * 统一异常处理类
 *
 * @author liuzhengjie
 * @date 2018-11-28 09:52:49
 * @version 1.0
 */
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
