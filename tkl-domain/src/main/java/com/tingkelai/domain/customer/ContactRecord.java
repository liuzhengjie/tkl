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

import java.util.Objects;

/**
 * 客户联系记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:36:51
 * @version 1.0
 */
@TableName("tkl_customer_contact_record")
@Mapper
public class ContactRecord  extends DataEntity<Long> {

    @TableField("team_id")
    private Long teamId;

    @TableField("type")
    private String type = null;

    @TableField("way")
    private String way = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("contact_date")
    private String contactDate = null;

    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("next_contact_date")
    private String nextContactDate = null;

    @TableField("order_flag")
    private String orderFlag = null;

    @TableField("context")
    private String context = null;

    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 联系类别
     * @return type
     **/
    @ApiModelProperty(value = "联系类别")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 联系方式
     * @return way
     **/
    @ApiModelProperty(value = "联系方式")
    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    /**
     * 联系时间
     * @return contactDate
     **/
    @ApiModelProperty(value = "联系时间")
    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    /**
     * Get linkman
     * @return linkman
     **/
    @ApiModelProperty(value = "联系人")
    public LinkMan getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "我方中心")
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
    @ApiModelProperty(value = "我方用户")
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
     * 下次联系时间
     * @return nextContactDate
     **/
    @ApiModelProperty(value = "下次联系时间")
    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
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
     * 联系内容
     * @return context
     **/
    @ApiModelProperty(value = "联系内容")
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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