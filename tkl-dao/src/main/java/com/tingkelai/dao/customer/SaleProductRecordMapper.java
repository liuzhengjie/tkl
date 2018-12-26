package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.SaleProductRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 销售产品记录mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:48:19
 * @version 1.0
 */
@Mapper
public interface SaleProductRecordMapper extends BaseMapper<SaleProductRecord>{

    /** 分页查询记录 */
    IPage<SaleProductRecord> page(@Param("iPage") IPage<SaleProductRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<SaleProductRecord> queryWrapper);
}
