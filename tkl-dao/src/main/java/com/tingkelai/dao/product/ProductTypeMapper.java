package com.tingkelai.dao.product;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.product.ProductType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类mapper
 * 2018-12-18 16:06:36
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    List<ProductType> asyncTree(@Param("productType") ProductType productType, @Param(Constants.WRAPPER) Wrapper<ProductType> queryWrapper);
}