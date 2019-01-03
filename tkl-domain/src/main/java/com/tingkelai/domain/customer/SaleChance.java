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
 * 销售机会
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:42:19
 * @version 1.0
 */
@TableName("tkl_customer_sale_chance")
@Mapper
public class SaleChance  extends DataEntity<Long> {

    /**
     * 关联公司id
     */
    @TableField("team_id")
    private Long teamId;

    /**
     * 销售机会名称
     **/
    @TableField("name")
    private String name;

    /**
     * 关联部门（门店）
     **/
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept;


    /**
     * 关联用户（服务人员）
     **/
    @TableField(value = "user_id", el = "user.id")
    private User user;


    /**
     * 发现时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("discover_date")
    private Date discoverDate;

    /**
     * 预计时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("plan_sale_date")
    private Date planSaleDate;

    /**
     * 预计消息额
     **/
    @TableField("plan_sale_money")
    private String planSaleMoney;

    /**
     * 下次联系日期
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("next_contact_date")
    private Date nextContactDate;

    /**
     * 预约计划标识
     **/
    @TableField("order_flag")
    private String orderFlag;

    /**
     * 关联客户
     */
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer;

    @TableField(exist = false)
    private FollowRecord followRecord;

    public FollowRecord getFollowRecord() {
        if(followRecord == null){
            followRecord = new FollowRecord();
        }
        return followRecord;
    }

    public void setFollowRecord(FollowRecord followRecord) {
        this.followRecord = followRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public Date getDiscoverDate() {
        return discoverDate;
    }

    public void setDiscoverDate(Date discoverDate) {
        this.discoverDate = discoverDate;
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

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Date getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(Date nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public Date getPlanSaleDate() {
        return planSaleDate;
    }

    public void setPlanSaleDate(Date planSaleDate) {
        this.planSaleDate = planSaleDate;
    }

    public String getPlanSaleMoney() {
        return planSaleMoney;
    }

    public void setPlanSaleMoney(String planSaleMoney) {
        this.planSaleMoney = planSaleMoney;
    }
}
