package com.tingkelai.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.UseRecordMapper;
import com.tingkelai.dao.product.ProductMapper;
import com.tingkelai.domain.customer.UseRecord;
import com.tingkelai.domain.product.Product;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.IUseRecordService;
import com.tingkelai.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("useRecordService")
public class UseRecordServiceImpl extends CommonServiceImpl<UseRecord> implements IUseRecordService {

    @Autowired
    private UseRecordMapper useRecordMapper;

    @Override
    public IPage<UseRecord> page(IPage<UseRecord> iPage, Wrapper<UseRecord> wrapper) {
        try {
            //设置查询条件
            UseRecord useRecord = wrapper.getEntity();
            QueryWrapper<UseRecord> queryWrapper = new QueryWrapper<>();
            if(useRecord.getCustomer() == null || useRecord.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", useRecord.getCustomer().getId());
            }
            queryWrapper.setEntity(useRecord);
            //获取查询结果
            IPage<UseRecord> useRecordIPage = useRecordMapper.page(iPage, queryWrapper);
            //加工返回值
            return useRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public UseRecord getOne(Wrapper<UseRecord> wrapper) {
        UseRecord useRecord = wrapper.getEntity();
        if(useRecord.getId() != null){
            return useRecordMapper.getById(useRecord.getId());
        }
        return super.getOne(wrapper);
    }
}
