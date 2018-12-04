package com.tingkelai.vo.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.vo.BaseVO;

public class DictCategoryVO implements BaseVO<DictCategory, DictCategoryVO>{

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 分组名称 */
	@TableField(value = "name")
	private String name;
	/** 备注 */
	@TableField(value = "remarks")
	private String remarks;
	/** 分组编码 */
	@TableField(value = "code")
	private String code;

	/**
	 * 获取 remarks
	 * 
	 * @return: String 备注
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * 设置 remarks
	 * 
	 * @param: remarks
	 *             备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 获取 code
	 * 
	 * @return: String 分组编码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 code
	 * 
	 * @param: code
	 *             分组编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取 id
	 * 
	 * @return: String 主键
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 name
	 * 
	 * @return: String 分组名称
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置 name
	 * 
	 * @param: name
	 *             分组名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 封装成业务需要的对象
	 */
	public DictCategory toDTO(){
		DictCategory dictCategory = new DictCategory();
		dictCategory.setCode(getCode());
		dictCategory.setId(getId());
		dictCategory.setName(getName());
		dictCategory.setRemarks(getRemarks());
		return dictCategory;
	}

	/**
	 * 封装成web需要的对象
	 */
	public DictCategoryVO toVO(DictCategory dictCategory){
		return null;
	}
}
