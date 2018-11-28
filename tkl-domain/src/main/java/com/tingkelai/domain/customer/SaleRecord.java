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
 * 销售记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:03:42
 * @version 1.0
 */
@ApiModel(description = "销售记录")
@TableName("tkl_customer_sale_record")
@Mapper
public class SaleRecord  extends DataEntity<Long> {
    @JsonProperty("code")
    @TableField("code")
    private String code = null;

    @JsonProperty("saleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("sale_date")
    private Date saleDate = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("channel")
    @TableField("channel")
    private String channel = null;

    @JsonProperty("orderFlag")
    @TableField("order_flag")
    private String orderFlag = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 单据编号
     * @return code
     **/
    @ApiModelProperty(value = "单据编号")


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public SaleRecord saleDate(Date saleDate) {
        this.saleDate = saleDate;
        return this;
    }

    /**
     * 销售时间
     * @return saleDate
     **/
    @ApiModelProperty(value = "销售时间")
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public SaleRecord dept(Dept dept) {
        this.dept = dept;
        return this;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "部门")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public SaleRecord user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(value = "用户")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SaleRecord channel(String channel) {
        this.channel = channel;
        return this;
    }

    /**
     * 销售来源
     * @return channel
     **/
    @ApiModelProperty(value = "销售来源")


    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public SaleRecord orderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
        return this;
    }

    /**
     * 预约标识
     * @return orderFlag
     **/
    @ApiModelProperty(value = "预约标识")


    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public SaleRecord customer(Customer customer) {
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
        SaleRecord saleRecord = (SaleRecord) o;
        return Objects.equals(this.code, saleRecord.code) &&
                Objects.equals(this.saleDate, saleRecord.saleDate) &&
                Objects.equals(this.dept, saleRecord.dept) &&
                Objects.equals(this.user, saleRecord.user) &&
                Objects.equals(this.channel, saleRecord.channel) &&
                Objects.equals(this.orderFlag, saleRecord.orderFlag) &&
                Objects.equals(this.customer, saleRecord.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, saleDate, dept, user, channel, orderFlag, customer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SaleRecord {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    saleDate: ").append(toIndentedString(saleDate)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
        sb.append("    orderFlag: ").append(toIndentedString(orderFlag)).append("\n");
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

