package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.HandlerRecordMapper;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IHandlerRecordService;
import org.springframework.stereotype.Service;

@Service("handlerRecordService")
public class HandlerRecordServiceImpl extends CommonServiceImpl<HandlerRecord> implements IHandlerRecordService {
}
