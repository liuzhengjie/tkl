package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * 经手人变更记录
 */
@ApiModel(description = "经手人变更记录")
@TableName("tkl_customer_handler_record")
@Mapper
public class HandlerRecord extends DataEntity<Long> {

    private Long teamId;

    @ApiModelProperty(value = "变更时间")
    @JsonProperty("changeDate")
    @TableField("change_date")
    private Date changeDate;

    @ApiModelProperty(value = "经手部门")
    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept;


    @ApiModelProperty(value = "经手人员")
    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user;

    @ApiModelProperty(value = "变更原因")
    @JsonProperty("reason")
    @TableField("reason")
    private String reason = null;

    @ApiModelProperty(value = "操作人员")
    @JsonProperty("operUser")
    @TableField(value = "oper_user_id", el = "operUser.id")
    private User operUser = null;

    @ApiModelProperty(value = "关联客户")
    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer;

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public User getOperUser() {
        if(operUser == null){
            operUser = new User();
        }
        return operUser;
    }

    public void setOperUser(User operUser) {
        this.operUser = operUser;
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

