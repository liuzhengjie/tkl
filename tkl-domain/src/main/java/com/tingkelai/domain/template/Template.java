package com.tingkelai.domain.template;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Team;

/**
 * 动态模板
 *
 * 2018-12-17 10:41:11
 * @author liuzhengjie
 * @version 1.0
 */
@TableName("tkl_template")
@SuppressWarnings("serial")
public class Template extends DataEntity<Long> {

	/** 主键 */
	@TableId(value = "id", type = IdType.UUID)
	private Long id;

	/** 模板名称 */
	@TableField(value = "name")
	private String name;

	/** 模板编码 */
	@TableField(value = "code")
	private String code;

	/** 所属公司 */
	@TableField(value = "team_id", el = "team.id")
	private Team team = null;

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
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}
