package com.tingkelai.vo.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.customer.CustomerVO;
import com.tingkelai.vo.customer.SaleProductRecordVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:03:42
 * @version 1.0
 */
@ApiModel(description = "销售订单记录")
public class OrderVO{

    public OrderVO(){

    }

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

    @ApiModelProperty(value = "销售时间")
    @JsonProperty("saleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date saleDate = null;

    @ApiModelProperty(value = "销售来源")
    @JsonProperty("channelDict")
    private DictItemVO channelDict = null;

    @ApiModelProperty(value = "预约标识")
    @JsonProperty("orderFlag")
    private String orderFlag = null;

    @JsonProperty("dept")
    @ApiModelProperty("门店")
    private DeptVO dept;

    @JsonProperty("user")
    @ApiModelProperty("服务人员")
    private UserVO user;

    @JsonProperty("customer")
    @ApiModelProperty("关联客户")
    private CustomerVO customer;

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
    private DictItemVO stateDict;


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

    public DictItemVO getChannelDict() {
        if(channelDict == null){
            channelDict = new DictItemVO();
        }
        return channelDict;
    }

    public void setChannelDict(DictItemVO channelDict) {
        this.channelDict = channelDict;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public DeptVO getDept() {
        if(dept == null){
            dept = new DeptVO();
        }
        return dept;
    }

    public void setDept(DeptVO dept) {
        this.dept = dept;
    }

    public UserVO getUser() {
        if(user == null){
            user = new UserVO();
        }
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public CustomerVO getCustomer() {
        if(customer == null){
            customer = new CustomerVO();
        }
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
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

    public DictItemVO getStateDict() {
        if(stateDict == null){
            stateDict = new DictItemVO();
        }
        return stateDict;
    }

    public void setStateDict(DictItemVO stateDict) {
        this.stateDict = stateDict;
    }
}

