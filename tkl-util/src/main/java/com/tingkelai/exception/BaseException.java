package com.tingkelai.exception;

/**
 * 通用异常设置
 * 说明：异常码使用六位数，如500001
 * 其中：
 * 第一位
 *      异常分类：5-》500， 4-》400， 3-》300， 2-》200
 * 第二三位：
 *          代表创建该异常的人编号，比如00代表刘争杰，01代表杰争刘，依次累加，
 *          每个人需要把自己创建的异常按自己的编号进行添加，防止出现重复。
 * 第四五六位：
 *          异常编号，从001开始，每创建一个异常就+1
 *
 *  现编号00的人第一次创建500异常，则异常编号为
 *      5 00 001
 *      第二次创建500异常，编号为
 *      5 00 002
 *      ……
 *
 *      创建400异常：
 *      400001
 *      ……
 *
 *  备注：每个写自定义异常的人，要把自己的编号写在该类下面，防止后期出现异常code重复问题
 *
 *
 *  编号记录：
 *  00： 刘争杰
 *
 * 2018-12-4 15:48:22
 * @author liuzhengjie
 * @version 1.0
 */
public class BaseException extends RuntimeException  {

    //服务器异常
    protected static final int SERVER_ERROR_STATUS = 500;
    //请求失败
    protected static final int REQUEST_FAIL_STATUS = 400;
    //请求正常
    protected static final int REQUEST_SUCCESS_STATUS = 200;

    protected static final String ERROR_MSG = "error";
    protected static final String WARNING_MSG = "warning";
    protected static final String INFO_MSG = "info";
    protected static final String OK_MSG = "ok";
    protected static final String TOO_BUSY_MSG = "too busy";

    //异常信息
    private String message = "系统异常";

    //异常码
    private int code = 500;

    //异常类型
    private String type = ERROR_MSG;

    public BaseException(){}

    public BaseException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
