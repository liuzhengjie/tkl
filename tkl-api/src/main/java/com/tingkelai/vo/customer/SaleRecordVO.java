package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 销售记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:03:42
 * @version 1.0
 */
@ApiModel(description = "销售记录")
public class SaleRecordVO implements BaseVO<SaleRecord, SaleRecordVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
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

    /**
     * 封装成业务需要的对象
     */
    public SaleRecord toDTO(){
        SaleRecord saleRecord = new SaleRecord();
        saleRecord.setChannel(getChannel());
        saleRecord.setCode(getCode());
        saleRecord.setId(getId());
        saleRecord.setOrderFlag(getOrderFlag());
        saleRecord.setSaleDate(getSaleDate());
        return saleRecord;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleRecordVO toVO(SaleRecord saleRecord){
        return null;
    }
}

