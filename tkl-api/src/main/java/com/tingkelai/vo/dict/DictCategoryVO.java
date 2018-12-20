package com.tingkelai.vo.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class DictCategoryVO implements BaseVO<DictCategory, DictCategoryVO>{

	/** 主键 */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	/** 分组名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "分组名称")
	private String name;

	/** 备注 */
	@JsonProperty("remarks")
	@ApiModelProperty(value = "备注")
	private String remarks;

	/** 分组编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "分组编码")
	private String code;

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

	@Override
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public Long getTeamId() {
		return teamId;
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

	/**
	 * 封装成业务需要的对象
	 */
	public DictCategory toDTO(){
		return toDTO(this);
	}

	@Override
	public DictCategory toDTO(DictCategoryVO dictCategoryVO) {
		DictCategory dictCategory = new DictCategory();
		dictCategory.setCode(dictCategoryVO.getCode());
		dictCategory.setId(dictCategoryVO.getId());
		dictCategory.setName(dictCategoryVO.getName());
		dictCategory.setRemarks(dictCategoryVO.getRemarks());
		dictCategory.setTeamId(dictCategoryVO.getTeamId());
		return dictCategory;
	}

	@Override
	public List<DictCategory> toDTO(List<DictCategoryVO> voList) {
		List<DictCategory> list = new ArrayList<>();
		for(DictCategoryVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	/**
	 * 封装成web需要的对象
	 */
	public DictCategoryVO toVO(DictCategory dictCategory){
		DictCategoryVO dictCategoryVO = new DictCategoryVO();
		dictCategoryVO.setCode(dictCategory.getCode());
		dictCategoryVO.setId(dictCategory.getId());
		dictCategoryVO.setName(dictCategory.getName());
		dictCategoryVO.setRemarks(dictCategory.getRemarks());
		return dictCategoryVO;
	}

	@Override
	public List<DictCategoryVO> toVO(List<DictCategory> list) {
		List<DictCategoryVO> resList = new ArrayList<>();
		for(DictCategory temp : list){
			resList.add(toVO(temp));
		}
		return resList;
	}
}
