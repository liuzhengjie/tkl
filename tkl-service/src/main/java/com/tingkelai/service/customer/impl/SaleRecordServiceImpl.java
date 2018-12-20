package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.SaleRecordMapper;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("saleRecordService")
public class SaleRecordServiceImpl extends CommonServiceImpl<SaleRecord> implements ISaleRecordService{
    @Autowired
    private SaleRecordMapper saleRecordMapper;

    @Override
    public IPage<SaleRecord> page(IPage<SaleRecord> iPage, Wrapper<SaleRecord> wrapper) {
        try {
            //设置查询条件
            SaleRecord saleRecord = wrapper.getEntity();
            QueryWrapper<SaleRecord> queryWrapper = new QueryWrapper<>();
            if(saleRecord.getCustomer() == null || saleRecord.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", saleRecord.getCustomer().getId());
            }
            queryWrapper.setEntity(saleRecord);
            //获取查询结果
            IPage<SaleRecord> saleRecordIPage = saleRecordMapper.page(iPage, queryWrapper);
            //加工返回值
            return saleRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public SaleRecord getOne(Wrapper<SaleRecord> wrapper) {
        SaleRecord saleRecord = wrapper.getEntity();
        if(saleRecord.getId() != null){
            return saleRecordMapper.getById(saleRecord.getId());
        }
        return super.getOne(wrapper);
    }
}
