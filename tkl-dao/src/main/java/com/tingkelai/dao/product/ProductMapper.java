package com.tingkelai.dao.product;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 产品mapper
 * 2018-12-18 16:06:36
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    IPage<Product> page(@Param("iPage") IPage<Product> iPage,  @Param(Constants.WRAPPER)  QueryWrapper<Product> queryWrapper);

    Product getById(@Param("id") Long id);

    Product getOne(@Param(Constants.WRAPPER)  QueryWrapper<Product> queryWrapper);

}