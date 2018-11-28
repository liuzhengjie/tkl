package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Objects;

/**
 * 客户联系记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:36:51
 * @version 1.0
 */
@ApiModel(description = "客户联系记录")
@TableName("tkl_customer_contact_record")
@Mapper
public class ContactRecord  extends DataEntity<Long> {

    @JsonProperty("type")
    @TableField("type")
    private String type = null;

    @JsonProperty("way")
    @TableField("way")
    private String way = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("contactDate")
    @TableField("contact_date")
    private String contactDate = null;

    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("nextContactDate")
    @TableField("next_contact_date")
    private String nextContactDate = null;

    @JsonProperty("orderFlag")
    @TableField("order_flag")
    private String orderFlag = null;

    @JsonProperty("context")
    @TableField("context")
    private String context = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 联系类别
     * @return type
     **/
    @ApiModelProperty(value = "联系类别")


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ContactRecord way(String way) {
        this.way = way;
        return this;
    }

    /**
     * 联系方式
     * @return way
     **/
    @ApiModelProperty(value = "联系方式")


    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public ContactRecord contactDate(String contactDate) {
        this.contactDate = contactDate;
        return this;
    }

    /**
     * 联系时间
     * @return contactDate
     **/
    @ApiModelProperty(value = "联系时间")


    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public ContactRecord linkman(LinkMan linkman) {
        this.linkman = linkman;
        return this;
    }

    /**
     * Get linkman
     * @return linkman
     **/
    @ApiModelProperty(value = "联系人")
    public LinkMan getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public ContactRecord dept(Dept dept) {
        this.dept = dept;
        return this;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "我方中心")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public ContactRecord user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(value = "我方用户")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ContactRecord nextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
        return this;
    }

    /**
     * 下次联系时间
     * @return nextContactDate
     **/
    @ApiModelProperty(value = "下次联系时间")


    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public ContactRecord orderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
        return this;
    }

    /**
     * 预约计划标识
     * @return orderFlag
     **/
    @ApiModelProperty(value = "预约计划标识")


    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public ContactRecord context(String context) {
        this.context = context;
        return this;
    }

    /**
     * 联系内容
     * @return context
     **/
    @ApiModelProperty(value = "联系内容")


    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public ContactRecord customer(Customer customer) {
        this.customer = customer;
        return this;
    }

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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ContactRecord contactRecord = (ContactRecord) o;
        return Objects.equals(this.type, contactRecord.type) &&
                Objects.equals(this.way, contactRecord.way) &&
                Objects.equals(this.contactDate, contactRecord.contactDate) &&
                Objects.equals(this.linkman, contactRecord.linkman) &&
                Objects.equals(this.dept, contactRecord.dept) &&
                Objects.equals(this.user, contactRecord.user) &&
                Objects.equals(this.nextContactDate, contactRecord.nextContactDate) &&
                Objects.equals(this.orderFlag, contactRecord.orderFlag) &&
                Objects.equals(this.context, contactRecord.context) &&
                Objects.equals(this.customer, contactRecord.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, way, contactDate, linkman, dept, user, nextContactDate, orderFlag, context, customer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContactRecord {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    way: ").append(toIndentedString(way)).append("\n");
        sb.append("    contactDate: ").append(toIndentedString(contactDate)).append("\n");
        sb.append("    linkman: ").append(toIndentedString(linkman)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    nextContactDate: ").append(toIndentedString(nextContactDate)).append("\n");
        sb.append("    orderFlag: ").append(toIndentedString(orderFlag)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
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