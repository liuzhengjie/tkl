package com.tingkelai.service.product;


import com.tingkelai.domain.product.ProductType;
import com.tingkelai.service.common.ICommonService;

import java.util.List;

/**
 * 产品相关service（主表）
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:36:02
 * @version 1.0
 *
 */
public interface IProductTypeService extends ICommonService<ProductType> {

    /**
     * 获取树形结构数据
     * @param productType 参数值
     * @param async 0：同步，1：异步
     * @return
     */
    List<ProductType> getTreeList(ProductType productType, String async);
}
