package com.tingkelai.service.customer.impl;

import com.tingkelai.dao.customer.FollowRecordMapper;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IFollowRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("followRecordService")
public class FollowRecordServiceImpl extends CommonServiceImpl<FollowRecord> implements IFollowRecordService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FollowRecordMapper followRecordMapper;

    /** 根据销售机会获取最后一次跟进记录 */
    public FollowRecord getLastFollowRecord(SaleChance saleChance){
        try{
            return followRecordMapper.getLastFollowRecord(saleChance);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
