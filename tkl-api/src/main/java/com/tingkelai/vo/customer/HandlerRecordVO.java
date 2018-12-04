package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
        HandlerRecord handlerRecord = new HandlerRecord();
        handlerRecord.setChangeDate(getChangeDate());
        handlerRecord.setId(getId());
        handlerRecord.setReason(getReason());
        return handlerRecord;
    }

    /**
     * 封装成web需要的对象
     */
    public HandlerRecordVO toVO(HandlerRecord handlerRecord){
        return null;
    }
}

