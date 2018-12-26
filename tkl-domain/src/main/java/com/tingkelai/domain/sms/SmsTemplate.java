package com.tingkelai.domain.sms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingkelai.domain.entity.DataEntity;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@TableName("tkl_sms_template")
@SuppressWarnings("serial")
public class SmsTemplate extends DataEntity<Long> {

	/** 模版名称 */
	@TableField("name")
	private String name;

	/** 模版编码 */
	@TableField("code")
	private String code;

	/** 业务类型 */
	@TableField("business_type")
	private String businessType;

	/** 模版内容 */
	@TableField("template_content")
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
}
