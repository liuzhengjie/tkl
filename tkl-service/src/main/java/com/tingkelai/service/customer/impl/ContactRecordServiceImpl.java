package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.ContactRecordMapper;
import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IContactRecordService;
import org.springframework.stereotype.Service;

@Service("contactRecordService")
public class ContactRecordServiceImpl extends CommonServiceImpl<ContactRecordMapper, ContactRecord> implements IContactRecordService {
}
