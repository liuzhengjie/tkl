package com.tingkelai.dao.product;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
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

    /** 获取商品出入库详情 */
    ProductInventory getOne(@Param(Constants.WRAPPER) QueryWrapper<ProductInventory> queryWrapper);

    /** 获取指定商品的出入库列表 */
    IPage<ProductInventory> page(@Param("iPage") IPage<ProductInventory> iPage, @Param(Constants.WRAPPER) Wrapper<ProductInventory> wrapper);
}