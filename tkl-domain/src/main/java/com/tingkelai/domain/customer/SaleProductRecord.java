package com.tingkelai.domain.customer;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * 销售产品记录
 * 2018-11-27 20:08:57
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "销售产品记录")
@TableName("tkl_customer_sale_product_record")
@Mapper
public class SaleProductRecord  extends DataEntity<Long> {

    /**
     * 产品名
     **/
    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    /**
     * 统一零售价
     **/
    @JsonProperty("saleMoney")
    @TableField("sale_money")
    private String saleMoney = null;


    /**
     * 单位
     **/
    @JsonProperty("unit")
    @TableField("unit")
    private String unit = null;

    /**
     * 数量
     **/
    @JsonProperty("num")
    @TableField("num")
    private String num = null;


    /**
     * 总价
     **/
    @JsonProperty("total")
    @TableField("total")
    private String total = null;


    /**
     * 实际成交价
     **/
    @JsonProperty("realTotal")
    @TableField("real_total")
    private String realTotal = null;

    /**
     * 左耳产品描述
     **/
    @JsonProperty("leftDesc")
    @TableField("left_desc")
    private String leftDesc = null;

    /**
     * 左耳产品编号
     **/
    @JsonProperty("leftCode")
    @TableField("left_code")
    private String leftCode = null;

    /**
     * 左耳产品维护到期时间
     **/
    @JsonProperty("leftDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("left_date")
    private Date leftDate = null;

    /**
     * 右耳产品描述
     **/
    @JsonProperty("rightDesc")
    @TableField("right_desc")
    private String rightDesc = null;


    /**
     * 右耳产品编号
     **/
    @JsonProperty("rightCode")
    @TableField("right_code")
    private String rightCode = null;


    /**
     * 右耳产品维护到期时间
     **/
    @JsonProperty("rightDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("right_date")
    private Date rightDate = null;

    /**
     * 折扣
     **/
    @JsonProperty("discount")
    @TableField("discount")
    private String discount = null;

    /**
     * 关联销售记录
     **/
    @JsonProperty("saleRecord")
    @TableField(value = "sale_record_id", el = "saleRecord.id")
    private SaleRecord saleRecord = null;

    /**
     * 数据所属公司
     */
    @JsonProperty("teamId")
    @TableField("team_id")
    private Long teamId;

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

    public SaleRecord getSaleRecord() {
        if(saleRecord == null){
            saleRecord = new SaleRecord();
        }
        return saleRecord;
    }

    public void setSaleRecord(SaleRecord saleRecord) {
        this.saleRecord = saleRecord;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}

