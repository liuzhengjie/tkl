package com.tingkelai.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.EmptyWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.product.ProductTypeMapper;
import com.tingkelai.domain.product.ProductType;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.product.IProductTypeService;
import com.tingkelai.util.tree.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("productTypeService")
public class ProductTypeServiceImpl extends CommonServiceImpl<ProductType> implements IProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public IPage<ProductType> page(IPage<ProductType> iPage, Wrapper<ProductType> wrapper) {
        try {
            //设置查询条件
            ProductType product = wrapper.getEntity();
            QueryWrapper<ProductType> queryWrapper = new QueryWrapper<>();
            //产品名非空，则模糊查询
            if(product.getName() != null){
                queryWrapper.like("name", product.getName());
            }
            //产品code非空，则模糊查询
            if(product.getCode() != null){
                queryWrapper.like("code", product.getCode());
            }

            //获取查询结果
            IPage<ProductType> productTypeIPage = super.page(iPage, queryWrapper);
            //加工返回值
            return productTypeIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ProductType> getTreeList(ProductType productType, String async) {
        if("0".equals(async)){
            //同步调用
            return syncTree(productType);
        }else{
            //异步调用
            return asyncTree(productType);
        }
    }

    /**
     * 异步调用tree数据
     * @param productType 参数
     * @return 商品类型list
     */
    private List<ProductType> asyncTree(ProductType productType) {
        try{
            return  productTypeMapper.asyncTree(productType, new EmptyWrapper<>());
        }catch (Exception e){
            throw e;
        }
    }


    /**
     * 同步调用tree数据
     * @param productType 参数
     * @return 商品类型list
     */
    private List<ProductType> syncTree(ProductType productType) {
        try {
            //设置返回值
            QueryWrapper<ProductType> queryWrapper = new QueryWrapper<>();
            queryWrapper.setEntity(productType);
            //父级id存在
            if(productType != null && productType.getParent() != null && productType.getParent().getId() != null){
                Long parentId = productType.getParent().getId();
                queryWrapper.eq("parent_id", parentId + "");
            }else{
                queryWrapper.isNull("parent_id");
            }
            return super.list(queryWrapper);
        }catch (Exception e){
            throw e;
        }
    }
}
