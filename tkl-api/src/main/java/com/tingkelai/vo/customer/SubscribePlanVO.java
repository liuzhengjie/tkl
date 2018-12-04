package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        return toDTO(this);
    }

    @Override
    public SubscribePlan toDTO(SubscribePlanVO subscribePlanVO) {
        SubscribePlan subscribePlan = new SubscribePlan();
        subscribePlan.setDealType(subscribePlanVO.getDealType());
        subscribePlan.setDealWay(subscribePlanVO.getDealWay());
        subscribePlan.setId(subscribePlanVO.getId());
        subscribePlan.setPlanDate(subscribePlanVO.getPlanDate());
        subscribePlan.setPlanType(subscribePlanVO.getPlanType());
        subscribePlan.setTheme(subscribePlanVO.getTheme());
        return subscribePlan;
    }

    @Override
    public List<SubscribePlan> toDTO(List<SubscribePlanVO> voList) {
        List<SubscribePlan> list = new ArrayList<>();
        for(SubscribePlanVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SubscribePlanVO toVO(SubscribePlan subscribePlan){
        SubscribePlanVO subscribePlanVO = new SubscribePlanVO();
        subscribePlanVO.setDealType(subscribePlan.getDealType());
        subscribePlanVO.setDealWay(subscribePlan.getDealWay());
        subscribePlanVO.setId(subscribePlan.getId());
        subscribePlanVO.setPlanDate(subscribePlan.getPlanDate());
        subscribePlanVO.setPlanType(subscribePlan.getPlanType());
        subscribePlanVO.setTheme(subscribePlan.getTheme());
        return subscribePlanVO;
    }

    @Override
    public List<SubscribePlanVO> toVO(List<SubscribePlan> list) {
        List<SubscribePlanVO> resList = new ArrayList<>();
        for(SubscribePlan temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

