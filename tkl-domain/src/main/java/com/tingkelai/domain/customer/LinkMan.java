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
@ApiModel(description = "客户联系人")
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

    /**
     * Get customer
     * @return customer
     **/
    @ApiModelProperty(value = "关联客户")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public LinkMan tel(String tel) {
        this.tel = tel;
        return this;
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

    public LinkMan telBackup(String telBackup) {
        this.telBackup = telBackup;
        return this;
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

    public LinkMan phone(String phone) {
        this.phone = phone;
        return this;
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

    public LinkMan email(String email) {
        this.email = email;
        return this;
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

    public LinkMan fax(String fax) {
        this.fax = fax;
        return this;
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

    public LinkMan qq(String qq) {
        this.qq = qq;
        return this;
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

    public LinkMan area(String area) {
        this.area = area;
        return this;
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

    public LinkMan postcode(String postcode) {
        this.postcode = postcode;
        return this;
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

    public LinkMan primaryFlag(String primaryFlag) {
        this.primaryFlag = primaryFlag;
        return this;
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

    public LinkMan relative(String relative) {
        this.relative = relative;
        return this;
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

    public LinkMan sex(String sex) {
        this.sex = sex;
        return this;
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

    public LinkMan provience(String provience) {
        this.provience = provience;
        return this;
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

    public LinkMan city(String city) {
        this.city = city;
        return this;
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

    public LinkMan region(String region) {
        this.region = region;
        return this;
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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinkMan linkMan = (LinkMan) o;
        return Objects.equals(this.customer, linkMan.customer) &&
                Objects.equals(this.name, linkMan.name) &&
                Objects.equals(this.tel, linkMan.tel) &&
                Objects.equals(this.telBackup, linkMan.telBackup) &&
                Objects.equals(this.phone, linkMan.phone) &&
                Objects.equals(this.email, linkMan.email) &&
                Objects.equals(this.fax, linkMan.fax) &&
                Objects.equals(this.qq, linkMan.qq) &&
                Objects.equals(this.area, linkMan.area) &&
                Objects.equals(this.postcode, linkMan.postcode) &&
                Objects.equals(this.primaryFlag, linkMan.primaryFlag) &&
                Objects.equals(this.relative, linkMan.relative) &&
                Objects.equals(this.sex, linkMan.sex) &&
                Objects.equals(this.provience, linkMan.provience) &&
                Objects.equals(this.city, linkMan.city) &&
                Objects.equals(this.region, linkMan.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, name, tel, telBackup, phone, email, fax, qq, area, postcode, primaryFlag, relative, sex, provience, city, region);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkMan {\n");

        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    tel: ").append(toIndentedString(tel)).append("\n");
        sb.append("    telBackup: ").append(toIndentedString(telBackup)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    fax: ").append(toIndentedString(fax)).append("\n");
        sb.append("    qq: ").append(toIndentedString(qq)).append("\n");
        sb.append("    area: ").append(toIndentedString(area)).append("\n");
        sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
        sb.append("    primaryFlag: ").append(toIndentedString(primaryFlag)).append("\n");
        sb.append("    relative: ").append(toIndentedString(relative)).append("\n");
        sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
        sb.append("    provience: ").append(toIndentedString(provience)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}