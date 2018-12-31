package com.tingkelai.service.product.impl;

import com.tingkelai.dao.product.ProductInventoryMapper;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.product.IProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("productInventoryService")
public class ProductInventoryServiceImpl extends CommonServiceImpl<ProductInventory> implements IProductInventoryService {

    @Autowired
    private ProductInventoryMapper productInventoryMapper;

    @Autowired
    private ProductServiceImpl productService;

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
}
