package com.tingkelai.vo.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 销售产品记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:08:57
 * @version 1.0
 */
@ApiModel(description = "销售产品记录")
public class SaleProductRecordVO implements BaseVO<SaleProductRecord, SaleProductRecordVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("saleMoney")
    private String saleMoney = null;

    @JsonProperty("unit")
    private String unit = null;

    @JsonProperty("num")
    private String num = null;

    @JsonProperty("total")
    private String total = null;

    @JsonProperty("realTotal")
    private String realTotal = null;

    @JsonProperty("leftDesc")
    private String leftDesc = null;

    @JsonProperty("leftCode")
    private String leftCode = null;

    @JsonProperty("leftDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date leftDate = null;

    @JsonProperty("rightDesc")
    private String rightDesc = null;

    @JsonProperty("rightCode")
    private String rightCode = null;

    @JsonProperty("rightDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rightDate = null;

    @JsonProperty("discount")
    private String discount = null;

    /**
     * 产品名
     * @return name
     **/
    @ApiModelProperty(value = "产品名")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 统一零售价
     * @return saleMoney
     **/
    @ApiModelProperty(value = "统一零售价")
    public String getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(String saleMoney) {
        this.saleMoney = saleMoney;
    }

    /**
     * 单位
     * @return unit
     **/
    @ApiModelProperty(value = "单位")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 数量
     * @return num
     **/
    @ApiModelProperty(value = "数量")
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    /**
     * 总价
     * @return total
     **/
    @ApiModelProperty(value = "总价")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * 实际成交价
     * @return realTotal
     **/
    @ApiModelProperty(value = "实际成交价")
    public String getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(String realTotal) {
        this.realTotal = realTotal;
    }

    /**
     * 左耳产品描述
     * @return leftDesc
     **/
    @ApiModelProperty(value = "左耳产品描述")
    public String getLeftDesc() {
        return leftDesc;
    }

    public void setLeftDesc(String leftDesc) {
        this.leftDesc = leftDesc;
    }

    /**
     * 左耳产品编号
     * @return leftCode
     **/
    @ApiModelProperty(value = "左耳产品编号")
    public String getLeftCode() {
        return leftCode;
    }

    public void setLeftCode(String leftCode) {
        this.leftCode = leftCode;
    }

    /**
     * 左耳产品维护到期时间
     * @return leftDate
     **/
    @ApiModelProperty(value = "左耳产品维护到期时间")
    public Date getLeftDate() {
        return leftDate;
    }
    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
    }

    /**
     * 右耳产品描述
     * @return rightDesc
     **/
    @ApiModelProperty(value = "右耳产品描述")
    public String getRightDesc() {
        return rightDesc;
    }

    public void setRightDesc(String rightDesc) {
        this.rightDesc = rightDesc;
    }

    /**
     * 右耳产品编号
     * @return rightCode
     **/
    @ApiModelProperty(value = "右耳产品编号")
    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode;
    }

    /**
     * 右耳产品维护到期时间
     * @return rightDate
     **/
    @ApiModelProperty(value = "右耳产品维护到期时间")
    public Date getRightDate() {
        return rightDate;
    }

    public void setRightDate(Date rightDate) {
        this.rightDate = rightDate;
    }


    /**
     * 折扣
     * @return discount
     **/
    @ApiModelProperty(value = "折扣")
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 封装成业务需要的对象
     */
    public SaleProductRecord toDTO(){
        SaleProductRecord saleProductRecord = new SaleProductRecord();
        saleProductRecord.setDiscount(getDiscount());
        saleProductRecord.setId(getId());
        saleProductRecord.setLeftCode(getLeftCode());
        saleProductRecord.setLeftDate(getLeftDate());
        saleProductRecord.setLeftDesc(getLeftDesc());
        saleProductRecord.setName(getName());
        saleProductRecord.setNum(getNum());
        saleProductRecord.setRealTotal(getRealTotal());
        saleProductRecord.setRightCode(getRightCode());
        saleProductRecord.setRightDate(getRightDate());
        saleProductRecord.setRightDesc(getRightDesc());
        saleProductRecord.setSaleMoney(getSaleMoney());
        saleProductRecord.setTotal(getTotal());
        saleProductRecord.setUnit(getUnit());
        return saleProductRecord;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleProductRecordVO toVO(SaleProductRecord saleProductRecord){
        return null;
    }
}

