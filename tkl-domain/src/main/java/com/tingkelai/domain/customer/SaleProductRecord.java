package com.tingkelai.domain.customer;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.Objects;

/**
 * 销售产品记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:08:57
 * @version 1.0
 */
@ApiModel(description = "销售产品记录")
@TableName("tkl_customer_sale_product_record")
@Mapper
public class SaleProductRecord  extends DataEntity<Long> {
    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    @JsonProperty("saleMoney")
    @TableField("sale_money")
    private String saleMoney = null;

    @JsonProperty("unit")
    @TableField("unit")
    private String unit = null;

    @JsonProperty("num")
    @TableField("num")
    private String num = null;

    @JsonProperty("total")
    @TableField("total")
    private String total = null;

    @JsonProperty("realTotal")
    @TableField("real_total")
    private String realTotal = null;

    @JsonProperty("leftDesc")
    @TableField("left_desc")
    private String leftDesc = null;

    @JsonProperty("leftCode")
    @TableField("left_code")
    private String leftCode = null;

    @JsonProperty("leftDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("left_date")
    private Date leftDate = null;

    @JsonProperty("rightDesc")
    @TableField("right_desc")
    private String rightDesc = null;

    @JsonProperty("rightCode")
    @TableField("right_code")
    private String rightCode = null;

    @JsonProperty("rightDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("right_date")
    private Date rightDate = null;

    @JsonProperty("discount")
    @TableField("discount")
    private String discount = null;

    @JsonProperty("saleRecord")
    @TableField(value = "sale_record_id", el = "saleRecord.id")
    private SaleRecord saleRecord = null;

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

    public SaleProductRecord saleMoney(String saleMoney) {
        this.saleMoney = saleMoney;
        return this;
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

    public SaleProductRecord unit(String unit) {
        this.unit = unit;
        return this;
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

    public SaleProductRecord num(String num) {
        this.num = num;
        return this;
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

    public SaleProductRecord total(String total) {
        this.total = total;
        return this;
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

    public SaleProductRecord realTotal(String realTotal) {
        this.realTotal = realTotal;
        return this;
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

    public SaleProductRecord leftDesc(String leftDesc) {
        this.leftDesc = leftDesc;
        return this;
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

    public SaleProductRecord leftCode(String leftCode) {
        this.leftCode = leftCode;
        return this;
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

    public SaleProductRecord leftDate(Date leftDate) {
        this.leftDate = leftDate;
        return this;
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

    public SaleProductRecord rightDesc(String rightDesc) {
        this.rightDesc = rightDesc;
        return this;
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

    public SaleProductRecord rightCode(String rightCode) {
        this.rightCode = rightCode;
        return this;
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

    public SaleProductRecord rightDate(Date rightDate) {
        this.rightDate = rightDate;
        return this;
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

    public SaleProductRecord discount(String discount) {
        this.discount = discount;
        return this;
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

    public SaleProductRecord saleRecord(SaleRecord saleRecord) {
        this.saleRecord = saleRecord;
        return this;
    }

    /**
     * Get saleRecord
     * @return saleRecord
     **/
    @ApiModelProperty(value = "关联销售记录")
    public SaleRecord getSaleRecord() {
        return saleRecord;
    }

    public void setSaleRecord(SaleRecord saleRecord) {
        this.saleRecord = saleRecord;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SaleProductRecord saleProductRecord = (SaleProductRecord) o;
        return Objects.equals(this.name, saleProductRecord.name) &&
                Objects.equals(this.saleMoney, saleProductRecord.saleMoney) &&
                Objects.equals(this.unit, saleProductRecord.unit) &&
                Objects.equals(this.num, saleProductRecord.num) &&
                Objects.equals(this.total, saleProductRecord.total) &&
                Objects.equals(this.realTotal, saleProductRecord.realTotal) &&
                Objects.equals(this.leftDesc, saleProductRecord.leftDesc) &&
                Objects.equals(this.leftCode, saleProductRecord.leftCode) &&
                Objects.equals(this.leftDate, saleProductRecord.leftDate) &&
                Objects.equals(this.rightDesc, saleProductRecord.rightDesc) &&
                Objects.equals(this.rightCode, saleProductRecord.rightCode) &&
                Objects.equals(this.rightDate, saleProductRecord.rightDate) &&
                Objects.equals(this.discount, saleProductRecord.discount) &&
                Objects.equals(this.saleRecord, saleProductRecord.saleRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, saleMoney, unit, num, total, realTotal, leftDesc, leftCode, leftDate, rightDesc, rightCode, rightDate, discount, saleRecord);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SaleProductRecord {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    saleMoney: ").append(toIndentedString(saleMoney)).append("\n");
        sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
        sb.append("    num: ").append(toIndentedString(num)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("    realTotal: ").append(toIndentedString(realTotal)).append("\n");
        sb.append("    leftDesc: ").append(toIndentedString(leftDesc)).append("\n");
        sb.append("    leftCode: ").append(toIndentedString(leftCode)).append("\n");
        sb.append("    leftDate: ").append(toIndentedString(leftDate)).append("\n");
        sb.append("    rightDesc: ").append(toIndentedString(rightDesc)).append("\n");
        sb.append("    rightCode: ").append(toIndentedString(rightCode)).append("\n");
        sb.append("    rightDate: ").append(toIndentedString(rightDate)).append("\n");
        sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
        sb.append("    saleRecord: ").append(toIndentedString(saleRecord)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

