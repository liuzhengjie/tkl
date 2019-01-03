package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.SaleChanceMapper;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("saleChanceService")
public class SaleChanceServiceImpl extends CommonServiceImpl<SaleChance> implements ISaleChanceService{
    @Autowired
    private SaleChanceMapper saleChanceMapper;

    @Autowired
    private FollowRecordServiceImpl followRecordService;

    @Override
    public IPage<SaleChance> page(IPage<SaleChance> iPage, Wrapper<SaleChance> wrapper) {
        try {
            //设置查询条件
            SaleChance saleChance = wrapper.getEntity();
            QueryWrapper<SaleChance> queryWrapper = new QueryWrapper<>();
            if(saleChance.getCustomer() == null || saleChance.getCustomer().getId() == null){
                throw new LackParamsException("缺少参数customer.id");
            }else{
                queryWrapper.eq("t.customer_id", saleChance.getCustomer().getId());
            }
            queryWrapper.setEntity(saleChance);
            //获取查询结果
            IPage<SaleChance> saleChanceIPage = saleChanceMapper.page(iPage, queryWrapper);
            //加工返回值
            List<SaleChance> res = saleChanceIPage.getRecords();
            for(SaleChance temp : res){
                temp.setFollowRecord(followRecordService.getLastFollowRecord(temp));
            }
            saleChanceIPage.setRecords(res);
            return saleChanceIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public SaleChance getOne(Wrapper<SaleChance> wrapper) {
        SaleChance saleChance = wrapper.getEntity();
        if(saleChance.getId() != null){
            return saleChanceMapper.getById(saleChance.getId());
        }
        QueryWrapper<SaleChance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("team_id", saleChance.getTeamId());
        queryWrapper.eq("id", saleChance.getId());
        queryWrapper.eq("del_flag", 0);
        return super.getOne(queryWrapper);
    }
}
