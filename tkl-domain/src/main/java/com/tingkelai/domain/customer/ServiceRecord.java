package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.Objects;

/**
 * 客户服务记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:14:43
 * @version 1.0
 */
@ApiModel(description = "客户服务记录")
@TableName("tkl_customer_service_record")
@Mapper
public class ServiceRecord  extends DataEntity<Long> {

    @JsonProperty("code")
    @TableField("code")
    private String code = null;

    @JsonProperty("serviceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("service_date")
    private Date serviceDate = null;

    @JsonProperty("type")
    @TableField("type")
    private String type = null;

    @JsonProperty("productId")
    @TableField("product_id")
    private String productId = null;

    @JsonProperty("productCode")
    @TableField("product_code")
    private String productCode = null;

    @JsonProperty("productName")
    @TableField("product_name")
    private String productName = null;

    @JsonProperty("buyDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("buy_date")
    private Date buyDate = null;

    @JsonProperty("adornEar")
    @TableField("adorn_ear")
    private String adornEar = null;

    @JsonProperty("repairDeadline")
    @TableField("repair_deadline")
    private String repairDeadline = null;

    @JsonProperty("serviceWay")
    @TableField("service_way")
    private String serviceWay = null;

    @JsonProperty("dealState")
    @TableField("deal_state")
    private String dealState = null;

    @JsonProperty("finishDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("finish_date")
    private Date finishDate = null;

    @JsonProperty("problemType")
    @TableField("problem_type")
    private String problemType = null;

    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman = null;

    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    @JsonProperty("serviceType")
    @TableField("service_type")
    private String serviceType = null;

    @JsonProperty("charge")
    @TableField("charge")
    private String charge = null;

    @JsonProperty("chargePrice")
    @TableField("charge_price")
    private String chargePrice = null;

    @JsonProperty("nextServiceDate")
    @TableField("next_service_date")
    private String nextServiceDate = null;

    @JsonProperty("orderFlag")
    @TableField("order_flag")
    private String orderFlag = null;

    @JsonProperty("problemTemplate")
    @TableField("problem_template")
    private String problemTemplate = null;

    @JsonProperty("problemDesc")
    @TableField("problem_desc")
    private String problemDesc = null;

    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer = null;

    /**
     * 服务编号
     * @return code
     **/
    @ApiModelProperty(value = "服务编号")


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ServiceRecord serviceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
        return this;
    }

    /**
     * 服务日期
     * @return serviceDate
     **/
    @ApiModelProperty(value = "服务日期")
    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public ServiceRecord type(String type) {
        this.type = type;
        return this;
    }

    /**
     * 服务类型
     * @return type
     **/
    @ApiModelProperty(value = "服务类型")


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ServiceRecord productId(String productId) {
        this.productId = productId;
        return this;
    }

    /**
     * 产品id
     * @return productId
     **/
    @ApiModelProperty(value = "产品id")


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public ServiceRecord productCode(String productCode) {
        this.productCode = productCode;
        return this;
    }

    /**
     * 产品编号
     * @return productCode
     **/
    @ApiModelProperty(value = "产品编号")


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public ServiceRecord productName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * 产品名
     * @return productName
     **/
    @ApiModelProperty(value = "产品名")


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ServiceRecord buyDate(Date buyDate) {
        this.buyDate = buyDate;
        return this;
    }

    /**
     * 购买时间
     * @return buyDate
     **/
    @ApiModelProperty(value = "购买时间")
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public ServiceRecord adornEar(String adornEar) {
        this.adornEar = adornEar;
        return this;
    }

    /**
     * 佩戴耳
     * @return adornEar
     **/
    @ApiModelProperty(value = "佩戴耳")


    public String getAdornEar() {
        return adornEar;
    }

    public void setAdornEar(String adornEar) {
        this.adornEar = adornEar;
    }

    public ServiceRecord repairDeadline(String repairDeadline) {
        this.repairDeadline = repairDeadline;
        return this;
    }

    /**
     * 维护到期时间
     * @return repairDeadline
     **/
    @ApiModelProperty(value = "维护到期时间")


    public String getRepairDeadline() {
        return repairDeadline;
    }

    public void setRepairDeadline(String repairDeadline) {
        this.repairDeadline = repairDeadline;
    }

    public ServiceRecord serviceWay(String serviceWay) {
        this.serviceWay = serviceWay;
        return this;
    }

    /**
     * 服务方式
     * @return serviceWay
     **/
    @ApiModelProperty(value = "服务方式")


    public String getServiceWay() {
        return serviceWay;
    }

    public void setServiceWay(String serviceWay) {
        this.serviceWay = serviceWay;
    }

    public ServiceRecord dealState(String dealState) {
        this.dealState = dealState;
        return this;
    }

    /**
     * 处理阶段
     * @return dealState
     **/
    @ApiModelProperty(value = "处理阶段")


    public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState;
    }

    public ServiceRecord finishDate(Date finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    /**
     * 完成时间
     * @return finishDate
     **/
    @ApiModelProperty(value = "完成时间")
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public ServiceRecord problemType(String problemType) {
        this.problemType = problemType;
        return this;
    }

    /**
     * 问题类型
     * @return problemType
     **/
    @ApiModelProperty(value = "问题类型")


    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public ServiceRecord linkman(LinkMan linkman) {
        this.linkman = linkman;
        return this;
    }

    /**
     * Get linkman
     * @return linkman
     **/
    @ApiModelProperty(value = "")
    public LinkMan getLinkman() {
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public ServiceRecord dept(Dept dept) {
        this.dept = dept;
        return this;
    }

    /**
     * Get dept
     * @return dept
     **/
    @ApiModelProperty(value = "")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public ServiceRecord user(User user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     * @return user
     **/
    @ApiModelProperty(value = "")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceRecord serviceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    /**
     * 服务类型
     * @return serviceType
     **/
    @ApiModelProperty(value = "服务类型")


    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public ServiceRecord charge(String charge) {
        this.charge = charge;
        return this;
    }

    /**
     * 收费
     * @return charge
     **/
    @ApiModelProperty(value = "收费")


    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public ServiceRecord chargePrice(String chargePrice) {
        this.chargePrice = chargePrice;
        return this;
    }

    /**
     * 收费金额
     * @return chargePrice
     **/
    @ApiModelProperty(value = "收费金额")


    public String getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(String chargePrice) {
        this.chargePrice = chargePrice;
    }

    public ServiceRecord nextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
        return this;
    }

    /**
     * 下次服务时间
     * @return nextServiceDate
     **/
    @ApiModelProperty(value = "下次服务时间")


    public String getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public ServiceRecord orderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
        return this;
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

    public ServiceRecord problemTemplate(String problemTemplate) {
        this.problemTemplate = problemTemplate;
        return this;
    }

    /**
     * 问题模板
     * @return problemTemplate
     **/
    @ApiModelProperty(value = "问题模板")


    public String getProblemTemplate() {
        return problemTemplate;
    }

    public void setProblemTemplate(String problemTemplate) {
        this.problemTemplate = problemTemplate;
    }

    public ServiceRecord problemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
        return this;
    }

    /**
     * 问题描述
     * @return problemDesc
     **/
    @ApiModelProperty(value = "问题描述")


    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public ServiceRecord customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    /**
     * Get customer
     * @return customer
     **/
    @ApiModelProperty(value = "关联客户")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServiceRecord serviceRecord = (ServiceRecord) o;
        return Objects.equals(this.code, serviceRecord.code) &&
                Objects.equals(this.serviceDate, serviceRecord.serviceDate) &&
                Objects.equals(this.type, serviceRecord.type) &&
                Objects.equals(this.productId, serviceRecord.productId) &&
                Objects.equals(this.productCode, serviceRecord.productCode) &&
                Objects.equals(this.productName, serviceRecord.productName) &&
                Objects.equals(this.buyDate, serviceRecord.buyDate) &&
                Objects.equals(this.adornEar, serviceRecord.adornEar) &&
                Objects.equals(this.repairDeadline, serviceRecord.repairDeadline) &&
                Objects.equals(this.serviceWay, serviceRecord.serviceWay) &&
                Objects.equals(this.dealState, serviceRecord.dealState) &&
                Objects.equals(this.finishDate, serviceRecord.finishDate) &&
                Objects.equals(this.problemType, serviceRecord.problemType) &&
                Objects.equals(this.linkman, serviceRecord.linkman) &&
                Objects.equals(this.dept, serviceRecord.dept) &&
                Objects.equals(this.user, serviceRecord.user) &&
                Objects.equals(this.serviceType, serviceRecord.serviceType) &&
                Objects.equals(this.charge, serviceRecord.charge) &&
                Objects.equals(this.chargePrice, serviceRecord.chargePrice) &&
                Objects.equals(this.nextServiceDate, serviceRecord.nextServiceDate) &&
                Objects.equals(this.orderFlag, serviceRecord.orderFlag) &&
                Objects.equals(this.problemTemplate, serviceRecord.problemTemplate) &&
                Objects.equals(this.problemDesc, serviceRecord.problemDesc) &&
                Objects.equals(this.customer, serviceRecord.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, serviceDate, type, productId, productCode, productName, buyDate, adornEar, repairDeadline, serviceWay, dealState, finishDate, problemType, linkman, dept, user, serviceType, charge, chargePrice, nextServiceDate, orderFlag, problemTemplate, problemDesc, customer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ServiceRecord {\n");

        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    serviceDate: ").append(toIndentedString(serviceDate)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
        sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
        sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
        sb.append("    buyDate: ").append(toIndentedString(buyDate)).append("\n");
        sb.append("    adornEar: ").append(toIndentedString(adornEar)).append("\n");
        sb.append("    repairDeadline: ").append(toIndentedString(repairDeadline)).append("\n");
        sb.append("    serviceWay: ").append(toIndentedString(serviceWay)).append("\n");
        sb.append("    dealState: ").append(toIndentedString(dealState)).append("\n");
        sb.append("    finishDate: ").append(toIndentedString(finishDate)).append("\n");
        sb.append("    problemType: ").append(toIndentedString(problemType)).append("\n");
        sb.append("    linkman: ").append(toIndentedString(linkman)).append("\n");
        sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
        sb.append("    user: ").append(toIndentedString(user)).append("\n");
        sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
        sb.append("    charge: ").append(toIndentedString(charge)).append("\n");
        sb.append("    chargePrice: ").append(toIndentedString(chargePrice)).append("\n");
        sb.append("    nextServiceDate: ").append(toIndentedString(nextServiceDate)).append("\n");
        sb.append("    orderFlag: ").append(toIndentedString(orderFlag)).append("\n");
        sb.append("    problemTemplate: ").append(toIndentedString(problemTemplate)).append("\n");
        sb.append("    problemDesc: ").append(toIndentedString(problemDesc)).append("\n");
        sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
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

