package com.tingkelai.domain.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品相关
 */
@TableName("tkl_product")
@SuppressWarnings("serial")
public class Product extends DataEntity<Long> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;

	/** 商品名称 */
	@TableField(value = "name")
	private String name;

	/** 商品编码 */
	@TableField(value = "code")
	private String code;

	/** 计量单位 */
	@TableField(value = "unit")
	private String unit;

	/** 商品类型 */
	@TableField(value = "dict_type_id", el = "typeDict.id")
	private ProductType typeDict;

	/** 商品品牌 */
	@TableField(value = "dict_brand_id", el = "brandDict.id")
	private DictItem brandDict;

	/** 商品系列 */
	@TableField(value = "dict_series_id", el = "seriesDict.id")
	private DictItem seriesDict;

	/** 供应商 */
	@TableField(value = "dict_supplier_id", el = "supplierDict.id")
	private DictItem supplierDict;

	/** 单价 */
	@TableField(value = "price")
	private Double price;

	/** 库存上限 */
	@TableField(value = "max_num")
	private Integer maxNum;

	/** 库存下限 */
	@TableField(value = "min_num")
	private Integer minNum;

	/** 总库存 */
	@TableField(value = "total_num")
	private Integer totalNum;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public Integer getMinNum() {
		return minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public ProductType getTypeDict() {
		if(typeDict == null){
			typeDict = new ProductType();
		}
		return typeDict;
	}

	public void setTypeDict(ProductType typeDict) {
		this.typeDict = typeDict;
	}

	public DictItem getBrandDict() {
		if(brandDict == null){
			brandDict = new DictItem();
		}
		return brandDict;
	}

	public void setBrandDict(DictItem brandDict) {
		this.brandDict = brandDict;
	}

	public DictItem getSeriesDict() {
		if(seriesDict == null){
			seriesDict = new DictItem();
		}
		return seriesDict;
	}

	public void setSeriesDict(DictItem seriesDict) {
		this.seriesDict = seriesDict;
	}

	public DictItem getSupplierDict() {
		if(supplierDict == null){
			supplierDict = new DictItem();
		}
		return supplierDict;
	}

	public void setSupplierDict(DictItem supplierDict) {
		this.supplierDict = supplierDict;
	}
}
