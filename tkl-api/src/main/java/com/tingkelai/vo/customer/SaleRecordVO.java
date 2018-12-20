package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.domain.customer.SaleRecord;
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

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("saleDate")
    private Date saleDate = null;

    @JsonProperty("channel")
    private String channel = null;

    @JsonProperty("orderFlag")
    private String orderFlag = null;

    @ApiModelProperty("门店")
    private DeptVO dept;

    @ApiModelProperty("服务人员")
    private UserVO user;

    @ApiModelProperty("关联客户")
    private CustomerVO customer;

    /**
     * 单据编号
     * @return code
     **/
    @ApiModelProperty(value = "单据编号")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 销售时间
     * @return saleDate
     **/
    @ApiModelProperty(value = "销售时间")
    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * 销售来源
     * @return channel
     **/
    @ApiModelProperty(value = "销售来源")
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * 预约标识
     * @return orderFlag
     **/
    @ApiModelProperty(value = "预约标识")
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

