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
     * 预约计划标识
     **/
    @TableField("order_flag")
    private String orderFlag;

    /**
     * 最后发现时间
     */
    @TableField("discover_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date discoverDate;

    /**
     * 关联部门
     **/
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept;


    /**
     * 关联用户
     **/
    @TableField(value = "user_id", el = "user.id")
    private User user;

    /**
     * 关联客户
     */
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer;

    /**
     * 发现日期
     **/
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("next_contact_date")
    private Date nextContactDate;

    /** 关联联系人 */
    @TableField(value = "linkman_id", el = "linkMan.id")
    private LinkMan linkMan;

    /** 目前阶段 */
    @TableField(value = "dict_phase_id", el = "phaseDict.id")
    private DictItem phaseDict;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("last_follow_date")
    private Date lastFollowFate;

    @TableField("content")
    private String content;

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

    public LinkMan getLinkMan() {
        if(linkMan == null){
            linkMan = new LinkMan();
        }
        return linkMan;
    }

    public void setLinkMan(LinkMan linkMan) {
        this.linkMan = linkMan;
    }

    public DictItem getPhaseDict() {
        if(phaseDict == null){
            phaseDict = new DictItem();
        }
        return phaseDict;
    }

    public void setPhaseDict(DictItem phaseDict) {
        this.phaseDict = phaseDict;
    }

    public Date getLastFollowFate() {
        return lastFollowFate;
    }

    public void setLastFollowFate(Date lastFollowFate) {
        this.lastFollowFate = lastFollowFate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
