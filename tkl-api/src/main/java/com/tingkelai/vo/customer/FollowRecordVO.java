package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户跟进记录
 */
@ApiModel(description = "客户跟进记录")
public class FollowRecordVO implements BaseVO<FollowRecord, FollowRecordVO>{

    public FollowRecordVO(){

    }

    public FollowRecordVO(FollowRecord followRecord){
        setId(followRecord.getId());
        setContext(followRecord.getContext());
        setChanceLevel(followRecord.getChanceLevel());
        setContactDate(followRecord.getContactDate());
        setLinkman(new LinkManVO(followRecord.getLinkman()));
        setPhaseDict(new DictItemVO(followRecord.getPhaseDict()));
        setSaleChance(new SaleChanceVO(followRecord.getSaleChance()));
        setWayDict(new DictItemVO(followRecord.getWayDict()));
    }

    @JsonProperty("id")
    @ApiModelProperty(name = "id", value = "id")
    private Long id = null;

    @JsonProperty("teamId")
    @ApiModelProperty(hidden = true)
    private Long teamId;

    @ApiModelProperty(value = "关联联系人")
    @JsonProperty("linkman")
    private LinkManVO linkman;

    @ApiModelProperty(value = "跟进方式")
    @JsonProperty("wayDict")
    private DictItemVO wayDict;

    @ApiModelProperty(value = "联系时间(跟进时间)")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("contactDate")
    private Date contactDate;

    /** 目前阶段 */
    @JsonProperty("phaseDict")
    @ApiModelProperty(value = "阶段状态")
    private DictItemVO phaseDict;

    @ApiModelProperty(value = "成交概率")
    private String chanceLevel;

    @ApiModelProperty(value = "跟进内容（联系内容）")
    @JsonProperty("context")
    private String context;

    /** 所属销售机会 */
    @JsonProperty("saleChance")
    private SaleChanceVO saleChance;

    public LinkManVO getLinkman() {
        if(linkman == null){
            linkman = new LinkManVO();
        }
        return linkman;
    }

    public void setLinkman(LinkManVO linkman) {
        this.linkman = linkman;
    }

    public DictItemVO getWayDict() {
        if(wayDict == null){
            wayDict = new DictItemVO();
        }
        return wayDict;
    }

    public void setWayDict(DictItemVO wayDict) {
        this.wayDict = wayDict;
    }

    public Date getContactDate() {
        return contactDate;
    }

    public void setContactDate(Date contactDate) {
        this.contactDate = contactDate;
    }

    public DictItemVO getPhaseDict() {
        if(phaseDict == null){
            phaseDict = new DictItemVO();
        }
        return phaseDict;
    }

    public void setPhaseDict(DictItemVO phaseDict) {
        this.phaseDict = phaseDict;
    }

    public String getChanceLevel() {
        return chanceLevel;
    }

    public void setChanceLevel(String chanceLevel) {
        this.chanceLevel = chanceLevel;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public SaleChanceVO getSaleChance() {
        if(saleChance == null){
            saleChance = new SaleChanceVO();
        }
        return saleChance;
    }

    public void setSaleChance(SaleChanceVO saleChance) {
        this.saleChance = saleChance;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public Long getTeamId() {
        return teamId;
    }


    public void setId(Long id) {
        this.id = id;
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
        followRecord.setId(vo.getId());
        followRecord.setContext(vo.getContext());
        followRecord.setChanceLevel(vo.getChanceLevel());
        followRecord.setContactDate(vo.getContactDate());
        followRecord.setLinkman(vo.getLinkman().toDTO());
        followRecord.setPhaseDict(vo.getPhaseDict().toDTO());
        followRecord.setSaleChance(vo.getSaleChance().toDTO());
        followRecord.setWayDict(vo.getWayDict().toDTO());
        followRecord.setTeamId(vo.getTeamId());
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
        return new FollowRecordVO(followRecord);
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

