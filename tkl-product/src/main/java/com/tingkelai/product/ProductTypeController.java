package com.tingkelai.product;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.product.ProductTypeApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.product.ProductType;
import com.tingkelai.service.product.IProductTypeService;
import com.tingkelai.util.tree.TreeUtil;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.product.ProductTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;



import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品分类处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class ProductTypeController extends BaseCRUDController<ProductType, Long> implements ProductTypeApi<ProductTypeVO> {

    @Autowired
    private IProductTypeService productTypeService;

    @Override
    public ResponseMessage<List<ProductTypeVO>> productTypeListGet(ProductTypeVO productTypeVO, BasePage basePage) {
        return list(productTypeVO, basePage);
    }

    @Override
    public ResponseMessage productTypeTreeGet(ProductTypeVO productTypeVO, String async) {
        List<ProductType> list = productTypeService.getTreeList(productTypeVO.toDTO(), async);

        List<Map<String,Object>> data = new ArrayList<>();
        for(ProductType productType : list){
            Map<String,Object> map = new HashMap<>();
            map.put("id", productType.getId());
            if(productType.getParent().getId() == null){
                map.put("pid", 0);
            }else{
                map.put("pid", productType.getParent().getId());
            }
            map.put("value", productType.getCode());
            map.put("label", productType.getName());
            data.add(map);
        }
        JSONArray result = TreeUtil.listToTree(JSONArray.parseArray(JSON.toJSONString(data)),"id","pid","children");
       return new ResponseMessage(result);
    }

    @Override
    public ResponseMessage<ProductTypeVO> productTypeGet(ProductTypeVO productTypeVO) {
        return getEntity(productTypeVO);
    }

    @Override
    public ResponseMessage<ProductTypeVO> productTypePost(@Valid ProductTypeVO productTypeVO) {
        return saveEntity(productTypeVO);
    }

    @Override
    public ResponseMessage<ProductTypeVO> productTypePut(@Valid ProductTypeVO productTypeVO) {
        return updateEntity(productTypeVO);
    }

    @Override
    public ResponseMessage<ProductTypeVO> productTypeDelete(ProductTypeVO productTypeVO) {
        return deleteEntity(productTypeVO);
    }
}
