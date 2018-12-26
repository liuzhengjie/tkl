package com.tingkelai.vo.sms;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sms.SmsSendLog;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@ApiModel(description = "短信发送日志")
@SuppressWarnings("serial")
public class SmsSendLogVO  implements BaseVO<SmsSendLog, SmsSendLogVO> {

	public SmsSendLogVO(){

	}

	public SmsSendLogVO(SmsSendLog smsSendLog){
		setBusinessType(smsSendLog.getBusinessType());
		setCode(smsSendLog.getCode());
		setMsg(smsSendLog.getMsg());
		setPhone(smsSendLog.getPhone());
		setResponseDate(smsSendLog.getResponseDate());
		setSendData(smsSendLog.getSendData());
		setSmsId(smsSendLog.getSmsId());
		setStatus(smsSendLog.getStatus());
		setTemplateContent(smsSendLog.getTemplateContent());
		setTemplateId(smsSendLog.getTemplateId());
	}

	/** id */
	@JsonProperty("id")
	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(hidden = true)
	private Long teamId;

	/** 业务类型 */
	@JsonProperty("businessType")
	@ApiModelProperty(value = "业务类型")
	private String businessType;

	/** 联系电话 */
	@JsonProperty("phone")
	@ApiModelProperty(value = "联系电话")
	private String phone;

	/** 模板ID */
	@JsonProperty("templateId")
	@ApiModelProperty(value = "模板ID")
	private Long templateId;

	/** 模板类型 */
	@JsonProperty("templateContent")
	@ApiModelProperty(value = "模板类型")
	private String templateContent;

	/** 发送数据 */
	@JsonProperty("sendData")
	@ApiModelProperty(value = "发送数据")
	private String sendData;

	/** 发送状态 */
	@JsonProperty("status")
	@ApiModelProperty(value = "发送状态")
	private String status; // 0发送中，1成功，-1失败

	/** 发送响应消息ID */
	@JsonProperty("smsId")
	@ApiModelProperty(value = "发送响应消息ID")
	private String smsId;

	/** 返回码 */
	@JsonProperty("code")
	@ApiModelProperty(value = "返回码")
	private String code;

	/** 返回消息 */
	@JsonProperty("msg")
	@ApiModelProperty(value = "返回消息")
	private String msg;

	/** 响应时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@JsonProperty("responseDate")
	@ApiModelProperty(value = "响应时间")
	private Date responseDate;

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getSendData() {
		return sendData;
	}

	public void setSendData(String sendData) {
		this.sendData = sendData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	@Override
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public Long getTeamId() {
		return teamId;
	}

	@Override
	public SmsSendLog toDTO() {
		return toDTO(this);
	}

	@Override
	public SmsSendLog toDTO(SmsSendLogVO smsSendLogVO) {
		SmsSendLog smsSendLog = new SmsSendLog();
		smsSendLog.setBusinessType(smsSendLogVO.getBusinessType());
		smsSendLog.setCode(smsSendLogVO.getCode());
		smsSendLog.setMsg(smsSendLogVO.getMsg());
		smsSendLog.setPhone(smsSendLogVO.getPhone());
		smsSendLog.setResponseDate(smsSendLogVO.getResponseDate());
		smsSendLog.setSendData(smsSendLogVO.getSendData());
		smsSendLog.setSmsId(smsSendLogVO.getSmsId());
		smsSendLog.setStatus(smsSendLogVO.getStatus());
		smsSendLog.setTemplateContent(smsSendLogVO.getTemplateContent());
		smsSendLog.setTemplateId(smsSendLogVO.getTemplateId());
		return smsSendLog;
	}

	@Override
	public List<SmsSendLog> toDTO(List<SmsSendLogVO> voList) {
		List<SmsSendLog> smsSendLogList = new ArrayList<>();
		for(SmsSendLogVO temp : voList){
			smsSendLogList.add(temp.toDTO());
		}
		return smsSendLogList;
	}

	@Override
	public SmsSendLogVO toVO(SmsSendLog smsSendLog) {
		return new SmsSendLogVO(smsSendLog);
	}

	@Override
	public List<SmsSendLogVO> toVO(List<SmsSendLog> list) {
		List<SmsSendLogVO> smsSendLogVOList = new ArrayList<>();
		for(SmsSendLog temp : list){
			smsSendLogVOList.add(toVO(temp));
		}
		return smsSendLogVOList;
	}
}
