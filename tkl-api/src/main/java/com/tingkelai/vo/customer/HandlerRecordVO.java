package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 经手人变更记录
 */
@ApiModel(description = "经手人变更记录")
public class HandlerRecordVO implements BaseVO<HandlerRecord, HandlerRecordVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    @Override
    public void setTeamId(Long teamId) {

    }

    @Override
    public Long getTeamId() {
        return null;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("changeDate")
    private String changeDate = null;

    @JsonProperty("reason")
    private String reason = null;

    /**
     * 变更时间
     * @return changeDate
     **/
    @ApiModelProperty(value = "变更时间")
    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

    /**
     * 变更原因
     * @return reason
     **/
    @ApiModelProperty(value = "变更原因")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 封装成业务需要的对象
     */
    public HandlerRecord toDTO(){
        return toDTO(this);
    }

    @Override
    public HandlerRecord toDTO(HandlerRecordVO vo) {
        HandlerRecord handlerRecord = new HandlerRecord();
        handlerRecord.setChangeDate(vo.getChangeDate());
        handlerRecord.setId(vo.getId());
        handlerRecord.setReason(vo.getReason());
        return handlerRecord;
    }

    @Override
    public List<HandlerRecord> toDTO(List<HandlerRecordVO> voList) {
        List<HandlerRecord> list = new ArrayList<>();
        for(HandlerRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public HandlerRecordVO toVO(HandlerRecord handlerRecord){
        HandlerRecordVO handlerRecordVO = new HandlerRecordVO();
        handlerRecordVO.setChangeDate(handlerRecord.getChangeDate());
        handlerRecordVO.setId(handlerRecord.getId());
        handlerRecordVO.setReason(handlerRecord.getReason());
        return handlerRecordVO;
    }

    @Override
    public List<HandlerRecordVO> toVO(List<HandlerRecord> list) {
        List<HandlerRecordVO> resList = new ArrayList<>();
        for(HandlerRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

