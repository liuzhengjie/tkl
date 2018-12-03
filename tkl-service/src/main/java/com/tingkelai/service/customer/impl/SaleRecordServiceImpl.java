package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.SaleRecordMapper;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleRecordService;
import org.springframework.stereotype.Service;

@Service("saleRecordService")
public class SaleRecordServiceImpl extends CommonServiceImpl<SaleRecord> implements ISaleRecordService{
}
