package com.tingkelai.vo.sms;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sms.SmsTemplate;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@ApiModel(description = "短信模板")
@SuppressWarnings("serial")
public class SmsTemplateVO implements BaseVO<SmsTemplate, SmsTemplateVO> {

	public SmsTemplateVO(){

	}

	public SmsTemplateVO(SmsTemplate smsTemplate){
		setBusinessType(smsTemplate.getBusinessType());
		setCode(smsTemplate.getCode());
		setName(smsTemplate.getCode());
		setTemplateContent(smsTemplate.getTemplateContent());
	}

	/** id */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(hidden = true)
	private Long teamId;

	/** 模版名称 */
	@JsonProperty("name")
	@ApiModelProperty(value = "模版名称")
	private String name;

	/** 模版编码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "模版编码")
	private String code;

	/** 业务类型 */
	@JsonProperty("businessType")
	@ApiModelProperty(value = "业务类型")
	private String businessType;

	/** 模版内容 */
	@JsonProperty("templateContent")
	@ApiModelProperty(value = "模版内容")
	private String templateContent;

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

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public SmsTemplate toDTO() {
		return toDTO(this);
	}

	@Override
	public SmsTemplate toDTO(SmsTemplateVO smsTemplateVO) {
		SmsTemplate smsTemplate = new SmsTemplate();
		smsTemplate.setBusinessType(smsTemplateVO.getBusinessType());
		smsTemplate.setCode(smsTemplateVO.getCode());
		smsTemplate.setName(smsTemplateVO.getCode());
		smsTemplate.setTemplateContent(smsTemplateVO.getTemplateContent());
		return smsTemplate;
	}

	@Override
	public List<SmsTemplate> toDTO(List<SmsTemplateVO> voList) {
		List<SmsTemplate> smsTemplateList = new ArrayList<>();
		for(SmsTemplateVO temp : voList){
			smsTemplateList.add(temp.toDTO());
		}
		return smsTemplateList;
	}

	@Override
	public SmsTemplateVO toVO(SmsTemplate smsTemplate) {
		return new SmsTemplateVO(smsTemplate);
	}

	@Override
	public List<SmsTemplateVO> toVO(List<SmsTemplate> list) {
		List<SmsTemplateVO> smsTemplateVOList = new ArrayList<>();
		for(SmsTemplate temp : list){
			smsTemplateVOList.add(toVO(temp));
		}
		return smsTemplateVOList;
	}
}
