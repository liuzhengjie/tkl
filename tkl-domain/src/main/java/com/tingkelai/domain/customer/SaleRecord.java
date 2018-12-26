package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
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

    /**
     * 单据编号
     * @return code
     **/
    @TableField("code")
    private String code = null;

    /**
     * 销售时间
     * @return saleDate
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("sale_date")
    private Date saleDate = null;

    /**
     * 关联部门
     **/
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    /**
     * 关联人员
     **/
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    /**
     * 销售来源
     **/
    @TableField(value = "dict_channel_id", el = "channelDict.id")
    private DictItem channelDict = null;

    /**
     * 预约标识
     **/
    @TableField("order_flag")
    private String orderFlag = null;

    /**
     * 原价
     */
    @TableField("original_price")
    private Double originalPrice;

    /**
     * 折扣
     */
    @TableField("discount")
    private String discount;

    /**
     * 实际价格
     */
    @TableField("real_price")
    private Double realPrice;

    /**
     * 状态
     */
    @TableField(value = "dict_state_id", el = "stateDict")
    private DictItem stateDict;

    /**
     * 关联客户
     */
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

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

    public DictItem getChannelDict() {
        if(channelDict == null){
            channelDict = new DictItem();
        }
        return channelDict;
    }

    public void setChannelDict(DictItem channelDict) {
        this.channelDict = channelDict;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
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

