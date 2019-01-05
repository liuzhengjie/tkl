package com.tingkelai.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tingkelai.dao.customer.CustomerMapper;
import com.tingkelai.dao.customer.SaleProductRecordMapper;
import com.tingkelai.dao.customer.SaleRecordMapper;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.exception.ex500.TokenFailureException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.customer.ISaleRecordService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("saleRecordService")
public class SaleRecordServiceImpl extends CommonServiceImpl<SaleRecord> implements ISaleRecordService{
    @Autowired
    private SaleRecordMapper saleRecordMapper;

    @Autowired
    private SaleProductRecordServiceImpl saleProductRecordService;

    @Autowired
    private LinkmanServiceImpl linkmanService;

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

    @Override
    public IPage<SaleRecord> pageAll(Page<SaleRecord> page, QueryWrapper<SaleRecord> wrapper) {
        try {
            //设置查询条件
            SaleRecord saleRecord = wrapper.getEntity();
            QueryWrapper<SaleRecord> queryWrapper = new QueryWrapper<>();
            if(saleRecord.getTeamId() == null){
                throw new TokenFailureException();
            }
            queryWrapper.eq("t.team_id", saleRecord.getTeamId());
            queryWrapper.setEntity(saleRecord);
            //获取查询结果
            IPage<SaleRecord> saleRecordIPage = saleRecordMapper.page(page, queryWrapper);
            //加工返回值
            return saleRecordIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean saveSaleOrder(SaleRecord saleRecord,List<SaleProductRecord> saleProductRecordList) {
        // 保存基本信息
        super.saveOrUpdate(saleRecord);
        // 保存商品信息
        for(SaleProductRecord temp : saleProductRecordList){
            temp.setSaleRecord(saleRecord);
            saleProductRecordService.saveOrUpdate(temp);
        }
        return true;
    }

    @Override
    public boolean updateSaleOrder(SaleRecord saleRecord, List<SaleProductRecord> saleProductRecordList) {
        // 修改信息
        super.saveOrUpdate(saleRecord);
        // 修改商品信息
        for(SaleProductRecord temp : saleProductRecordList){
            temp.setSaleRecord(saleRecord);
            saleProductRecordService.saveOrUpdate(temp);
        }
        return true;
    }

    @Override
    public SaleRecord getById(Serializable serializable) {
        return saleRecordMapper.getById(serializable);
    }
}












