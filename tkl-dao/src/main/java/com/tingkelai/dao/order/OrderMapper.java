package com.tingkelai.dao.order;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.order.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * 订单（账单）管理mapper
 *
 * 2018-11-27 20:42:34
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /** 获取订单（账单）列表 */
    IPage<Order> page(@Param("iPage") IPage<Order> iPage, @Param(Constants.WRAPPER) Wrapper<Order> wrapper);

    @Override
    Order selectById(@Param("id") Serializable id);
}
