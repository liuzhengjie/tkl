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

    public final static int STATUS = 500001;

    public final static String REASON = "token失效";

    public TokenFailureException(){
        setCode(STATUS);
        setMessage(REASON);
    }

    public TokenFailureException(String message){
        super(message);
        setCode(STATUS);
    }
}
