package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.customer.SaleProductRecordMapper;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.exception.ex500.TokenFailureException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleProductRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("saleProductRecordService")
public class SaleProductRecordServiceImpl extends CommonServiceImpl<SaleProductRecord> implements ISaleProductRecordService {

    @Autowired
    private SaleProductRecordMapper saleProductRecordMapper;

    @Override
    public IPage<SaleProductRecord> page(IPage<SaleProductRecord> iPage, Wrapper<SaleProductRecord> wrapper) {
        try {
            // 设置查询条件
            SaleProductRecord saleProductRecord = wrapper.getEntity();
            QueryWrapper<SaleProductRecord> queryWrapper = new QueryWrapper<>();

            if(saleProductRecord.getTeamId() == null){
                // 没有查看权限
                throw new TokenFailureException();
            }
            queryWrapper.eq("t.team_id", saleProductRecord.getTeamId());

            queryWrapper.setEntity(saleProductRecord);

            //获取查询结果
            IPage<SaleProductRecord> saleProductRecordIPage = saleProductRecordMapper.page(iPage, queryWrapper);
            //加工返回值
            return saleProductRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public SaleProductRecord getOne(Wrapper<SaleProductRecord> wrapper) {
        SaleProductRecord saleProductRecord = wrapper.getEntity();
        QueryWrapper<SaleProductRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("team_id", saleProductRecord.getTeamId());
        queryWrapper.eq("id", saleProductRecord.getId());
        queryWrapper.eq("del_flag", 0);
        return super.getOne(queryWrapper);
    }
}
