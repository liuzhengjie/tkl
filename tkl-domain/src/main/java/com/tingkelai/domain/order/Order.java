package com.tingkelai.domain.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 订单（账单）记录
 *
 * 2018-11-27 20:03:42
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "订单（账单）记录")
public class Order {

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(hidden = true)
    private Long teamId;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getTeamId() {
        return teamId;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @ApiModelProperty(value = "单据编号")
    @JsonProperty("code")
    private String code = null;

    @ApiModelProperty(value = "下单时间")
    @JsonProperty("saleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date saleDate = null;

    @JsonProperty("dept")
    @ApiModelProperty("门店")
    private Dept dept;

    @JsonProperty("user")
    @ApiModelProperty("服务人员")
    private User user;

    @JsonProperty("customer")
    @ApiModelProperty("关联客户")
    private Customer customer;

    @JsonProperty("originalPrice")
    @ApiModelProperty("原价")
    private Double originalPrice;

    @JsonProperty("discount")
    @ApiModelProperty("折扣")
    private String discount;

    @JsonProperty("realPrice")
    @ApiModelProperty("实际价格")
    private Double realPrice;

    @JsonProperty("stateDict")
    @ApiModelProperty("状态")
    private DictItem stateDict;

    @JsonProperty("orderType")
    @ApiModelProperty("账单（订单）类型")
    private String orderType;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
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

    public Customer getCustomer() {
        if(customer == null){
            customer = new Customer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public DictItem getStateDict() {
        if(stateDict == null){
            stateDict = new DictItem();
        }
        return stateDict;
    }

    public void setStateDict(DictItem stateDict) {
        this.stateDict = stateDict;
    }
}

