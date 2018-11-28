package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.SaleProductRecordMapper;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleProductRecordService;
import org.springframework.stereotype.Service;

@Service("saleProductRecordService")
public class SaleProductRecordServiceImpl extends CommonServiceImpl<SaleProductRecordMapper, SaleProductRecord> implements ISaleProductRecordService {
}
