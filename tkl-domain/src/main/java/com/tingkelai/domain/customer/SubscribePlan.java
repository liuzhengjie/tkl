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

import java.util.Date;
import java.util.Objects;

/**
 * 客户预约计划
 */
@ApiModel(description = "客户预约计划")
@TableName("tkl_customer_subscribe_plan")
@Mapper
public class SubscribePlan  extends DataEntity<Long> {

    @JsonProperty("planType")
    @TableField("plan_type")
    private String planType = null;

    @JsonProperty("planDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("plan_date")
    private Date planDate = null;

    @JsonProperty("dealWay")
    @TableField("deal_way")
    private String dealWay = null;

    @JsonProperty("dealType")
    @TableField("deal_type")
    private String dealType = null;

    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("theme")
    @TableField("theme")
    private String theme = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 预约类型
     * @return planType
     **/
    @ApiModelProperty(value = "预约类型")


    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public SubscribePlan planDate(Date planDate) {
        this.planDate = planDate;
        return this;
    }

    /**
     * 预约时间
     * @return planDate
     **/
    @ApiModelProperty(value = "预约时间")
    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public SubscribePlan dealWay(String dealWay) {
        this.dealWay = dealWay;
        return this;
    }

    /**
     * 处理方式
     * @return dealWay
     **/
    @ApiModelProperty(value = "处理方式")


    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public SubscribePlan dealType(String dealType) {
        this.dealType = dealType;
        return this;
    }

    /**
     * 处理类型
     * @return dealType
     **/
    @ApiModelProperty(value = "处理类型")


    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public SubscribePlan linkman(LinkMan linkman) {
        this.linkman = linkman;
        return this;
    }

    /**
     * Get linkman
     * @return linkman
     **/
    @ApiModelProperty(value = "")
    public LinkMan getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public SubscribePlan dept(Dept dept) {
        this.dept = dept;
        return this;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public SubscribePlan user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(value = "")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SubscribePlan theme(String theme) {
        this.theme = theme;
        return this;
    }

    /**
     * 主题
     * @return theme
     **/
    @ApiModelProperty(value = "主题")


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public SubscribePlan customer(Customer customer) {
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
        SubscribePlan subscribePlan = (SubscribePlan) o;
        return Objects.equals(this.planType, subscribePlan.planType) &&
                Objects.equals(this.planDate, subscribePlan.planDate) &&
                Objects.equals(this.dealWay, subscribePlan.dealWay) &&
                Objects.equals(this.dealType, subscribePlan.dealType) &&
                Objects.equals(this.linkman, subscribePlan.linkman) &&
                Objects.equals(this.dept, subscribePlan.dept) &&
                Objects.equals(this.user, subscribePlan.user) &&
                Objects.equals(this.theme, subscribePlan.theme) &&
                Objects.equals(this.customer, subscribePlan.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planType, planDate, dealWay, dealType, linkman, dept, user, theme, customer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubscribePlan {\n");

        sb.append("    planType: ").append(toIndentedString(planType)).append("\n");
        sb.append("    planDate: ").append(toIndentedString(planDate)).append("\n");
        sb.append("    dealWay: ").append(toIndentedString(dealWay)).append("\n");
        sb.append("    dealType: ").append(toIndentedString(dealType)).append("\n");
        sb.append("    linkman: ").append(toIndentedString(linkman)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    theme: ").append(toIndentedString(theme)).append("\n");
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

