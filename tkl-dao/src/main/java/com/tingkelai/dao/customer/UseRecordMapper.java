package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.UseRecord;
import org.apache.ibatis.annotations.Param;

/**
 * 机器使用情况
 * 2018-12-21 00:36:33
 * @author liuzhengjie
 * @version 1.0
 */
public interface UseRecordMapper extends BaseMapper<UseRecord>{

    IPage<UseRecord> page(@Param("iPage") IPage<UseRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<UseRecord> queryWrapper);

    UseRecord getById(@Param("id") Long id);
}
