package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.SaleRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * 销售记录mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:49:32
 * @version 1.0
 */
@Mapper
public interface SaleRecordMapper extends BaseMapper<SaleRecord> {
    /** 获取指定用户下所有销售记录（订单、账单） */
    IPage<SaleRecord> page(@Param("iPage") IPage<SaleRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<SaleRecord> queryWrapper);

    SaleRecord getById(@Param("id") Serializable id);

    /** 获取公司所有用户销售记录（订单、账单） */
    IPage<SaleRecord> pageAll(@Param("iPage") IPage<SaleRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<SaleRecord> queryWrapper);
}
