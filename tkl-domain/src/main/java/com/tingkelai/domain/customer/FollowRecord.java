package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Objects;

/**
 * 客户跟进记录
 */
@ApiModel(description = "客户跟进记录")
@TableName("tkl_customer_follow_record")
@Mapper
public class FollowRecord  extends DataEntity<Long> {
    @JsonProperty("type")
    @TableField("type")
    private String type = null;

    @JsonProperty("way")
    @TableField("way")
    private String way = null;

    @JsonProperty("contactDate")
    @TableField("contact_date")
    private String contactDate = null;

    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @JsonProperty("chanceLevel")
    @TableField("chance_level")
    private String chanceLevel = null;

    @JsonProperty("planSaleMoney")
    @TableField("plan_sale_money")
    private String planSaleMoney = null;

    @JsonProperty("planSaleDate")
    @TableField("plan_sale_date")
    private String planSaleDate = null;

    @JsonProperty("state")
    @TableField("state")
    private String state = null;

    @JsonProperty("context")
    @TableField("context")
    private String context = null;

    @JsonProperty("saleChance")
    @TableField(value = "sale_chance_id", el = "saleChance.id")
    private SaleChance saleChance = null;

    /**
     * 跟进类型
     * @return type
     **/
    @ApiModelProperty(value = "跟进类型")


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FollowRecord way(String way) {
        this.way = way;
        return this;
    }

    /**
     * 跟进方式
     * @return way
     **/
    @ApiModelProperty(value = "跟进方式")


    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public FollowRecord contactDate(String contactDate) {
        this.contactDate = contactDate;
        return this;
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

    public FollowRecord linkman(LinkMan linkman) {
        this.linkman = linkman;
        return this;
    }

    /**
     * Get linkman
     * @return linkman
     **/
    @ApiModelProperty(value = "关联联系人")

    public LinkMan getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public FollowRecord chanceLevel(String chanceLevel) {
        this.chanceLevel = chanceLevel;
        return this;
    }

    /**
     * 成交概率
     * @return chanceLevel
     **/
    @ApiModelProperty(value = "成交概率")


    public String getChanceLevel() {
        return chanceLevel;
    }

    public void setChanceLevel(String chanceLevel) {
        this.chanceLevel = chanceLevel;
    }

    public FollowRecord planSaleMoney(String planSaleMoney) {
        this.planSaleMoney = planSaleMoney;
        return this;
    }

    /**
     * 预计消息额
     * @return planSaleMoney
     **/
    @ApiModelProperty(value = "预计消息额")


    public String getPlanSaleMoney() {
        return planSaleMoney;
    }

    public void setPlanSaleMoney(String planSaleMoney) {
        this.planSaleMoney = planSaleMoney;
    }

    public FollowRecord planSaleDate(String planSaleDate) {
        this.planSaleDate = planSaleDate;
        return this;
    }

    /**
     * 预计销售日期
     * @return planSaleDate
     **/
    @ApiModelProperty(value = "预计销售日期")


    public String getPlanSaleDate() {
        return planSaleDate;
    }

    public void setPlanSaleDate(String planSaleDate) {
        this.planSaleDate = planSaleDate;
    }

    public FollowRecord state(String state) {
        this.state = state;
        return this;
    }

    /**
     * 阶段状态
     * @return state
     **/
    @ApiModelProperty(value = "阶段状态")


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public FollowRecord context(String context) {
        this.context = context;
        return this;
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

    public FollowRecord saleChance(SaleChance saleChance) {
        this.saleChance = saleChance;
        return this;
    }

    /**
     * Get saleChance
     * @return saleChance
     **/
    @ApiModelProperty(value = "")
    public SaleChance getSaleChance() {
        return saleChance;
    }

    public void setSaleChance(SaleChance saleChance) {
        this.saleChance = saleChance;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FollowRecord followRecord = (FollowRecord) o;
        return Objects.equals(this.type, followRecord.type) &&
                Objects.equals(this.way, followRecord.way) &&
                Objects.equals(this.contactDate, followRecord.contactDate) &&
                Objects.equals(this.linkman, followRecord.linkman) &&
                Objects.equals(this.chanceLevel, followRecord.chanceLevel) &&
                Objects.equals(this.planSaleMoney, followRecord.planSaleMoney) &&
                Objects.equals(this.planSaleDate, followRecord.planSaleDate) &&
                Objects.equals(this.state, followRecord.state) &&
                Objects.equals(this.context, followRecord.context) &&
                Objects.equals(this.saleChance, followRecord.saleChance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, way, contactDate, linkman, chanceLevel, planSaleMoney, planSaleDate, state, context, saleChance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FollowRecord {\n");

        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    way: ").append(toIndentedString(way)).append("\n");
        sb.append("    contactDate: ").append(toIndentedString(contactDate)).append("\n");
        sb.append("    linkman: ").append(toIndentedString(linkman)).append("\n");
        sb.append("    chanceLevel: ").append(toIndentedString(chanceLevel)).append("\n");
        sb.append("    planSaleMoney: ").append(toIndentedString(planSaleMoney)).append("\n");
        sb.append("    planSaleDate: ").append(toIndentedString(planSaleDate)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    context: ").append(toIndentedString(context)).append("\n");
        sb.append("    saleChance: ").append(toIndentedString(saleChance)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

