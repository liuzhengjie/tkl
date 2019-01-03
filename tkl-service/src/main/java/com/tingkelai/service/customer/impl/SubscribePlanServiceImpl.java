package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISubscribePlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subscribePlanService")
public class SubscribePlanServiceImpl extends CommonServiceImpl<SubscribePlan> implements ISubscribePlanService {

    @Override
    public IPage<SubscribePlan> page(IPage<SubscribePlan> iPage, Wrapper<SubscribePlan> wrapper) {
        try {
            //设置查询条件
            SubscribePlan saleChance = wrapper.getEntity();
            QueryWrapper<SubscribePlan> queryWrapper = new QueryWrapper<>();
            if(saleChance.getCustomer() == null || saleChance.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("customer_id", saleChance.getCustomer().getId());
            }
            queryWrapper.eq("team_id", saleChance.getTeamId());
            queryWrapper.eq("del_flag", 0);
            //获取查询结果
            //加工返回值
            return super.page(iPage, queryWrapper);
        }catch (Exception e){
            throw e;
        }
    }
}
