package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户跟进记录
 */
@ApiModel(description = "客户跟进记录")
public class FollowRecordVO implements BaseVO<FollowRecord, FollowRecordVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("way")
    private String way = null;

    @JsonProperty("contactDate")
    private String contactDate = null;

    @JsonProperty("chanceLevel")
    private String chanceLevel = null;

    @JsonProperty("planSaleMoney")
    private String planSaleMoney = null;

    @JsonProperty("planSaleDate")
    private String planSaleDate = null;

    @JsonProperty("state")
    private String state = null;

    @JsonProperty("context")
    private String context = null;

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
     * 封装成业务需要的对象
     */
    public FollowRecord toDTO(){
        return toDTO(this);
    }

    @Override
    public FollowRecord toDTO(FollowRecordVO vo) {
        FollowRecord followRecord = new FollowRecord();
        followRecord.setChanceLevel(vo.getChanceLevel());
        followRecord.setContactDate(vo.getContactDate());
        followRecord.setContext(vo.getContext());
        followRecord.setId(vo.getId());
        followRecord.setPlanSaleDate(vo.getPlanSaleDate());
        followRecord.setPlanSaleMoney(vo.getPlanSaleMoney());
        followRecord.setState(vo.getState());
        followRecord.setType(vo.getType());
        followRecord.setWay(vo.getWay());
        return followRecord;
    }

    @Override
    public List<FollowRecord> toDTO(List<FollowRecordVO> voList) {
        List<FollowRecord> list = new ArrayList<>();
        for(FollowRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public FollowRecordVO toVO(FollowRecord followRecord){
        FollowRecordVO vo = new FollowRecordVO();
        vo.setChanceLevel(followRecord.getChanceLevel());
        vo.setContactDate(followRecord.getContactDate());
        vo.setContext(followRecord.getContext());
        vo.setId(followRecord.getId());
        vo.setPlanSaleDate(followRecord.getPlanSaleDate());
        vo.setPlanSaleMoney(followRecord.getPlanSaleMoney());
        vo.setState(followRecord.getState());
        vo.setType(followRecord.getType());
        vo.setWay(followRecord.getWay());
        return vo;
    }

    @Override
    public List<FollowRecordVO> toVO(List<FollowRecord> list) {
        List<FollowRecordVO> resList = new ArrayList<>();
        for(FollowRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

