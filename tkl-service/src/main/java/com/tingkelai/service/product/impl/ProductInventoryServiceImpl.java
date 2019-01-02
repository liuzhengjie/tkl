package com.tingkelai.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tingkelai.dao.product.ProductInventoryMapper;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.exception.ex400.LackParamsException;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.product.IProductInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productInventoryService")
public class ProductInventoryServiceImpl extends CommonServiceImpl<ProductInventory> implements IProductInventoryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ProductInventoryMapper productInventoryMapper;

    @Autowired
    private ProductServiceImpl productService;

    /** 获取产品出入库列表，根据产品id */
    @Override
    public IPage<ProductInventory> page(IPage<ProductInventory> iPage, Wrapper<ProductInventory> wrapper) {
        try {
            ProductInventory entity = wrapper.getEntity();
            if(entity.getProduct() == null || entity.getProduct().getId() == null){
                throw new LackParamsException("缺少参数");
            }
            QueryWrapper<ProductInventory> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("t.team_id", entity.getTeamId());
            queryWrapper.eq("t.del_flag", 0);
            queryWrapper.eq("t.product_id", entity.getProduct().getId());
            return productInventoryMapper.page(iPage, queryWrapper);
        } catch (Exception e){
            logger.error(e.getMessage());
            throw e;
        }
    }

    /** 添加出库入库信息 */
    public boolean saveInventoryOrder(ProductInventory productInventory, List<Product> productList) {
        // 保存基本信息
        productInventoryMapper.insert(productInventory);
        // 保存出入库关联产品信息
        for(Product product : productList){
            productService.save(product);
        }
        return true;
    }

    /** 修改出入库信息 */
    public boolean updateInventoryOrder(ProductInventory productInventory, List<Product> productList) {
        // 保存基本信息
        super.saveOrUpdate(productInventory);
        // 保存出入库关联的产品信息
        for(Product product : productList){
            productService.saveOrUpdate(product);
        }
        return true;
    }

    /** 添加出入库信息 */
    public boolean saveInventoryList(List<ProductInventory> productInventoryList) {
        try{
            for(ProductInventory temp : productInventoryList){
                productInventoryMapper.insert(temp);
            }
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public ProductInventory getOne(Wrapper<ProductInventory> wrapper) {
        ProductInventory entity = wrapper.getEntity();
        QueryWrapper<ProductInventory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("t.team_id", entity.getTeamId());
        queryWrapper.eq("t.id", entity.getId());
        return productInventoryMapper.getOne(queryWrapper);
    }

    /** 修改出入库信息 */
    public boolean updateInventoryList(List<ProductInventory> productInventory) {
        try{
            for(ProductInventory temp : productInventory){
                super.saveOrUpdate(temp);
            }
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
}
