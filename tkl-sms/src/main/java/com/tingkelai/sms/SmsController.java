package com.tingkelai.sms;

import com.alibaba.fastjson.JSON;
import com.tingkelai.api.sms.SmsApi;
import com.tingkelai.constant.SystemConstant;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.service.sms.bean.SmsBean;
import com.tingkelai.service.sms.bean.SmsSendResult;
import com.tingkelai.service.sms.sender.SmsSender;
import com.tingkelai.util.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送记录相关controller
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class SmsController implements SmsApi{

    @Autowired
    private SmsSender smsSender;

    @Override
    public ResponseMessage sendRegistVerifyCode(String phone) {
        try{
            // 发送信息
            SmsBean smsBean = new SmsBean();
            smsBean.setPhoneNumbers(phone);
            smsBean.setSignName("注册验证");
            Map map = new HashMap<>();
            map.put("code", smsBean.getOutId());
            map.put("product", "听客来");
            smsBean.setTemplateParam(JSON.toJSONString(map));
            smsBean.setTemplateCode("SMS_3710271");
            SmsSendResult smsSendResult = smsSender.sendSms(smsBean);
            if(smsSendResult == null){
                return new ResponseMessage(new Exception());
            }
            // 将验证码放入redis备用
            RedisUtils.setKey(SystemConstant.REGIST_NAME_PRE + phone, smsSendResult.getOutId());
            // 返回信息
            Map<String, String> resMap = new HashMap<String, String>();
            resMap.put("code", smsSendResult.getCode());
            resMap.put("message", smsSendResult.getMessage());
            return new ResponseMessage(resMap);
        }catch (Exception e){
            return new ResponseMessage(e);
        }
    }

    @Override
    public ResponseMessage sendResetPwdVerifyCode(String phone) {
        try{
            // 发送信息
            SmsBean smsBean = new SmsBean();
            smsBean.setPhoneNumbers(phone);
            smsBean.setSignName("变更验证");
            Map map = new HashMap<>();
            map.put("product", "听客来");
            map.put("code", smsBean.getOutId());
            smsBean.setTemplateParam(JSON.toJSONString(map));
            smsBean.setTemplateCode("SMS_3710269");
            SmsSendResult smsSendResult = smsSender.sendSms(smsBean);
            if(smsSendResult == null){
                return new ResponseMessage(new Exception());
            }
            // 将验证码放入redis备用
            RedisUtils.setKey(SystemConstant.RESET_NAME_PRE + phone, smsSendResult.getOutId());
            // 返回信息
            Map<String, String> resMap = new HashMap<String, String>();
            resMap.put("code", smsSendResult.getCode());
            resMap.put("message", smsSendResult.getMessage());
            return new ResponseMessage(resMap);
        }catch (Exception e){
            return new ResponseMessage(e);
        }
    }
}
