package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.LinkManMapper;
import com.tingkelai.dao.customer.UseRecordMapper;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.domain.customer.UseRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("linkmanService")
public class LinkmanServiceImpl extends CommonServiceImpl<LinkMan> implements ILinkmanService{

    @Autowired
    private LinkManMapper linkManMapper;

    @Override
    public IPage<LinkMan> page(IPage<LinkMan> iPage, Wrapper<LinkMan> wrapper) {
        try {
            //设置查询条件
            LinkMan linkMan = wrapper.getEntity();
            QueryWrapper<LinkMan> queryWrapper = new QueryWrapper<>();
            if(linkMan.getCustomer() == null || linkMan.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", linkMan.getCustomer().getId());
            }
            queryWrapper.setEntity(linkMan);
            //获取查询结果
            IPage<LinkMan> linkManIPage = linkManMapper.page(iPage, queryWrapper);
            //加工返回值
            return linkManIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public LinkMan getOne(Wrapper<LinkMan> wrapper) {
        LinkMan useRecord = wrapper.getEntity();
        if(useRecord != null && useRecord.getId() != null){
            return linkManMapper.getById(useRecord.getId());
        }
        return super.getOne(wrapper);
    }

    /** 通过客户id获取客户的主联系人 */
    public LinkMan getCustomerMainLinkMan(Long customerId){
        // 客户的主联系人
        QueryWrapper<LinkMan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("customer_id", customerId);
        queryWrapper.eq("del_flag", 0);
        queryWrapper.eq("primary_flag", "1");
        return getOne(queryWrapper);
    }
}
