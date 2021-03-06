package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.ContactRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户联系记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:36:51
 * @version 1.0
 */
@ApiModel(description = "客户联系记录")
public class ContactRecordVO implements BaseVO<ContactRecord, ContactRecordVO>{

    public ContactRecordVO(){

    }

    public ContactRecordVO(ContactRecord contactRecord){
        setId(contactRecord.getId());
        setContactDate(contactRecord.getContactDate());
        setContext(contactRecord.getContext());
        setNextContactDate(contactRecord.getNextContactDate());
        setOrderFlag(contactRecord.getOrderFlag());
        setType(contactRecord.getType());
        setWay(contactRecord.getWay());
        setUser(new UserVO(contactRecord.getUser()));
        setDept(new DeptVO(contactRecord.getDept()));
        setCustomer(new CustomerVO(contactRecord.getCustomer()));
    }

    /** 数据所属公司id */
    @ApiModelProperty(hidden = true)
    private Long teamId;

    @JsonProperty("id")
    @ApiModelProperty(name = "id", value = "id")
    private Long id = null;

    /** 联系类别 */
    @ApiModelProperty(value = "联系类别")
    @JsonProperty("type")
    private String type = null;

    /** 联系方式 **/
    @ApiModelProperty(value = "联系方式")
    @JsonProperty("way")
    private String way = null;

    /** 联系时间 */
    @ApiModelProperty(value = "联系时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("contactDate")
    private String contactDate = null;

    /** 下次联系时间 */
    @ApiModelProperty(value = "下次联系时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonProperty("nextContactDate")
    private String nextContactDate = null;

    /** 预约计划标识 */
    @ApiModelProperty(value = "预约计划标识")
    @JsonProperty("orderFlag")
    private String orderFlag = null;


    /** 联系内容 */
    @ApiModelProperty(value = "联系内容")
    @JsonProperty("context")
    private String context = null;

    @ApiModelProperty("门店")
    private DeptVO dept;

    @ApiModelProperty("服务人员")
    private UserVO user;

    @ApiModelProperty("关联客户")
    private CustomerVO customer;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public DeptVO getDept() {
        return dept;
    }

    public void setDept(DeptVO dept) {
        this.dept = dept;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public CustomerVO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
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
    public ContactRecord toDTO(){
        return toDTO(this);
    }

    /**
     *
     * 封装成业务需要的对象
     * 静态方法
     */
    public ContactRecord toDTO(ContactRecordVO vo){
        ContactRecord contactRecord = new ContactRecord();
        contactRecord.setId(vo.getId());
        contactRecord.setContactDate(vo.getContactDate());
        contactRecord.setContext(vo.getContext());
        contactRecord.setNextContactDate(vo.getNextContactDate());
        contactRecord.setOrderFlag(vo.getOrderFlag());
        contactRecord.setType(vo.getType());
        contactRecord.setWay(vo.getWay());
        if(vo.getCustomer() != null){
            contactRecord.setCustomer(vo.getCustomer().toDTO());
        }
        contactRecord.setTeamId(vo.getTeamId());
        return contactRecord;
    }

    /**
     * 封装成业务需要的对象列表
     * 静态方法
     */
    public List<ContactRecord> toDTO(List<ContactRecordVO> voList){
        List<ContactRecord> list = new ArrayList<>();
        for(ContactRecordVO contactRecord : voList){
            list.add(contactRecord.toDTO(contactRecord));
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public ContactRecordVO toVO(ContactRecord contactRecord){
        return new ContactRecordVO(contactRecord);
    }

    /**
     * 封装成web需要的对象
     */
    public List<ContactRecordVO> toVO(List<ContactRecord> list){
        List<ContactRecordVO> contactRecordVOList = new ArrayList<>();
        for(ContactRecord contactRecord : list){
            contactRecordVOList.add(toVO(contactRecord));
        }
        return contactRecordVOList;
    }
}