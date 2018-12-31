package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.HandlerRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 经手人记录处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:44:57
 * @version 1.0
 */
@Mapper
public interface HandlerRecordMapper extends BaseMapper<HandlerRecord> {

    IPage<HandlerRecord> page(@Param("iPage") IPage<HandlerRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<HandlerRecord> queryWrapper);
}
