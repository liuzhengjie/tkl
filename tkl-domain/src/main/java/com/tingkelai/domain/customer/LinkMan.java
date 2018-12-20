package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Objects;

/**
 * 客户联系人
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:35:07
 * @version 1.0
 */
@TableName("tkl_customer_linkman")
@Mapper
public class LinkMan  extends DataEntity<Long> {
    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    @JsonProperty("tel")
    @TableField("tel")
    private String tel = null;

    @JsonProperty("telBackup")
    @TableField("tel_backup")
    private String telBackup = null;

    @JsonProperty("phone")
    @TableField("phone")
    private String phone = null;

    @JsonProperty("email")
    @TableField("email")
    private String email = null;

    @JsonProperty("fax")
    @TableField("fax")
    private String fax = null;

    @JsonProperty("qq")
    @TableField("qq")
    private String qq = null;

    @JsonProperty("area")
    @TableField("area")
    private String area = null;

    @JsonProperty("postcode")
    @TableField("postcode")
    private String postcode = null;

    @JsonProperty("primaryFlag")
    @TableField("primary_flag")
    private String primaryFlag = null;

    @JsonProperty("relative")
    @TableField("relative")
    private String relative = null;

    @JsonProperty("sex")
    @TableField("sex")
    private String sex = null;

    @JsonProperty("provience")
    @TableField("provience")
    private String provience = null;

    @JsonProperty("city")
    @TableField("city")
    private String city = null;

    @JsonProperty("region")
    @TableField("region")
    private String region = null;

    /** 数据所属公司 */
    @TableField("team_id")
    private Long teamId;

    public Customer getCustomer() {
        if(customer == null){
            customer = new Customer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /**
     * 联系人名字
     * @return name
     **/
    @ApiModelProperty(value = "联系人名字")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 联系人电话
     * @return tel
     **/
    @ApiModelProperty(value = "联系人电话")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 联系人备用电话
     * @return telBackup
     **/
    @ApiModelProperty(value = "联系人备用电话")
    public String getTelBackup() {
        return telBackup;
    }

    public void setTelBackup(String telBackup) {
        this.telBackup = telBackup;
    }

    /**
     * 联系人手机
     * @return phone
     **/
    @ApiModelProperty(value = "联系人手机")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 联系人邮箱
     * @return email
     **/
    @ApiModelProperty(value = "联系人邮箱")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 传真
     * @return fax
     **/
    @ApiModelProperty(value = "传真")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * qq
     * @return qq
     **/
    @ApiModelProperty(value = "qq")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 联系人地址
     * @return area
     **/
    @ApiModelProperty(value = "联系人地址")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 邮编
     * @return postcode
     **/
    @ApiModelProperty(value = "邮编")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * 主联系人标识
     * @return primaryFlag
     **/
    @ApiModelProperty(value = "主联系人标识")
    public String getPrimaryFlag() {
        return primaryFlag;
    }

    public void setPrimaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
    }

    /**
     * 与客户关系
     * @return relative
     **/
    @ApiModelProperty(value = "与客户关系")
    public String getRelative() {
        return relative;
    }

    public void setRelative(String relative) {
        this.relative = relative;
    }

    /**
     * 联系人性别
     * @return sex
     **/
    @ApiModelProperty(value = "联系人性别")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 省
     * @return provience
     **/
    @ApiModelProperty(value = "省")
    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }

    /**
     * 市
     * @return city
     **/
    @ApiModelProperty(value = "市")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     * @return region
     **/
    @ApiModelProperty(value = "区")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}