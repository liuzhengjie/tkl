package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.SubscribePlanMapper;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISubscribePlanService;
import org.springframework.stereotype.Service;

@Service("subscribePlanService")
public class SubscribePlanServiceImpl extends CommonServiceImpl<SubscribePlanMapper, SubscribePlan> implements ISubscribePlanService {
}
