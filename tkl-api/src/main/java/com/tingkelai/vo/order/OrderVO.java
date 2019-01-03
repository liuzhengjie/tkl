package com.tingkelai.vo.order;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.order.Order;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.customer.CustomerVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单（账单）记录
 *
 * 2018-11-27 20:03:42
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "订单（账单）记录")
public class OrderVO implements BaseVO<Order, OrderVO>{

    public OrderVO(){

    }

    public OrderVO(Order order){
        setId(order.getId());
        setCode(order.getCode());
        setCustomer(new CustomerVO(order.getCustomer()));
        setDept(new DeptVO(order.getDept()));
        setDiscount(order.getDiscount());
        setOriginalPrice(order.getOriginalPrice());
        setRealPrice(order.getRealPrice());
        setSaleDate(order.getSaleDate());
        setTeamId(order.getTeamId());
        setStateDict(new DictItemVO(order.getStateDict()));
        setUser(new UserVO(order.getUser()));
        setOrderType(order.getOrderType());
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

    @ApiModelProperty(value = "下单时间")
    @JsonProperty("saleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date saleDate = null;

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

    @JsonProperty("orderType")
    @ApiModelProperty("账单（订单）类型:sale-销售账单，service售后服务账单")
    private String orderType;

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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Override
    public Order toDTO() {
        return toDTO(this);
    }

    @Override
    public Order toDTO(OrderVO orderVO) {
        Order order = new Order();
        order.setId(orderVO.getId());
        order.setCode(orderVO.getCode());
        order.setCustomer(orderVO.getCustomer().toDTO());
        order.setDept(orderVO.getDept().toDTO());
        order.setDiscount(orderVO.getDiscount());
        order.setOriginalPrice(orderVO.getOriginalPrice());
        order.setRealPrice(orderVO.getRealPrice());
        order.setSaleDate(orderVO.getSaleDate());
        order.setTeamId(orderVO.getTeamId());
        order.setStateDict(orderVO.getStateDict().toDTO());
        order.setUser(orderVO.getUser().toDTO());
        order.setOrderType(orderVO.getOrderType());
        return order;
    }

    @Override
    public List<Order> toDTO(List<OrderVO> orderVOList) {
        List<Order> orderList = new ArrayList<>();
        for(OrderVO temp : orderVOList){
            orderList.add(temp.toDTO());
        }
        return orderList;
    }

    @Override
    public OrderVO toVO(Order vo) {
        return new OrderVO(vo);
    }

    @Override
    public List<OrderVO> toVO(List<Order> list) {
        List<OrderVO> orderVOList = new ArrayList<>();
        for(Order temp : list){
            orderVOList.add(toVO(temp));
        }
        return orderVOList;
    }
}

