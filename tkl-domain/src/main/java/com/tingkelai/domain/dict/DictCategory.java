package com.tingkelai.domain.dict;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingkelai.domain.entity.DataEntity;

@TableName("tkl_dict_category")
@SuppressWarnings("serial")
public class DictCategory extends DataEntity<Long> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;
	/** 分组名称 */
	@TableField(value = "name")
	private String name;
	/** 备注 */
	@TableField(value = "remarks")
	private String remarks;
	/** 分组编码 */
	@TableField(value = "code")
	private String code;

	/** 公司id */
	@TableField(value = "team_id")
	private Long teamId;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

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

}
