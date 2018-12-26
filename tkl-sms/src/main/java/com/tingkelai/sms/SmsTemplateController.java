package com.tingkelai.sms;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductApi;
import com.tingkelai.api.sms.SmsTemplateApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.sms.SmsTemplate;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductVO;
import com.tingkelai.vo.sms.SmsTemplateVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 短信模板处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class SmsTemplateController extends BaseCRUDController<SmsTemplate, Long> implements SmsTemplateApi<SmsTemplateVO> {

    @Override
    public ResponseMessage<List<SmsTemplateVO>> smsTemplateListGet(SmsTemplateVO smsTemplateVO, BasePage basePage) {
        return list(smsTemplateVO, basePage);
    }

    @Override
    public ResponseMessage<SmsTemplateVO> smsTemplateGet(SmsTemplateVO smsTemplateVO) {
        return getEntity(smsTemplateVO);
    }

    @Override
    public ResponseMessage<SmsTemplateVO> smsTemplatePost(@Valid SmsTemplateVO smsTemplateVO) {
        return saveEntity(smsTemplateVO);
    }

    @Override
    public ResponseMessage<SmsTemplateVO> smsTemplatePut(@Valid SmsTemplateVO smsTemplateVO) {
        return updateEntity(smsTemplateVO);
    }

    @Override
    public ResponseMessage<SmsTemplateVO> smsTemplateDelete(SmsTemplateVO smsTemplateVO) {
        return deleteEntity(smsTemplateVO);
    }
}
