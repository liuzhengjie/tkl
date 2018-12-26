package com.tingkelai.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.product.ProductMapper;
import com.tingkelai.domain.product.Product;
import com.tingkelai.exception.ex500.TokenFailureException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productService")
public class ProductServiceImpl extends CommonServiceImpl<Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> page(IPage<Product> iPage, Wrapper<Product> wrapper) {
        try {
            //设置查询条件
            Product product = wrapper.getEntity();
            QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
            //产品名非空，则模糊查询
            if(product.getName() != null){
                queryWrapper.like("t.name", product.getName());
                product.setName(null);
            }
            //产品code非空，则模糊查询
            if(product.getCode() != null){
                queryWrapper.like("t.code", product.getCode());
                product.setCode(null);
            }

            if(product.getTeamId() == null){
                throw new TokenFailureException();
            }
            queryWrapper.eq("t.team_id", product.getTeamId());

            queryWrapper.setEntity(product);

            //获取查询结果
            IPage<Product> productIPage = productMapper.page(iPage, queryWrapper);
            //加工返回值
            return productIPage;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public Product getOne(Wrapper<Product> wrapper) {
        Product product = wrapper.getEntity();
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("team_id", product.getTeamId());
        queryWrapper.eq("id", product.getId());
        return super.getOne(queryWrapper);
    }
}
