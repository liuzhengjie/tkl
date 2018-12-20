package com.tingkelai.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.Product;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 动态模板处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class ProductController extends BaseCRUDController<Product, Long> implements ProductApi<ProductVO> {

    @Override
    public ResponseMessage<List<ProductVO>> productListGet(ProductVO productVO, BasePage basePage) {
        return list(productVO, basePage);
    }

    @Override
    public ResponseMessage<ProductVO> productGet(ProductVO productVO) {
        return getEntity(productVO);
    }

    @Override
    public ResponseMessage<ProductVO> productPost(@Valid ProductVO productVO) {
        return saveEntity(productVO);
    }

    @Override
    public ResponseMessage<ProductVO> productPut(@Valid ProductVO productVO) {
        return updateEntity(productVO);
    }

    @Override
    public ResponseMessage<ProductVO> productDelete(ProductVO productVO) {
        return deleteEntity(productVO);
    }
}
