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

    @JsonProperty("teamId")
    @TableField("team_id")
    private Long teamId;

    @ApiModelProperty(value = "预约类型")
    @JsonProperty("planType")
    @TableField("plan_type")
    private String planType = null;

    @ApiModelProperty(value = "预约时间")
    @JsonProperty("planDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("plan_date")
    private Date planDate = null;

    @ApiModelProperty(value = "处理方式")
    @JsonProperty("dealWay")
    @TableField("deal_way")
    private String dealWay = null;

    @ApiModelProperty(value = "处理类型")
    @JsonProperty("dealType")
    @TableField("deal_type")
    private String dealType = null;

    @ApiModelProperty(value = "关联联系人")
    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @ApiModelProperty(value = "关联用户")
    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @ApiModelProperty(value = "关联用户")
    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @ApiModelProperty(value = "主题")
    @JsonProperty("theme")
    @TableField("theme")
    private String theme = null;

    @ApiModelProperty(value = "关联客户")
    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public LinkMan getLinkman() {
        if(linkman == null){
            linkman = new LinkMan();
        }
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public Dept getDept() {
        if(dept == null){
            dept = new Dept();
        }
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


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
}

