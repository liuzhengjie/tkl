package com.tingkelai.domain;

import com.tingkelai.exception.BaseException;
import com.tingkelai.exception.ex500.TokenFailureException;
import io.swagger.annotations.ApiModelProperty;
import org.apache.shiro.authz.UnauthorizedException;

import javax.xml.bind.annotation.XmlTransient;
import java.util.HashMap;
import java.util.Map;

/**
 * 设置统一返回值
 *
 * @author liuzhengjie
 * @date 2018-11-28 10:29:52
 * @version 1.0
 */
public class ResponseMessage<T> {

    private int code = 200;
    private String type = "ok";
    private String message = "请求成功";
    private T data;
    private Map<String, Object> ext = new HashMap<>();

    public ResponseMessage(){}

    public ResponseMessage(Exception e){
        e.printStackTrace();
        if(e instanceof BaseException){
            BaseException baseException = (BaseException) e;
            this.code = baseException.getCode();
            this.type = baseException.getType();
            this.message = baseException.getMessage();
        }else if(e instanceof UnauthorizedException){
            this.code = 401;
            this.message = "无权限";
            this.type = "error";
        }else{
            this.code = 500;
            this.message = "系统异常";
            this.type = "error";
        }
    }

    public ResponseMessage(T data){
        this.setCode(200);
        this.setType("ok");
        this.setMessage("正常数据");
        this.setData(data);
    }

    public ResponseMessage(int code, String message, T data){
        this.setData(data);
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

    @ApiModelProperty(value = "扩展信息")
    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public void success(String msg) {
        this.message = msg;
    }

    public void fail(String msg) {
        this.message = msg;
        this.code = 500;
        this.type = "error";
    }

}
