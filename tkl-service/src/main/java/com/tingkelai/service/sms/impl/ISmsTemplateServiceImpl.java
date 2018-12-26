package com.tingkelai.service.sms.impl;

import com.tingkelai.domain.sms.SmsTemplate;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sms.ISmsTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("smsTemplateService")
public class ISmsTemplateServiceImpl extends CommonServiceImpl<SmsTemplate> implements ISmsTemplateService {

}
