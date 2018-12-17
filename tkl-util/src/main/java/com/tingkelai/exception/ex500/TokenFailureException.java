package com.tingkelai.exception.ex500;

import com.tingkelai.exception.BaseException;

/**
 * token失效 500001
 *
 * 2018-12-6 14:28:53
 * @author liuzhengjie
 * @version 1.0
 */
public class TokenFailureException extends BaseException {

    public TokenFailureException(){
        setCode(500001);
        setMessage("token失效");
    }

    public TokenFailureException(String message){
        super("token失效");
        setCode(500001);
    }
}
