package com.tingkelai.vo.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.template.Template;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "动态模板主表")
public class TemplateVO implements BaseVO<Template, TemplateVO>{

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "模板id")
	private Long id;

	/** 模板名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "模板名称")
	private String name;

	/** 备注 */
	@JsonProperty("remarks")
	@ApiModelProperty(value = "备注")
	private String remarks;

	/** 模板编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "模板code")
	private String code;

	@JsonProperty("teamId")
	@ApiModelProperty(value = "模板所属公司id")
	private Long teamId;

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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	/**
	 * 封装成业务需要的对象
	 */
	public Template toDTO(){
		return toDTO(this);
	}

	@Override
	public Template toDTO(TemplateVO templateVO) {
		Template template = new Template();
		template.setCode(templateVO.getCode());
		template.setId(templateVO.getId());
		template.setName(templateVO.getName());
		template.setRemarks(templateVO.getRemarks());
		Team team = new Team();
		team.setId(templateVO.getTeamId());
		template.setTeam(team);
		return template;
	}

	@Override
	public List<Template> toDTO(List<TemplateVO> voList) {
		List<Template> list = new ArrayList<>();
		for(TemplateVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	/**
	 * 封装成web需要的对象
	 */
	public TemplateVO toVO(Template template){
		TemplateVO templateVO = new TemplateVO();
		templateVO.setCode(template.getCode());
		templateVO.setId(template.getId());
		templateVO.setName(template.getName());
		templateVO.setRemarks(template.getRemarks());
		templateVO.setTeamId(template.getTeam().getId());
		return templateVO;
	}

	@Override
	public List<TemplateVO> toVO(List<Template> list) {
		List<TemplateVO> resList = new ArrayList<>();
		for(Template temp : list){
			resList.add(toVO(temp));
		}
		return resList;
	}
}
