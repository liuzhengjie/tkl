package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 经手人变更记录
 */
@ApiModel(description = "经手人变更记录")
public class HandlerRecordVO implements BaseVO<HandlerRecord, HandlerRecordVO>{

    public HandlerRecordVO(){

    }

    public HandlerRecordVO(HandlerRecord handlerRecord){
        setChangeDate(handlerRecord.getChangeDate());
        setId(handlerRecord.getId());
        setReason(handlerRecord.getReason());
        setTeamId(handlerRecord.getTeamId());
        setCustomer(new CustomerVO(handlerRecord.getCustomer()));
        setUser(new UserVO(handlerRecord.getUser()));
        setOperUser(new UserVO(handlerRecord.getUser()));
        setDept(new DeptVO(handlerRecord.getDept()));
    }

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("teamId")
    private Long teamId;

    @ApiModelProperty(value = "变更时间")
    @JsonProperty("changeDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date changeDate;

    @ApiModelProperty(value = "经手部门")
    @JsonProperty("dept")
    private DeptVO dept;

    @ApiModelProperty(value = "经手人员")
    @JsonProperty("user")
    private UserVO user;

    @ApiModelProperty(value = "变更原因")
    @JsonProperty("reason")
    private String reason = null;

    @ApiModelProperty(value = "操作人员")
    @JsonProperty("operUser")
    private UserVO operUser = null;

    @ApiModelProperty(value = "关联客户")
    @JsonProperty("customer")
    private CustomerVO customer;

    @ApiModelProperty(name = "id", value = "id")
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

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public DeptVO getDept() {
        if(dept == null){
            dept = new DeptVO();
        }
        return dept;
    }

    public void setDept(DeptVO dept) {
        this.dept = dept;
    }

    public UserVO getUser() {
        if(user == null){
            user = new UserVO();
        }
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public UserVO getOperUser() {
        if(operUser == null){
            operUser = new UserVO();
        }
        return operUser;
    }

    public void setOperUser(UserVO operUser) {
        this.operUser = operUser;
    }

    public CustomerVO getCustomer() {
        if(customer == null){
            customer = new CustomerVO();
        }
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
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
        handlerRecord.setCustomer(vo.getCustomer().toDTO());
        handlerRecord.setUser(vo.getUser().toDTO());
        handlerRecord.setOperUser(vo.getOperUser().toDTO());
        handlerRecord.setDept(vo.getDept().toDTO());
        handlerRecord.setTeamId(vo.getTeamId());
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
        return new HandlerRecordVO(handlerRecord);
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

