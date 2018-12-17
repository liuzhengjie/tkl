package com.tingkelai.vo.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.template.TemplateField;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "动态模板字段主表")
public class TemplateFieldVO implements BaseVO<TemplateField, TemplateFieldVO>{

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "模板字段id")
	private Long id;

	/** 模板字段名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "模板字段名称")
	private String name;

	/** 备注 */
	@JsonProperty("remarks")
	@ApiModelProperty(value = "备注")
	private String remarks;

	/** 字段模板编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "字段模板编码")
	private String code;

	@JsonProperty("templateId")
	@ApiModelProperty(value = "关联模板字段id")
	private Long templateId;

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

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	/**
	 * 封装成业务需要的对象
	 */
	public TemplateField toDTO(){
		return toDTO(this);
	}

	@Override
	public TemplateField toDTO(TemplateFieldVO templateFieldVO) {
		TemplateField templateField = new TemplateField();
		templateField.setCode(templateFieldVO.getCode());
		templateField.setId(templateFieldVO.getId());
		templateField.setName(templateFieldVO.getName());
		templateField.setRemarks(templateFieldVO.getRemarks());
		return templateField;
	}

	@Override
	public List<TemplateField> toDTO(List<TemplateFieldVO> voList) {
		List<TemplateField> list = new ArrayList<>();
		for(TemplateFieldVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	/**
	 * 封装成web需要的对象
	 */
	public TemplateFieldVO toVO(TemplateField templateField){
		TemplateFieldVO dictCategoryVO = new TemplateFieldVO();
		dictCategoryVO.setCode(templateField.getCode());
		dictCategoryVO.setId(templateField.getId());
		dictCategoryVO.setName(templateField.getName());
		dictCategoryVO.setRemarks(templateField.getRemarks());
		dictCategoryVO.setTemplateId(templateField.getTemplate().getId());
		return dictCategoryVO;
	}

	@Override
	public List<TemplateFieldVO> toVO(List<TemplateField> list) {
		List<TemplateFieldVO> resList = new ArrayList<>();
		for(TemplateField temp : list){
			resList.add(toVO(temp));
		}
		return resList;
	}
}
