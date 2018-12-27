package com.tingkelai.service.sms.sender;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.tingkelai.service.sms.bean.SmsBean;
import com.tingkelai.service.sms.bean.SmsSendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 短信发送实体
 */
@Configuration
@PropertySource(value = "file:${TKL_CONFIG_PATH}/application-test.properties")
public class SmsSender {

    private static Logger logger = LoggerFactory.getLogger(SmsSender.class);

    //产品名称:云通信短信API产品,开发者无需替换
    @Value("sms.product")
    private static final String product = "product";
    //产品域名,开发者无需替换
    @Value("sms.product")
    private static final String domain = "domain";
    @Value("sms.product")
    private static final String accessKeyId = "accessKeyId";
    @Value("sms.product")
    private static final String accessKeySecret = "accessKeySecret";
    //短信签名
    @Value("sms.product")
    private static String signature = "signature";

    public static SmsSendResult sendSms(SmsBean smsBean) throws ClientException {
        SmsSendResult smsSendResult = new SmsSendResult();

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(smsBean.getPhoneNumbers());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(smsBean.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(smsBean.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(smsBean.getTemplateParam());

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId(smsBean.getOutId());

        //hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            smsSendResult.setBizId(sendSmsResponse.getBizId());
            smsSendResult.setCode(sendSmsResponse.getCode());
            smsSendResult.setMessage(sendSmsResponse.getMessage());
            smsSendResult.setOutId(smsBean.getOutId());
            smsSendResult.setPhoneNumbers(smsBean.getPhoneNumbers());
            smsSendResult.setTemplateCode(smsBean.getTemplateCode());
        }catch (Exception e){
            logger.warn("发送短信未收到回复！");
            return null;
        }
        return smsSendResult;
    }
}
