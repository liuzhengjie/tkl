package com.tingkelai.service.sms.bean;

/**
 * 短信发送后返回的结果
 * 2018-12-25 14:57:43
 * @author liuzhengjie
 * @version 1.0
 */
public class SmsSendResult {

    /** 发送手机号 */
    String phoneNumbers;

    /** 业务号 */
    String bizId;

    /** 发送模板code */
    String templateCode;

    /** outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者 */
    String outId;

    /** 返回码 */
    String code;

    /** 返回信息 */
    String message;

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
