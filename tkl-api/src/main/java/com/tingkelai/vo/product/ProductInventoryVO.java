package com.tingkelai.vo.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductInventory;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品库存记录（出库入库）
 */
@TableName("tkl_product_inventory")
@SuppressWarnings("serial")
public class ProductInventoryVO implements BaseVO<ProductInventory, ProductInventoryVO> {

	public ProductInventoryVO(){

	}

	public ProductInventoryVO(ProductInventory productInventory){
		setChangeNum(productInventory.getChangeNum());
		setCode(productInventory.getCode());
		setId(productInventory.getId());
		setStorageDate(productInventory.getStorageDate());
		setStorageNum(productInventory.getStorageNum());
		setStoragePrice(productInventory.getStoragePrice());
		setTeamId(productInventory.getTeamId());
		//关联商品
		setProduct(new ProductVO(productInventory.getProduct()));
		// 操作部门
		setOperDept(new DeptVO(productInventory.getOperDept()));
		// 操作人员
		setOperUser(new UserVO(productInventory.getOperUser()));
		// 订货方
		setOrderCompanyDict(new DictItemVO(productInventory.getOrderCompanyDict()));
		// 订货方式
		setOrderWayDict(new DictItemVO(productInventory.getOrderWayDict()));
		// 发生金额
		if(getStoragePrice() != null && getChangeNum() != null){
			setPayPrice(getChangeNum() * getStoragePrice());
		}
		// 原始数量
		if(getChangeNum() != null && getStorageNum() != null){
			setOriginNum(getStorageNum() - getChangeNum());
		}
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

	/** 发生金额 */
	@JsonProperty("payPrice")
	@ApiModelProperty(value = "发生金额")
	private Double payPrice;

	/** 原始数量 */
	@JsonProperty("originNum")
	@ApiModelProperty(value = "原始数量")
	private Integer originNum;

	/** 关联商品 */
	@JsonProperty("product")
	@ApiModelProperty(value = "关联商品")
	private ProductVO product;

	/** 数据所属公司 */
	@ApiModelProperty(hidden = true)
	private Long teamId;

	@Override
	public Long getTeamId() {
		return teamId;
	}

	@Override
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
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
		if(operDept == null){
			operDept = new DeptVO();
		}
		return operDept;
	}

	public void setOperDept(DeptVO operDept) {
		this.operDept = operDept;
	}

	public UserVO getOperUser() {
		if(operUser == null){
			operUser = new UserVO();
		}
		return operUser;
	}

	public void setOperUser(UserVO operUser) {
		this.operUser = operUser;
	}

	public DictItemVO getOrderWayDict() {
		if(orderWayDict == null){
			orderWayDict = new DictItemVO();
		}
		return orderWayDict;
	}

	public void setOrderWayDict(DictItemVO orderWayDict) {
		this.orderWayDict = orderWayDict;
	}

	public DictItemVO getOrderCompanyDict() {
		if(orderCompanyDict == null){
			orderCompanyDict = new DictItemVO();
		}
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
		if(product == null){
			product = new ProductVO();
		}
		return product;
	}

	public void setProduct(ProductVO product) {
		this.product = product;
	}

	public Double getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(Double payPrice) {
		this.payPrice = payPrice;
	}

	public Integer getOriginNum() {
		return originNum;
	}

	public void setOriginNum(Integer originNum) {
		this.originNum = originNum;
	}

	@Override
	public ProductInventory toDTO() {
		return toDTO(this);
	}

	@Override
	public ProductInventory toDTO(ProductInventoryVO productInventoryVO) {
		ProductInventory productInventory = new ProductInventory();
		productInventory.setChangeNum(productInventoryVO.getChangeNum());
		productInventory.setCode(productInventoryVO.getCode());
		productInventory.setId(productInventoryVO.getId());
		productInventory.setStorageDate(productInventoryVO.getStorageDate());
		productInventory.setStorageNum(productInventoryVO.getStorageNum());
		productInventory.setStoragePrice(productInventoryVO.getStoragePrice());
		productInventory.setTeamId(productInventoryVO.getTeamId());
		//关联商品
		productInventory.setProduct(productInventoryVO.getProduct().toDTO());
		// 操作部门
		productInventory.setOperDept(productInventoryVO.getOperDept().toDTO());
		// 操作人员
		productInventory.setOperUser(productInventoryVO.getOperUser().toDTO());
		// 订货方
		productInventory.setOrderCompanyDict(productInventoryVO.getOrderCompanyDict().toDTO());
		// 订货方式
		productInventory.setOrderWayDict(productInventoryVO.getOrderWayDict().toDTO());
		return productInventory;
	}

	@Override
	public List<ProductInventory> toDTO(List<ProductInventoryVO> list) {
		List<ProductInventory> productInventoryList = new ArrayList<>();
		for(ProductInventoryVO temp : list){
			productInventoryList.add(toDTO(temp));
		}
		return productInventoryList;
	}

	@Override
	public ProductInventoryVO toVO(ProductInventory productInventory) {
		return new ProductInventoryVO(productInventory);
	}

	@Override
	public List<ProductInventoryVO> toVO(List<ProductInventory> list) {
		List<ProductInventoryVO> productInventoryVOList = new ArrayList<>();
		for(ProductInventory temp : list){
			productInventoryVOList.add(toVO(temp));
		}
		return productInventoryVOList;
	}

}
