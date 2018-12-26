package com.tingkelai.vo.customer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售产品记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:08:57
 * @version 1.0
 */
@ApiModel(description = "销售产品记录")
public class SaleProductRecordVO implements BaseVO<SaleProductRecord, SaleProductRecordVO>{

    public SaleProductRecordVO(){

    }

    public SaleProductRecordVO(SaleProductRecord saleProductRecord){
        setDiscount(saleProductRecord.getDiscount());
        setId(saleProductRecord.getId());
        setLeftCode(saleProductRecord.getLeftCode());
        setLeftDate(saleProductRecord.getLeftDate());
        setLeftDesc(saleProductRecord.getLeftDesc());
        setName(saleProductRecord.getName());
        setNum(saleProductRecord.getNum());
        setRealTotal(saleProductRecord.getRealTotal());
        setRightCode(saleProductRecord.getRightCode());
        setRightDate(saleProductRecord.getRightDate());
        setRightDesc(saleProductRecord.getRightDesc());
        setSaleMoney(saleProductRecord.getSaleMoney());
        setTotal(saleProductRecord.getTotal());
        setUnit(saleProductRecord.getUnit());
        // 关联销售记录
        setSaleRecord(new SaleRecordVO(saleProductRecord.getSaleRecord()));
    }

    @JsonProperty("id")
    @ApiModelProperty(name = "id", value = "id")
    private Long id = null;

    @ApiModelProperty(value = "产品名")
    @JsonProperty("name")
    private String name = null;

    @ApiModelProperty(value = "统一零售价")
    @JsonProperty("saleMoney")
    private String saleMoney = null;

    @ApiModelProperty(value = "单位（计量单位）")
    @JsonProperty("unit")
    private String unit = null;

    @ApiModelProperty(value = "数量")
    @JsonProperty("num")
    private String num = null;

    @ApiModelProperty(value = "总价")
    @JsonProperty("total")
    private String total = null;

    @ApiModelProperty(value = "实际成交价")
    @JsonProperty("realTotal")
    private String realTotal = null;

    @ApiModelProperty(value = "左耳产品描述")
    @JsonProperty("leftDesc")
    private String leftDesc = null;

    @ApiModelProperty(value = "左耳产品编号")
    @JsonProperty("leftCode")
    private String leftCode = null;

    @ApiModelProperty(value = "左耳产品维护到期时间")
    @JsonProperty("leftDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date leftDate = null;

    @ApiModelProperty(value = "右耳产品描述")
    @JsonProperty("rightDesc")
    private String rightDesc = null;

    @ApiModelProperty(value = "右耳产品编号")
    @JsonProperty("rightCode")
    private String rightCode = null;

    @ApiModelProperty(value = "右耳产品维护到期时间")
    @JsonProperty("rightDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date rightDate = null;

    @ApiModelProperty(value = "折扣")
    @JsonProperty("discount")
    private String discount = null;

    @ApiModelProperty(hidden = true)
    private Long teamId;

    @ApiModelProperty("关联销售记录")
    @JsonProperty("saleRecord")
    private SaleRecordVO saleRecord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(String saleMoney) {
        this.saleMoney = saleMoney;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRealTotal() {
        return realTotal;
    }

    public void setRealTotal(String realTotal) {
        this.realTotal = realTotal;
    }

    public String getLeftDesc() {
        return leftDesc;
    }

    public void setLeftDesc(String leftDesc) {
        this.leftDesc = leftDesc;
    }

    public String getLeftCode() {
        return leftCode;
    }

    public void setLeftCode(String leftCode) {
        this.leftCode = leftCode;
    }


    public Date getLeftDate() {
        return leftDate;
    }
    public void setLeftDate(Date leftDate) {
        this.leftDate = leftDate;
    }

    public String getRightDesc() {
        return rightDesc;
    }

    public void setRightDesc(String rightDesc) {
        this.rightDesc = rightDesc;
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode;
    }

    public Date getRightDate() {
        return rightDate;
    }

    public void setRightDate(Date rightDate) {
        this.rightDate = rightDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public SaleRecordVO getSaleRecord() {
        if(saleRecord == null){
            saleRecord = new SaleRecordVO();
        }
        return saleRecord;
    }

    public void setSaleRecord(SaleRecordVO saleRecord) {
        this.saleRecord = saleRecord;
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
    public SaleProductRecord toDTO(){
        return toDTO(this);
    }

    @Override
    public SaleProductRecord toDTO(SaleProductRecordVO saleProductRecordVO) {
        SaleProductRecord saleProductRecord = new SaleProductRecord();
        saleProductRecord.setDiscount(saleProductRecordVO.getDiscount());
        saleProductRecord.setId(saleProductRecordVO.getId());
        saleProductRecord.setLeftCode(saleProductRecordVO.getLeftCode());
        saleProductRecord.setLeftDate(saleProductRecordVO.getLeftDate());
        saleProductRecord.setLeftDesc(saleProductRecordVO.getLeftDesc());
        saleProductRecord.setName(saleProductRecordVO.getName());
        saleProductRecord.setNum(saleProductRecordVO.getNum());
        saleProductRecord.setRealTotal(saleProductRecordVO.getRealTotal());
        saleProductRecord.setRightCode(saleProductRecordVO.getRightCode());
        saleProductRecord.setRightDate(saleProductRecordVO.getRightDate());
        saleProductRecord.setRightDesc(saleProductRecordVO.getRightDesc());
        saleProductRecord.setSaleMoney(saleProductRecordVO.getSaleMoney());
        saleProductRecord.setTotal(saleProductRecordVO.getTotal());
        saleProductRecord.setUnit(saleProductRecordVO.getUnit());
        saleProductRecord.setTeamId(saleProductRecordVO.getTeamId());
        //关联销售记录
        saleProductRecord.setSaleRecord(saleProductRecordVO.getSaleRecord().toDTO());
        return saleProductRecord;
    }

    @Override
    public List<SaleProductRecord> toDTO(List<SaleProductRecordVO> voList) {
        List<SaleProductRecord> list = new ArrayList<>();
        for(SaleProductRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleProductRecordVO toVO(SaleProductRecord saleProductRecord){
        return new SaleProductRecordVO(saleProductRecord);
    }

    @Override
    public List<SaleProductRecordVO> toVO(List<SaleProductRecord> list) {
        List<SaleProductRecordVO> resList = new ArrayList<>();
        for(SaleProductRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

