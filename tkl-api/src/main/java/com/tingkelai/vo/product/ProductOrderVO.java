package com.tingkelai.vo.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.vo.customer.SaleRecordVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 销售订单记录
 * 包含项：
 * 1、入库基本信息
 * 2、销售产品记录
 *
 * 2018-11-27 20:08:57
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "商品出库入库记录")
public class ProductOrderVO {

    /** 出入库基本信息 */
    @ApiModelProperty(value = "出入库基本信息")
    @JsonProperty("productInventory")
    private ProductInventoryVO productInventoryVO;

    @ApiModelProperty(value = "出入库关联产品信息")
    @JsonProperty("productVOList")
    private List<ProductVO> productVOList;

    public ProductInventoryVO getProductInventoryVO() {
        if(productInventoryVO == null){
            productInventoryVO = new ProductInventoryVO();
        }
        return productInventoryVO;
    }

    public void setProductInventoryVO(ProductInventoryVO productInventoryVO) {
        this.productInventoryVO = productInventoryVO;
    }

    public List<ProductVO> getProductVOList() {
        if(productVOList == null){
            productVOList = new ArrayList<>();
        }
        return productVOList;
    }

    public void setProductVOList(List<ProductVO> productVOList) {
        this.productVOList = productVOList;
    }
}

