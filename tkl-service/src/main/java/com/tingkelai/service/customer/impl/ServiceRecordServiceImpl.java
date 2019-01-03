package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.ServiceRecordMapper;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IServiceRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceReccordService")
public class ServiceRecordServiceImpl extends CommonServiceImpl<ServiceRecord> implements IServiceRecordService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ServiceRecordMapper serviceRecordMapper;

    /** 获取分页列表 */
    @Override
    public IPage<ServiceRecord> page(IPage<ServiceRecord> iPage, Wrapper<ServiceRecord> wrapper) {
        try {
            ServiceRecord entity = wrapper.getEntity();
            // 查询条件
            QueryWrapper<ServiceRecord> queryWrapper = new QueryWrapper<>();
            // 设置查询条件
            if(entity.getCustomer() == null || entity.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }
            queryWrapper.eq("t.team_id", entity.getTeamId());
            queryWrapper.eq("t.del_flag", 0);
            queryWrapper.eq("t.customer_id", entity.getCustomer().getId());
            return serviceRecordMapper.page(iPage, queryWrapper);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ServiceRecord getOne(Wrapper<ServiceRecord> wrapper) {
        try {
            ServiceRecord entity = wrapper.getEntity();
            // 查询条件
            QueryWrapper<ServiceRecord> queryWrapper = new QueryWrapper<>();
            // 设置查询条件
            if(entity.getId() == null){
                throw new LackParamsException("缺少参数id");
            }
            queryWrapper.eq("t.team_id", entity.getTeamId());
            queryWrapper.eq("t.del_flag", 0);
            queryWrapper.eq("t.id", entity.getId());
            return serviceRecordMapper.getOne(queryWrapper);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }
}
