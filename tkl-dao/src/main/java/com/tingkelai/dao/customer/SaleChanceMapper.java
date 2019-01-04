package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.SaleChance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * 销售机会mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:46:54
 * @version 1.0
 */
@Mapper
public interface SaleChanceMapper extends BaseMapper<SaleChance> {
    IPage<SaleChance> page(@Param("iPage") IPage<SaleChance> iPage, @Param(Constants.WRAPPER) QueryWrapper<SaleChance> queryWrapper);

    SaleChance getById(Long id);

    @Override
    SaleChance selectById(@Param("id") Serializable id);
}
