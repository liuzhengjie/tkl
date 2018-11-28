package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.SaleChanceMapper;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleChanceService;
import org.springframework.stereotype.Service;

@Service("saleChanceService")
public class SaleChanceServiceImpl extends CommonServiceImpl<SaleChanceMapper, SaleChance> implements ISaleChanceService{
}
