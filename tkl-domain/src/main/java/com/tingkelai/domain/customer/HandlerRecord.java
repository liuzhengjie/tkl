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

import java.util.Objects;

/**
 * 经手人变更记录
 */
@ApiModel(description = "经手人变更记录")
@TableName("tkl_customer_handler_record")
@Mapper
public class HandlerRecord extends DataEntity<Long> {

    @JsonProperty("changeDate")
    @TableField("change_date")
    private String changeDate = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("reason")
    @TableField("reason")
    private String reason = null;

    @JsonProperty("operUser")
    @TableField(value = "oper_user_id", el = "operUser.id")
    private User operUser = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 变更时间
     * @return changeDate
     **/
    @ApiModelProperty(value = "变更时间")


    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    public HandlerRecord dept(Dept dept) {
        this.dept = dept;
        return this;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "经手部门")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public HandlerRecord user(User user) {
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

    public HandlerRecord reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * 变更原因
     * @return reason
     **/
    @ApiModelProperty(value = "变更原因")


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public HandlerRecord operUser(User operUser) {
        this.operUser = operUser;
        return this;
    }

    /**
     * Get operUser
     * @return operUser
     **/
    @ApiModelProperty(value = "")
    public User getOperUser() {
        return operUser;
    }

    public void setOperUser(User operUser) {
        this.operUser = operUser;
    }

    public HandlerRecord customer(Customer customer) {
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
        HandlerRecord handlerRecord = (HandlerRecord) o;
        return Objects.equals(this.changeDate, handlerRecord.changeDate) &&
                Objects.equals(this.dept, handlerRecord.dept) &&
                Objects.equals(this.user, handlerRecord.user) &&
                Objects.equals(this.reason, handlerRecord.reason) &&
                Objects.equals(this.operUser, handlerRecord.operUser) &&
                Objects.equals(this.customer, handlerRecord.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changeDate, dept, user, reason, operUser, customer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class HandlerRecord {\n");

        sb.append("    changeDate: ").append(toIndentedString(changeDate)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    operUser: ").append(toIndentedString(operUser)).append("\n");
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

