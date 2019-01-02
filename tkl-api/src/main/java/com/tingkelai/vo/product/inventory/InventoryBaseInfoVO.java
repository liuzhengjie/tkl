package com.tingkelai.vo.product.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 商品出入库基本信息vo
 */
@ApiModel(description = "商品出入库基本信息vo")
public class InventoryBaseInfoVO{

	public InventoryBaseInfoVO(){

	}

	public InventoryBaseInfoVO(ProductInventory productInventory){

	}

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	/** 单据编号 */
	@JsonProperty("code")
	@ApiModelProperty(value = "单据编号")
	private String code;

	/** 操作门店 */
	@JsonProperty("operDept")
	@ApiModelProperty(value = "操作门店")
	private DeptVO operDept;

	/** 操作人员 */
	@JsonProperty("operUser")
	@ApiModelProperty(value = "操作人员")
	private UserVO operUser;

	/** 订货方式 */
	@JsonProperty("orderWayDict")
	@ApiModelProperty(value = "订货方式")
	private DictItemVO orderWayDict;

	/** 订货方 */
	@JsonProperty("orderCompanyDict")
	@ApiModelProperty(value = "订货方")
	private DictItemVO orderCompanyDict;

	/** 入库时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty("storageDate")
	@ApiModelProperty(value = "入库时间")
	private Date storageDate;

	/** 数据所属公司 */
	@ApiModelProperty(hidden = true)
	private Long teamId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public DeptVO getOperDept() {
		return operDept;
	}

	public void setOperDept(DeptVO operDept) {
		this.operDept = operDept;
	}

	public UserVO getOperUser() {
		return operUser;
	}

	public void setOperUser(UserVO operUser) {
		this.operUser = operUser;
	}

	public DictItemVO getOrderWayDict() {
		return orderWayDict;
	}

	public void setOrderWayDict(DictItemVO orderWayDict) {
		this.orderWayDict = orderWayDict;
	}

	public DictItemVO getOrderCompanyDict() {
		return orderCompanyDict;
	}

	public void setOrderCompanyDict(DictItemVO orderCompanyDict) {
		this.orderCompanyDict = orderCompanyDict;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public void setStorageDate(Date storageDate) {
		this.storageDate = storageDate;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
}
