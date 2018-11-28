package com.tingkelai.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tingkelai.constant.DomainConstant;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Map;

/**
 * 数据Entity类
 *
 * @author liuzhengjie
 * @date 2018-11-23 17:16:50
 * @version 1.0
 * @param <ID>
 *            主键类型
 */
public abstract class DataEntity<ID> extends AbstractEntity<ID> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id",type= IdType.AUTO)
	protected ID id; //id

	@Version
	@TableField("version")
	protected Integer version; //版本

	@TableField("remarks")
	protected String remarks; // 备注

	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	protected User createBy; // 创建者

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	protected Date createDate; // 创建日期

	@TableField(value = "update_by", el = "updateBy.id", fill = FieldFill.UPDATE)
	protected User updateBy; // 更新者

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	protected Date updateDate; // 更新日期

	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	protected String delFlag = "0"; // 删除标记（0：正常；1：删除 ）

	public DataEntity() {
		super();
		this.delFlag = DomainConstant.DEL_FLAG_NORMAL;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@ApiModelProperty(value = "id")
	public ID getId(){
		return this.id;
	}

	public void setId(ID id){
		this.id = id;
	}

	@ApiModelProperty(value = "创建人")
	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}

	@ApiModelProperty(value = "创建时间")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ApiModelProperty(value = "修改人")
	public User getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	@ApiModelProperty(value = "修改时间")
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@ApiModelProperty(value = "删除标识")
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@ApiModelProperty(value = "备注信息")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
