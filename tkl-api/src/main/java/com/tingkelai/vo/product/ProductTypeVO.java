package com.tingkelai.vo.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.product.ProductType;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品相关
 */
@ApiModel(description = "商品分类vo")
@SuppressWarnings("serial")
public class ProductTypeVO implements BaseVO<ProductType, ProductTypeVO> {

	public ProductTypeVO(){}

	public ProductTypeVO(ProductType vo){
		setId(vo.getId());
		setCode(vo.getCode());
		setName(vo.getName());
		if(vo.getParent() != null){
			setParentId(vo.getParent().getId());
		}
		setRemarks(vo.getRemarks());
	}

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(hidden = true)
	private Long teamId;

	/** 分组名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "商品分类名称")
	private String name;

	/** 备注 */
	@JsonProperty("remarks")
	@ApiModelProperty(value = "备注")
	private String remarks;

	/** 分组编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "商品分类编码")
	private String code;

	/** 父级id */
	@JsonProperty("parentId")
	@ApiModelProperty(value = "父级id")
	private Long parentId;

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

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
	public ProductType toDTO() {
		return toDTO(this);
	}

	@Override
	public ProductType toDTO(ProductTypeVO productTypeVO) {
		ProductType productType = new ProductType();
		productType.setCode(productTypeVO.getCode());
		productType.setId(productTypeVO.getId());
		productType.setName(productTypeVO.getName());
		//父级
		ProductType parent = new ProductType();
		parent.setId(productTypeVO.getParentId());
		productType.setParent(parent);
		//公司
		Team team = new Team();
		team.setId(teamId);
		productType.setTeam(team);
		System.out.println(productType);
		return productType;
	}

	@Override
	public List<ProductType> toDTO(List<ProductTypeVO> voList) {
		List<ProductType> list = new ArrayList<>();
		for(ProductTypeVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	@Override
	public ProductTypeVO toVO(ProductType vo) {
		return new ProductTypeVO(vo);
	}

	@Override
	public List<ProductTypeVO> toVO(List<ProductType> list) {
		List<ProductTypeVO> resList = new ArrayList<>();
		for(ProductType temp : list){
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
