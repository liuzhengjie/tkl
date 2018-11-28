package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.ServiceRecordMapper;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IServiceRecordService;
import org.springframework.stereotype.Service;

@Service("serviceReccordService")
public class ServiceRecordServiceImpl extends CommonServiceImpl<ServiceRecordMapper, ServiceRecord> implements IServiceRecordService {
}
