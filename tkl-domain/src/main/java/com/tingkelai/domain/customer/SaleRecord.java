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
@TableName("tkl_customer_sale_record")
@Mapper
public class SaleRecord  extends DataEntity<Long> {

    @TableField("team_id")
    private Long teamId;

    @TableField("code")
    private String code = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("sale_date")
    private Date saleDate = null;

    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("channel")
    private String channel = null;

    @TableField("order_flag")
    private String orderFlag = null;

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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}

