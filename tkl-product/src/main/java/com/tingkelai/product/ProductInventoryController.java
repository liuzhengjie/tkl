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
import com.tingkelai.vo.product.inventory.InventoryVO;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
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
    public ResponseMessage<InventoryVO> productInventoryPost(@Valid InventoryVO inventoryVO) {
        try{
            ResponseMessage<InventoryVO> responseMessage = new ResponseMessage<>();
            // 转换成dto
            inventoryVO.setTeamId(getCurrentUserTeamId());
            List<ProductInventory> productInventory = inventoryVO.toDTO();
            boolean flag = productInventoryService.saveInventoryList(productInventory);
            responseMessage.setMessage("保存成功！");
            return responseMessage;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseMessage<>(e);
        }
    }

    @Override
    public ResponseMessage<InventoryVO> productInventoryPut(@Valid InventoryVO inventoryVO) {
        try{
            ResponseMessage<InventoryVO> responseMessage = new ResponseMessage<>();
            // 转换成dto
            inventoryVO.setTeamId(getCurrentUserTeamId());
            List<ProductInventory> productInventory = inventoryVO.toDTO();
            boolean flag = productInventoryService.updateInventoryList(productInventory);
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
