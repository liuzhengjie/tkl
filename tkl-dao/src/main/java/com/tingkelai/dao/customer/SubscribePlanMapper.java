package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.SubscribePlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 预约计划mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:52:41
 * @version 1.0
 */
@Mapper
public interface SubscribePlanMapper  extends BaseMapper<SubscribePlan>{
    @Override
    IPage<SubscribePlan> selectPage(@Param("page") IPage<SubscribePlan> page, @Param(Constants.WRAPPER) Wrapper<SubscribePlan> queryWrapper);
}
