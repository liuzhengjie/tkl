package com.tingkelai.domain.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Team;

/**
 * 商品分类（树形菜单）
 *
 * 2018-12-17 10:41:11
 * @author liuzhengjie
 * @version 1.0
 */
@TableName("tkl_product_type")
@SuppressWarnings("serial")
public class ProductType extends DataEntity<Long> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;

	/** 产品分类名称 */
	@TableField(value = "name")
	private String name;

	/** 产品分类编码 */
	@TableField(value = "code")
	private String code;

	/** 父级 */
	@TableField(value = "parent_id", el = "parent.id")
	private ProductType parent;

	/** 所属公司 */
	@TableField(value = "team_id", el = "team.id")
	private Team team;

	/**
	 * 获取 code
	 * 
	 * @return: String
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 code
	 * 
	 * @param: code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取 id
	 * 
	 * @return: String 主键
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取 name
	 * 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置 name
	 * 
	 * @param: name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam() {
		if(team == null){
			team = new Team();
		}
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public ProductType getParent() {
		if(parent == null){
			parent = new ProductType();
		}
		return parent;
	}

	public void setParent(ProductType parent) {
		this.parent = parent;
	}
}
