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
@TableName("tkl_customer_sale_chance")
@Mapper
public class SaleChance  extends DataEntity<Long> {

    @TableField("team_id")
    private Long teamId;

    @TableField("name")
    private String name = null;

    @TableField("order_flag")
    private String orderFlag = null;

    @TableField("discover_date")
    private String discoverDate = null;

    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @TableField(value = "user_id", el = "user.id")
    private User user = null;

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

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "部门")
    public Dept getDept() {
        if(dept == null){
            dept = new Dept();
        }
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(value = "用户")
    public User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get customer
     * @return customer
     **/
    @ApiModelProperty(value = "关联客户")
    public Customer getCustomer() {
        if(customer == null){
            customer = new Customer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
