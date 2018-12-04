package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 客户预约计划
 */
@ApiModel(description = "客户预约计划")
public class SubscribePlanVO implements BaseVO<SubscribePlan, SubscribePlanVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("planType")
    private String planType = null;

    @JsonProperty("planDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date planDate = null;

    @JsonProperty("dealWay")
    private String dealWay = null;

    @JsonProperty("dealType")
    private String dealType = null;

    @JsonProperty("theme")
    private String theme = null;

    /**
     * 预约类型
     * @return planType
     **/
    @ApiModelProperty(value = "预约类型")
    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    /**
     * 预约时间
     * @return planDate
     **/
    @ApiModelProperty(value = "预约时间")
    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    /**
     * 处理方式
     * @return dealWay
     **/
    @ApiModelProperty(value = "处理方式")
    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    /**
     * 处理类型
     * @return dealType
     **/
    @ApiModelProperty(value = "处理类型")
    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    /**
     * 主题
     * @return theme
     **/
    @ApiModelProperty(value = "主题")
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * 封装成业务需要的对象
     */
    public SubscribePlan toDTO(){
        SubscribePlan subscribePlan = new SubscribePlan();
        subscribePlan.setDealType(getDealType());
        subscribePlan.setDealWay(getDealWay());
        subscribePlan.setId(getId());
        subscribePlan.setPlanDate(getPlanDate());
        subscribePlan.setPlanType(getPlanType());
        subscribePlan.setTheme(getTheme());
        return subscribePlan;
    }

    /**
     * 封装成web需要的对象
     */
    public SubscribePlanVO toVO(SubscribePlan subscribePlan){
        return null;
    }
}

