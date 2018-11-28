package com.tingkelai.dao.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.customer.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户处理mapper
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:42:34
 * @version 1.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
