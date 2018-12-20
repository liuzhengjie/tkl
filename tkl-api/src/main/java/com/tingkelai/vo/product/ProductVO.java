package com.tingkelai.vo.product;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品相关
 */
@ApiModel(description = "商品vo")
@SuppressWarnings("serial")
public class ProductVO implements BaseVO<Product, ProductVO> {

	public ProductVO(){}

	public ProductVO(Product vo){
		setBrandId(vo.getBrandDict().getId());
		setBrandDict(new DictItemVO(vo.getBrandDict()));
		setCode(vo.getCode());
		setId(vo.getId());
		setMaxNum(vo.getMaxNum());
		setMinNum(vo.getMinNum());
		setName(vo.getName());
		setPrice(vo.getPrice());
		setSeriesId(vo.getSeriesDict().getId());
		setSeriesDict(new DictItemVO(vo.getSeriesDict()));
		setSupplierId(vo.getSupplierDict().getId());
		setSupplierDict(new DictItemVO(vo.getSupplierDict()));
		setTypeDict(new ProductTypeVO(vo.getTypeDict()));
		setUnit(vo.getUnit());
		setTotalNum(vo.getTotalNum());
		setTypeId(vo.getTypeDict().getId());
		setRemarks(vo.getRemarks());
	}

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	/** 商品名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "商品名称")
	private String name;

	/** 商品编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "商品编码")
	private String code;

	/** 计量单位 */
	@JsonProperty("unit")
	@ApiModelProperty(value = "计量单位")
	private String unit;

	/** 商品类型id */
	@JsonProperty("typeId")
	@ApiModelProperty(value = "商品类型id ")
	private Long typeId;

	@JsonProperty("typeDict")
	@ApiModelProperty(value = "商品类型")
	private ProductTypeVO typeDict;

	/** 商品品牌id */
	@JsonProperty("brandId")
	@ApiModelProperty(value = "商品品牌id")
	private Long brandId;

	@JsonProperty("brandDict")
	@ApiModelProperty(value = "商品品牌")
	private DictItemVO brandDict;

	/** 商品系列id */
	@JsonProperty("seriesId")
	@ApiModelProperty(value = "商品系列id ")
	private Long seriesId;

	@JsonProperty("seriesDict")
	@ApiModelProperty(value = "商品系列")
	private DictItemVO seriesDict;

	/** 供应商id */
	@JsonProperty("supplierId")
	@ApiModelProperty(value = "供应商id")
	private Long supplierId;

	@JsonProperty("supplierDict")
	@ApiModelProperty(value = "供应商")
	private DictItemVO supplierDict;

	/** 单价 */
	@JsonProperty("price")
	@ApiModelProperty(value = "单价")
	private Double price;

	/** 库存上限 */
	@JsonProperty("maxNum")
	@ApiModelProperty(value = "库存上限")
	private Integer maxNum;

	/** 库存下限 */
	@JsonProperty("minNum")
	@ApiModelProperty(value = "库存下限")
	private Integer minNum;

	/** 总库存 */
	@JsonProperty("totalNum")
	@ApiModelProperty(value = "总库存")
	private Integer totalNum;

	@ApiModelProperty(hidden = true)
	private Long teamId;

	@JsonProperty("remarks")
	@ApiModelProperty(value = "备注")
	private String remarks;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public Long getTeamId() {
		return this.teamId;
	}

	@Override
	public Product toDTO() {
		return toDTO(this);
	}

	@Override
	public Product toDTO(ProductVO productVO) {
		Product product = new Product();
//		product.setBrandDict(productVO.getBrandDict());
		product.setCode(productVO.getCode());
		product.setId(productVO.getId());
		product.setMaxNum(productVO.getMaxNum());
		product.setMinNum(productVO.getMinNum());
		product.setName(productVO.getName());
		product.setPrice(productVO.getPrice());
//		product.setSeriesId(productVO.getSeriesId());
//		product.setSupplierId(productVO.getSupplierId());
		product.setUnit(productVO.getUnit());
		product.setTotalNum(productVO.getTotalNum());
//		product.setTypeId(productVO.getTypeId());
		product.setTeamId(productVO.getTeamId());
		return product;
	}

	@Override
	public List<Product> toDTO(List<ProductVO> voList) {
		List<Product> list = new ArrayList<>();
		for(ProductVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	@Override
	public ProductVO toVO(Product vo) {
		return new ProductVO(vo);
	}

	@Override
	public List<ProductVO> toVO(List<Product> list) {
		List<ProductVO> resList = new ArrayList<>();
		for(Product temp : list){
			resList.add(toVO(temp));
		}
		return resList;
	}

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

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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

	public ProductTypeVO getTypeDict() {
		return typeDict;
	}

	public void setTypeDict(ProductTypeVO typeDict) {
		this.typeDict = typeDict;
	}

	public DictItemVO getBrandDict() {
		return brandDict;
	}

	public void setBrandDict(DictItemVO brandDict) {
		this.brandDict = brandDict;
	}

	public DictItemVO getSeriesDict() {
		return seriesDict;
	}

	public void setSeriesDict(DictItemVO seriesDict) {
		this.seriesDict = seriesDict;
	}

	public DictItemVO getSupplierDict() {
		return supplierDict;
	}

	public void setSupplierDict(DictItemVO supplierDict) {
		this.supplierDict = supplierDict;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
