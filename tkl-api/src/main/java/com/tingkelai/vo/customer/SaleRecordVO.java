package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:03:42
 * @version 1.0
 */
@ApiModel(description = "销售记录")
public class SaleRecordVO implements BaseVO<SaleRecord, SaleRecordVO>{

    public SaleRecordVO(){

    }

    public SaleRecordVO(SaleRecord saleRecord){
        setChannel(saleRecord.getChannel());
        setCode(saleRecord.getCode());
        setId(saleRecord.getId());
        setOrderFlag(saleRecord.getOrderFlag());
        setSaleDate(saleRecord.getSaleDate());
        setDept(new DeptVO(saleRecord.getDept()));
        setUser(new UserVO(saleRecord.getUser()));
        setCustomer(new CustomerVO(saleRecord.getCustomer()));
        setDiscount(saleRecord.getDiscount());
        setOriginalPrice(saleRecord.getOriginalPrice());
        setRealPrice(saleRecord.getRealPrice());
        setStateDict(new DictItemVO(saleRecord.getStateDict()));
    }

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(hidden = true)
    private Long teamId;

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

    @ApiModelProperty(value = "单据编号")
    @JsonProperty("code")
    private String code = null;

    @ApiModelProperty(value = "销售时间")
    @JsonProperty("saleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date saleDate = null;

    @ApiModelProperty(value = "销售来源")
    @JsonProperty("channel")
    private String channel = null;

    @ApiModelProperty(value = "预约标识")
    @JsonProperty("orderFlag")
    private String orderFlag = null;

    @JsonProperty("dept")
    @ApiModelProperty("门店")
    private DeptVO dept;

    @JsonProperty("user")
    @ApiModelProperty("服务人员")
    private UserVO user;

    @JsonProperty("customer")
    @ApiModelProperty("关联客户")
    private CustomerVO customer;

    @JsonProperty("originalPrice")
    @ApiModelProperty("原价")
    private Double originalPrice;

    @JsonProperty("discount")
    @ApiModelProperty("折扣")
    private String discount;

    @JsonProperty("realPrice")
    @ApiModelProperty("实际价格")
    private Double realPrice;

    @JsonProperty("stateDict")
    @ApiModelProperty("状态")
    private DictItemVO stateDict;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
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

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public DictItemVO getStateDict() {
        return stateDict;
    }

    public void setStateDict(DictItemVO stateDict) {
        this.stateDict = stateDict;
    }

    /**
     * 封装成业务需要的对象
     */
    public SaleRecord toDTO(){
        return toDTO(this);
    }

    @Override
    public SaleRecord toDTO(SaleRecordVO saleRecordVO) {
        SaleRecord saleRecord = new SaleRecord();
        saleRecord.setChannel(saleRecordVO.getChannel());
        saleRecord.setCode(saleRecordVO.getCode());
        saleRecord.setId(saleRecordVO.getId());
        saleRecord.setOrderFlag(saleRecordVO.getOrderFlag());
        saleRecord.setSaleDate(saleRecordVO.getSaleDate());
        if(saleRecordVO.getCustomer() != null){
            saleRecord.setCustomer(saleRecordVO.getCustomer().toDTO());
        }
        saleRecord.setTeamId(saleRecordVO.getTeamId());
        saleRecord.setDiscount(saleRecordVO.getDiscount());
        saleRecord.setOriginalPrice(saleRecordVO.getOriginalPrice());
        saleRecord.setRealPrice(saleRecordVO.getRealPrice());
//        saleRecord.setStateDict(saleRecordVO.getStateDict().toDTO());
        return saleRecord;
    }

    @Override
    public List<SaleRecord> toDTO(List<SaleRecordVO> voList) {
        List<SaleRecord> list = new ArrayList<>();
        for(SaleRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleRecordVO toVO(SaleRecord saleRecord){
        return new SaleRecordVO(saleRecord);
    }

    @Override
    public List<SaleRecordVO> toVO(List<SaleRecord> list) {
        List<SaleRecordVO> resList = new ArrayList<>();
        for(SaleRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

