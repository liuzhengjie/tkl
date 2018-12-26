package com.tingkelai.service.sms.bean;

import com.tingkelai.util.RandomUtils;

/**
 * 发送短信需要的基本信息
 * 2018-12-25 14:50:57
 * @author liuzhengjie
 * @version 1.0
 */
public class SmsBean {

    //必填:待发送手机号
    String phoneNumbers;

    //必填:短信签名-可在短信控制台中找到
    String signName = "注册验证";

    //必填:短信模板-可在短信控制台中找到
    String templateCode;

    //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
    String templateParam;

    //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
    String smsUpExtendCode;

    //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
    String outId = RandomUtils.randomNum();

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateParam() {
        return templateParam;
    }

    public void setTemplateParam(String templateParam) {
        this.templateParam = templateParam;
    }

    public String getSmsUpExtendCode() {
        return smsUpExtendCode;
    }

    public void setSmsUpExtendCode(String smsUpExtendCode) {
        this.smsUpExtendCode = smsUpExtendCode;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }
}
