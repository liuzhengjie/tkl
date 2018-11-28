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
 * 销售机会
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:42:19
 * @version 1.0
 */
@ApiModel(description = "销售机会")
@TableName("tkl_customer_sale_chance")
@Mapper
public class SaleChance  extends DataEntity<Long> {

    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    @JsonProperty("orderFlag")
    @TableField("order_flag")
    private String orderFlag = null;

    @JsonProperty("discoverDate")
    @TableField("discover_date")
    private String discoverDate = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    @JsonProperty("nextContactDate")
    @TableField("next_contact_date")
    private String nextContactDate = null;

    /**
     * 销售机会名称
     * @return name
     **/
    @ApiModelProperty(value = "销售机会名称")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SaleChance orderFlag(String orderFlag) {
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

    public SaleChance discoverDate(String discoverDate) {
        this.discoverDate = discoverDate;
        return this;
    }

    /**
     * 发现日期
     * @return discoverDate
     **/
    @ApiModelProperty(value = "发现日期")


    public String getDiscoverDate() {
        return discoverDate;
    }

    public void setDiscoverDate(String discoverDate) {
        this.discoverDate = discoverDate;
    }

    public SaleChance dept(Dept dept) {
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

    public SaleChance user(User user) {
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

    public SaleChance customer(Customer customer) {
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

    public SaleChance nextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
        return this;
    }

    /**
     * 下次联系日期
     * @return nextContactDate
     **/
    @ApiModelProperty(value = "下次联系日期")


    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleChance saleChance = (SaleChance) o;
        return Objects.equals(this.name, saleChance.name) &&
                Objects.equals(this.orderFlag, saleChance.orderFlag) &&
                Objects.equals(this.discoverDate, saleChance.discoverDate) &&
                Objects.equals(this.dept, saleChance.dept) &&
                Objects.equals(this.user, saleChance.user) &&
                Objects.equals(this.customer, saleChance.customer) &&
                Objects.equals(this.nextContactDate, saleChance.nextContactDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orderFlag, discoverDate, dept, user, customer, nextContactDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SaleChance {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    orderFlag: ").append(toIndentedString(orderFlag)).append("\n");
        sb.append("    discoverDate: ").append(toIndentedString(discoverDate)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
        sb.append("    nextContactDate: ").append(toIndentedString(nextContactDate)).append("\n");
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
