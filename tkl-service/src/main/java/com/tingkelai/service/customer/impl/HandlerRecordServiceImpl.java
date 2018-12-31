package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.HandlerRecordMapper;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.IHandlerRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("handlerRecordService")
public class HandlerRecordServiceImpl extends CommonServiceImpl<HandlerRecord> implements IHandlerRecordService {

    @Autowired
    private HandlerRecordMapper handlerRecordMapper;

    @Override
    public IPage<HandlerRecord> page(IPage<HandlerRecord> iPage, Wrapper<HandlerRecord> wrapper) {
        try {
            //设置查询条件
            HandlerRecord handlerRecord = wrapper.getEntity();
            QueryWrapper<HandlerRecord> queryWrapper = new QueryWrapper<>();
            if(handlerRecord.getCustomer() == null || handlerRecord.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", handlerRecord.getCustomer().getId());
            }
            queryWrapper.eq("team_id", handlerRecord.getTeamId());
            queryWrapper.setEntity(handlerRecord);
            //获取查询结果
            IPage<HandlerRecord> handlerRecordIPage = handlerRecordMapper.page(iPage, queryWrapper);
            //加工返回值
            return handlerRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }
}
