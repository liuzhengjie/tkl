package com.tingkelai.domain.dict;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingkelai.domain.entity.DataEntity;

@TableName("tkl_dict_item")
@SuppressWarnings("serial")
public class DictItem extends DataEntity<Long> {

	/** 字典项名称 */
	@TableField(value = "name")
	private String name;

	/** 字典项编码 */
	@TableField(value = "code")
	private String code;

	/** 所属字典分类 */
	@TableField(value = "category_id", el = "dictCategory.id")
	private DictCategory dictCategory;

	/** 所属公司 */
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

	public DictCategory getDictCategory() {
		return dictCategory;
	}

	public void setDictCategory(DictCategory dictCategory) {
		this.dictCategory = dictCategory;
	}
}
