package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.ContactRecordMapper;
import com.tingkelai.dao.customer.LinkManMapper;
import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IContactRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 联系记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-29 10:10:50
 * @version 1.0
 */
@Service("contactRecordService")
public class ContactRecordServiceImpl extends CommonServiceImpl<ContactRecord> implements IContactRecordService{

    @Autowired
    private ContactRecordMapper contactRecordMapper;

    @Override
    public IPage<ContactRecord> page(IPage<ContactRecord> iPage, Wrapper<ContactRecord> wrapper) {
        try {
            //设置查询条件
            ContactRecord contactRecord = wrapper.getEntity();
            QueryWrapper<ContactRecord> queryWrapper = new QueryWrapper<>();
            if(contactRecord.getCustomer() == null || contactRecord.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", contactRecord.getCustomer().getId());
            }
            queryWrapper.setEntity(contactRecord);
            //获取查询结果
            IPage<ContactRecord> contactRecordIPage = contactRecordMapper.page(iPage, queryWrapper);
            //加工返回值
            return contactRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public ContactRecord getOne(Wrapper<ContactRecord> wrapper) {
        ContactRecord contactRecord = wrapper.getEntity();
        if(contactRecord.getId() != null){
            return contactRecordMapper.getById(contactRecord.getId());
        }
        return super.getOne(wrapper);
    }
}
