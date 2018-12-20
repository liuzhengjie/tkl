package com.tingkelai.vo.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class DictItemVO implements BaseVO<DictItem, DictItemVO>{

	public DictItemVO(){}

	public DictItemVO(DictItem dictItem){
		setCode(dictItem.getCode());
		setId(dictItem.getId());
		setName(dictItem.getName());
		setRemarks(dictItem.getRemarks());
		if(dictItem.getDictCategory() != null){
			setDictGroupCode(dictItem.getCode());
			setDictGroupId(dictItem.getId());
		}
	}

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

	/** 数据字典项编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "数据字典项编码")
	private String code;

	@JsonProperty("teamId")
	@ApiModelProperty(hidden = true)
	private Long teamId;

	@JsonProperty("dictGroupId")
	@ApiModelProperty(value = "所属分组id")
	private Long dictGroupId;

	@JsonProperty("dictGroupCode")
	@ApiModelProperty(value = "所属分组code")
	private String dictGroupCode;

	public Long getDictGroupId() {
		return dictGroupId;
	}

	public void setDictGroupId(Long dictGroupId) {
		this.dictGroupId = dictGroupId;
	}

	public String getDictGroupCode() {
		return dictGroupCode;
	}

	public void setDictGroupCode(String dictGroupCode) {
		this.dictGroupCode = dictGroupCode;
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

	@Override
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public Long getTeamId() {
		return this.teamId;
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
	public DictItem toDTO(){
		return toDTO(this);
	}

	@Override
	public DictItem toDTO(DictItemVO dictItemVO) {
		DictItem dictItem = new DictItem();
		dictItem.setCode(dictItemVO.getCode());
		dictItem.setId(dictItemVO.getId());
		dictItem.setName(dictItemVO.getName());
		dictItem.setRemarks(dictItemVO.getRemarks());
		dictItem.setTeamId(dictItemVO.getTeamId());

		//设置分组信息
		DictCategory dictCategory = new DictCategory();
		dictCategory.setId(dictItemVO.getDictGroupId());
		dictCategory.setCode(dictItemVO.getDictGroupCode());
		dictItem.setDictCategory(dictCategory);
		return dictItem;
	}

	@Override
	public List<DictItem> toDTO(List<DictItemVO> voList) {
		List<DictItem> list = new ArrayList<>();
		for(DictItemVO temp : voList){
			list.add(temp.toDTO());
		}
		return list;
	}

	/**
	 * 封装成web需要的对象
	 */
	public DictItemVO toVO(DictItem dictItem){
		DictItemVO dictItemVO = new DictItemVO();
		dictItemVO.setCode(dictItem.getCode());
		dictItemVO.setId(dictItem.getId());
		dictItemVO.setName(dictItem.getName());
		dictItemVO.setRemarks(dictItem.getRemarks());
		if(dictItem.getDictCategory() != null){
			dictItemVO.setDictGroupCode(dictItem.getCode());
			dictItemVO.setDictGroupId(dictItem.getId());
		}
		return dictItemVO;
	}

	@Override
	public List<DictItemVO> toVO(List<DictItem> list) {
		List<DictItemVO> resList = new ArrayList<>();
		for(DictItem temp : list){
			resList.add(toVO(temp));
		}
		return resList;
	}
}
