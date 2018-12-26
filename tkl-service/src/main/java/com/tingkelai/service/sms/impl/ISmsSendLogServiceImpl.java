package com.tingkelai.service.sms.impl;

import com.tingkelai.domain.sms.SmsSendLog;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.sms.ISmsSendLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("smsSendLogService")
public class ISmsSendLogServiceImpl extends CommonServiceImpl<SmsSendLog> implements ISmsSendLogService {

}
