package com.tingkelai.domain.sms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tingkelai.domain.entity.DataEntity;

import java.util.Date;

/**
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@TableName("tkl_sms_send_log")
@SuppressWarnings("serial")
public class SmsSendLog extends DataEntity<Long> {

	/** 业务类型 */
	@TableField("business_type")
	private String businessType;

	/** 联系电话 */
	@TableField("phone")
	private String phone;

	/** 模板ID */
	@TableField("template_id")
	private Long templateId;

	/** 模板类型 */
	@TableField("template_content")
	private String templateContent;

	/** 发送数据 */
	@TableField("send_data")
	private String sendData;

	/** 发送状态 */
	@TableField("status")
	private String status; // 0发送中，1成功，-1失败

	/** 发送响应消息ID */
	@TableField("sms_id")
	private String smsId;

	/** 返回码 */
	@TableField("code")
	private String code;

	/** 返回消息 */
	@TableField("msg")
	private String msg;

	/** 响应时间 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@TableField("response_date")
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
}
