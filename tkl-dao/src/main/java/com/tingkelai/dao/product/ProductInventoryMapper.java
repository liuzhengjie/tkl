package com.tingkelai.dao.product;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 商品库存（出库入库）相关mapper
 * 2018-12-18 16:06:36
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface ProductInventoryMapper extends BaseMapper<ProductInventory> {

}