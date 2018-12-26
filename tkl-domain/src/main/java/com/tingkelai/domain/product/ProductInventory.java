package com.tingkelai.domain.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;

import java.util.Date;

/**
 * 商品库存记录（出库入库）
 */
@TableName("tkl_product_inventory")
@SuppressWarnings("serial")
public class ProductInventory extends DataEntity<Long> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;

	/** 单据编号 */
	@TableField(value = "code")
	private String code;

	/** 操作门店 */
	@TableField(value = "oper_dept_id", el = "operDept.id")
	private Dept operDept;

	/** 操作人员 */
	@TableField(value = "oper_user_id", el = "operUser.id")
	private User operUser;

	/** 订货方式 */
	@TableField(value = "dict_order_way_id", el = "orderWayDict.id")
	private DictItem orderWayDict;

	/** 订货方 */
	@TableField(value = "dict_order_company_id", el = "orderCompanyDict.id")
	private DictItem orderCompanyDict;

	/** 入库时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@TableField(value = "storage_date")
	private Date storageDate;

	/** 入库进价 */
	@TableField(value = "storage_price")
	private Double storagePrice;

	/** 变动数量 */
	@TableField(value = "change_num")
	private Integer changeNum;

	/** 库存量 */
	@TableField(value = "storage_num")
	private Integer storageNum;

	/** 关联商品 */
	@TableField(value = "product_id", el = "product.id")
	private Product product;

	/** 数据所属公司 */
	@TableField(value = "team_id")
	private Long teamId;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Dept getOperDept() {
		if(operDept == null){
			operDept = new Dept();
		}
		return operDept;
	}

	public void setOperDept(Dept operDept) {
		this.operDept = operDept;
	}

	public User getOperUser() {
		if(operUser == null){
			operUser = new User();
		}
		return operUser;
	}

	public void setOperUser(User operUser) {
		this.operUser = operUser;
	}

	public DictItem getOrderWayDict() {
		if(orderWayDict == null){
			orderWayDict = new DictItem();
		}
		return orderWayDict;
	}

	public void setOrderWayDict(DictItem orderWayDict) {
		this.orderWayDict = orderWayDict;
	}

	public DictItem getOrderCompanyDict() {
		if(orderCompanyDict == null){
			orderCompanyDict = new DictItem();
		}
		return orderCompanyDict;
	}

	public void setOrderCompanyDict(DictItem orderCompanyDict) {
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

	public Product getProduct() {
		if(product == null){
			product = new Product();
		}
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
