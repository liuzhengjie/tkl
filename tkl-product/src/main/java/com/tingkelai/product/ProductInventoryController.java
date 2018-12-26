package com.tingkelai.product;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductApi;
import com.tingkelai.api.product.ProductInventoryApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductInventoryVO;
import com.tingkelai.vo.product.ProductVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品库存（出库入库）相关controller
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class ProductInventoryController extends BaseCRUDController<ProductInventory, Long> implements ProductInventoryApi<ProductInventoryVO> {

    @Override
    public ResponseMessage<List<ProductInventoryVO>> productInventoryListGet(ProductInventoryVO productInventoryVO, BasePage basePage) {
        return list(productInventoryVO, basePage);
    }

    @Override
    public ResponseMessage<ProductInventoryVO> productInventoryGet(ProductInventoryVO productInventoryVO) {
        return getEntity(productInventoryVO);
    }

    @Override
    public ResponseMessage<ProductInventoryVO> productInventoryPost(@Valid ProductInventoryVO productInventoryVO) {
        return saveEntity(productInventoryVO);
    }

    @Override
    public ResponseMessage<ProductInventoryVO> productInventoryPut(@Valid ProductInventoryVO productInventoryVO) {
        return updateEntity(productInventoryVO);
    }

    @Override
    public ResponseMessage productInventoryDelete(ProductInventoryVO productInventoryVO) {
        return deleteEntity(productInventoryVO);
    }
}
