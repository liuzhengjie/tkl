package com.tingkelai.product;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductInventoryApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.service.product.impl.ProductInventoryServiceImpl;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductInventoryVO;
import com.tingkelai.vo.product.ProductOrderVO;
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

    /** 出入库相关service */
    private ProductInventoryServiceImpl productInventoryService;

    @Override
    public ResponseMessage<List<ProductInventoryVO>> productInventoryListGet(ProductInventoryVO productInventoryVO, BasePage basePage) {
        return list(productInventoryVO, basePage);
    }

    @Override
    public ResponseMessage<ProductInventoryVO> productInventoryGet(ProductInventoryVO productInventoryVO) {
        return getEntity(productInventoryVO);
    }

    @Override
    public ResponseMessage<ProductOrderVO> productInventoryPost(@Valid ProductOrderVO productOrderVO) {
        try{
            ResponseMessage<ProductOrderVO> responseMessage = new ResponseMessage<>();
            // 要保存的出入库订单基本信息
            ProductInventory productInventory = productOrderVO.getProductInventoryVO().toDTO();
            // 要保存的出入库产品列表
            List<ProductVO> productVOList = productOrderVO.getProductVOList();
            ProductVO productVO = new ProductVO();
            List<Product> productList = productVO.toDTO(productVOList);
            boolean flag = productInventoryService.saveInventoryOrder(productInventory, productList);
            responseMessage.setMessage("保存成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<ProductOrderVO> productInventoryPut(@Valid ProductOrderVO productOrderVO) {
        try{
            ResponseMessage<ProductOrderVO> responseMessage = new ResponseMessage<>();
            // 要保存的出入库订单基本信息
            ProductInventory productInventory = productOrderVO.getProductInventoryVO().toDTO();
            // 要修改的出入库产品列表
            List<ProductVO> productVOList = productOrderVO.getProductVOList();
            ProductVO productVO = new ProductVO();
            List<Product> productList = productVO.toDTO(productVOList);
            boolean flag = productInventoryService.updateInventoryOrder(productInventory, productList);
            responseMessage.setMessage("修改成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage productInventoryDelete(ProductInventoryVO productInventoryVO) {
        return deleteEntity(productInventoryVO);
    }
}
