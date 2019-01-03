package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * 客户跟进记录
 */
@ApiModel(description = "客户跟进记录")
@TableName("tkl_customer_follow_record")
@Mapper
public class FollowRecord  extends DataEntity<Long> {

    @ApiModelProperty(value = "关联联系人")
    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman;

    @ApiModelProperty(value = "跟进方式")
    @JsonProperty("wayDict")
    @TableField(value = "dict_way_id", el = "wayDict.id")
    private DictItem wayDict;

    @ApiModelProperty(value = "联系时间(跟进时间)")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("contactDate")
    @TableField("contact_date")
    private Date contactDate;

    /** 目前阶段 */
    @JsonProperty("phaseDict")
    @TableField(value = "dict_phase_id", el = "phaseDict.id")
    private DictItem phaseDict;

    @ApiModelProperty(value = "成交概率")
    @TableField("chance_level")
    private String chanceLevel;

    @ApiModelProperty(value = "跟进内容（联系内容）")
    @JsonProperty("context")
    @TableField("context")
    private String context;

    @JsonProperty("saleChance")
    @TableField(value = "sale_chance_id", el = "saleChance.id")
    private SaleChance saleChance;

    @JsonProperty("teamId")
    @TableField(value = "team_id")
    private Long teamId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public DictItem getWayDict() {
        if(wayDict == null){
            wayDict = new DictItem();
        }
        return wayDict;
    }

    public void setWayDict(DictItem wayDict) {
        this.wayDict = wayDict;
    }

    public LinkMan getLinkman() {
        if(linkman == null){
            linkman = new LinkMan();
        }
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public String getChanceLevel() {
        return chanceLevel;
    }

    public void setChanceLevel(String chanceLevel) {
        this.chanceLevel = chanceLevel;
    }

    public SaleChance getSaleChance() {
        if(saleChance == null){
            saleChance = new SaleChance();
        }
        return saleChance;
    }

    public Date getContactDate() {
        return contactDate;
    }

    public void setContactDate(Date contactDate) {
        this.contactDate = contactDate;
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

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setSaleChance(SaleChance saleChance) {
        this.saleChance = saleChance;
    }
}

