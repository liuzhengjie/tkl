package com.tingkelai.service.product.impl;

import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.product.IProductInventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("productInventoryService")
public class ProductInventoryServiceImpl extends CommonServiceImpl<ProductInventory> implements IProductInventoryService {

}
