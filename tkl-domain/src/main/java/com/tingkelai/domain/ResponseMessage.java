package com.tingkelai.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlTransient;

/**
 * 设置统一返回值
 *
 * @author liuzhengjie
 * @date 2018-11-28 10:29:52
 * @version 1.0
 */
public class ResponseMessage<T> {
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;
    public static final int OK = 4;
    public static final int TOO_BUSY = 5;

    public static final String ERROR_MSG = "error";
    public static final String WARNING_MSG = "warning";
    public static final String INFO_MSG = "info";
    public static final String OK_MSG = "ok";
    public static final String TOO_BUSY_MSG = "too busy";

    private int code = 1;
    private String type = "error";
    private String message = "系统内部bug";
    private T data;

    public ResponseMessage(){}

    public ResponseMessage(Exception e){
    }

    public ResponseMessage(T data){
        this.setCode(4);
        this.setType("ok");
        this.setMessage("正常数据");
        this.setData(data);
    }

    public ResponseMessage(int code, String message, T data){
        this(code, message);
        this.setData(data);
    }

    public ResponseMessage(int code, String message){
        this();
        this.code = code;
        switch(code){
            case ERROR:
                setType("error");
                break;
            case WARNING:
                setType("warning");
                break;
            case INFO:
                setType("info");
                break;
            case OK:
                setType("ok");
                break;
            case TOO_BUSY:
                setType("too busy");
                break;
            default:
                setType("unknown");
                break;
        }
        this.message = message;
    }

    @ApiModelProperty(value = "返回数据")
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @ApiModelProperty(value = "提示码")
    @XmlTransient
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @ApiModelProperty(value = "提示类型")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ApiModelProperty(value = "提示信息")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void success(String msg) {
        this.code = OK;
        this.message = msg;
        this.type = "ok";
    }

    public void fail(String msg) {
        this.code = ERROR;
        this.message = msg;
        this.type = ERROR_MSG;
    }
}
