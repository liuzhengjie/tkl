package com.tingkelai.vo.product.inventory;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.product.ProductVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品库存记录（出库入库）
 */
@TableName("tkl_product_inventory")
@ApiModel(description = "出入库扩展信息vo")
@SuppressWarnings("serial")
public class InventoryExtInfoVO{

	public InventoryExtInfoVO(){

	}

	public InventoryExtInfoVO(ProductInventory productInventory){

	}

	/** 入库进价 */
	@JsonProperty("storagePrice")
	@ApiModelProperty(value = "入库进价")
	private Double storagePrice;

	/** 变动数量 */
	@JsonProperty("changeNum")
	@ApiModelProperty(value = "变动数量")
	private Integer changeNum;

	/** 库存量 */
	@JsonProperty("storageNum")
	@ApiModelProperty(value = "库存量")
	private Integer storageNum;

	/** 关联商品 */
	@JsonProperty("product")
	@ApiModelProperty(value = "关联商品")
	private ProductVO product;

	/** 数据所属公司 */
	@ApiModelProperty(hidden = true)
	private Long teamId;

	public Double getStoragePrice() {
		return storagePrice;
	}

	public void setStoragePrice(Double storagePrice) {
		this.storagePrice = storagePrice;
	}

	public Integer getChangeNum() {
		return changeNum;
	}

	public void setChangeNum(Integer changeNum) {
		this.changeNum = changeNum;
	}

	public Integer getStorageNum() {
		return storageNum;
	}

	public void setStorageNum(Integer storageNum) {
		this.storageNum = storageNum;
	}

	public ProductVO getProduct() {
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
}
