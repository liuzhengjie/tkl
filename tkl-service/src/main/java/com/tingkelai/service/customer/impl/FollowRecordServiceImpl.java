package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.FollowRecordMapper;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IFollowRecordService;
import org.springframework.stereotype.Service;

@Service("followRecordService")
public class FollowRecordServiceImpl extends CommonServiceImpl<FollowRecordMapper, FollowRecord> implements IFollowRecordService {
}
