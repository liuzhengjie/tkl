package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.ServiceRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 服务记录mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:50:46
 * @version 1.0
 */
@Mapper
public interface ServiceRecordMapper extends BaseMapper<ServiceRecord> {

    /** 获取服务记录列表 */
    IPage<ServiceRecord> page(@Param("iPage") IPage<ServiceRecord> iPage, @Param(Constants.WRAPPER) QueryWrapper<ServiceRecord> queryWrapper);

    /** 根据id获取服务记录 */
    ServiceRecord getOne(@Param(Constants.WRAPPER) Wrapper<ServiceRecord> wrapper);
}
