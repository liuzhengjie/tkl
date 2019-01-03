package com.tingkelai.vo.product.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.product.ProductInventory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品出入库基本信息vo
 */
@ApiModel(description = "商品出入库基本信息vo")
public class InventoryVO {

	public InventoryVO(){

	}

	public InventoryVO(ProductInventory productInventory){

	}

	/** 入库基本信息 */
	@ApiModelProperty(value = "出入库基本信息")
	@JsonProperty("inventoryBaseInfoVO")
	private InventoryBaseInfoVO inventoryBaseInfoVO;

	/** 入库商品扩展信息 */
	@ApiModelProperty(value = "出入库关联产品信息")
	@JsonProperty("inventoryExtInfoVOList")
	private List<InventoryExtInfoVO> inventoryExtInfoVOList;

	@ApiModelProperty(hidden = true)
	private Long teamId;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public InventoryBaseInfoVO getInventoryBaseInfoVO() {
		if(inventoryBaseInfoVO == null){
			inventoryBaseInfoVO = new InventoryBaseInfoVO();
		}
		return inventoryBaseInfoVO;
	}

	public void setInventoryBaseInfoVO(InventoryBaseInfoVO inventoryBaseInfoVO) {
		this.inventoryBaseInfoVO = inventoryBaseInfoVO;
	}

	public List<InventoryExtInfoVO> getInventoryExtInfoVOList() {
		if(inventoryExtInfoVOList == null){
			inventoryExtInfoVOList = new ArrayList<>();
		}
		return inventoryExtInfoVOList;
	}

	public void setInventoryExtInfoVOList(List<InventoryExtInfoVO> inventoryExtInfoVOList) {
		this.inventoryExtInfoVOList = inventoryExtInfoVOList;
	}

	/**
	 * 将前端传来参数转换成出入库信息
	 * @return
	 */
	public List<ProductInventory> toDTO() {
		List<ProductInventory> list = new ArrayList<>();
		// 获取入库扩展信息
		for(InventoryExtInfoVO temp : this.inventoryExtInfoVOList){
			ProductInventory productInventory = new ProductInventory();
			// 入库进价
			productInventory.setStoragePrice(temp.getStoragePrice());
			// 变动数量
			productInventory.setChangeNum(temp.getChangeNum());
			// 库存量
			productInventory.setStorageNum(temp.getStorageNum());
			// 关联商品id
			productInventory.setProduct(temp.getProduct().toDTO());

			// 单据编号
			productInventory.setCode(inventoryBaseInfoVO.getCode());
			// 操作门店
			productInventory.setOperDept(inventoryBaseInfoVO.getOperDept().toDTO());
			// 操作人员
			productInventory.setOperUser(inventoryBaseInfoVO.getOperUser().toDTO());
			// 订货方式
			productInventory.setOrderWayDict(inventoryBaseInfoVO.getOrderWayDict().toDTO());
			// 订货方
			productInventory.setOrderCompanyDict(inventoryBaseInfoVO.getOrderCompanyDict().toDTO());
			// 入库时间
			productInventory.setStorageDate(inventoryBaseInfoVO.getStorageDate());

			productInventory.setId(0l);

			productInventory.setTeamId(inventoryBaseInfoVO.getTeamId());

			list.add(productInventory);
		}
		return list;
	}
}
