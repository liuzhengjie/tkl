package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 客户处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:42:34
 * @version 1.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

//    /** 获取客户信息，带分页、模糊查询 */
    IPage<Customer> page(@Param("iPage") IPage<Customer> iPage, @Param(Constants.WRAPPER) QueryWrapper<Customer> queryWrapper);

    /** 获取客户信息 */
    Customer getById(@Param("id") Long id);
//
//    Customer getOne(@Param("wrapper") Wrapper<Customer> wrapper);
//
//    boolean save(@Param("entity") Customer entity);
//
//    boolean saveOrUpdate(@Param("customer") Customer customer);

//    boolean remove(@Param("wrapper") Wrapper<Customer> wrapper);
}
