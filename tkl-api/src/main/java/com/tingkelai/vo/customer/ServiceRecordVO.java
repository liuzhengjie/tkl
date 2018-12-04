package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户服务记录
 *
 * @author liuzhengjie
 * @date 2018-11-27 20:14:43
 * @version 1.0
 */
@ApiModel(description = "客户服务记录")
public class ServiceRecordVO implements BaseVO<ServiceRecord, ServiceRecordVO>{

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

    @JsonProperty("serviceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date serviceDate = null;

    @JsonProperty("type")
    private String type = null;

    @JsonProperty("productId")
    private String productId = null;

    @JsonProperty("productCode")
    private String productCode = null;

    @JsonProperty("productName")
    private String productName = null;

    @JsonProperty("buyDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date buyDate = null;

    @JsonProperty("adornEar")
    private String adornEar = null;

    @JsonProperty("repairDeadline")
    private String repairDeadline = null;

    @JsonProperty("serviceWay")
    private String serviceWay = null;

    @JsonProperty("dealState")
    private String dealState = null;

    @JsonProperty("finishDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date finishDate = null;

    @JsonProperty("problemType")
    private String problemType = null;

    @JsonProperty("serviceType")
    private String serviceType = null;

    @JsonProperty("charge")
    private String charge = null;

    @JsonProperty("chargePrice")
    private String chargePrice = null;

    @JsonProperty("nextServiceDate")
    private String nextServiceDate = null;

    @JsonProperty("orderFlag")
    private String orderFlag = null;

    @JsonProperty("problemTemplate")
    private String problemTemplate = null;

    @JsonProperty("problemDesc")
    private String problemDesc = null;

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

    /**
     * 封装成业务需要的对象
     */
    public ServiceRecord toDTO(){
        ServiceRecord serviceRecord = new ServiceRecord();
        serviceRecord.setAdornEar(getAdornEar());
        serviceRecord.setBuyDate(getBuyDate());
        serviceRecord.setCharge(getCharge());
        serviceRecord.setChargePrice(getChargePrice());
        serviceRecord.setCode(getCode());
        serviceRecord.setDealState(getDealState());
        serviceRecord.setFinishDate(getFinishDate());
        serviceRecord.setId(getId());
        serviceRecord.setNextServiceDate(getNextServiceDate());
        serviceRecord.setProblemDesc(getProblemDesc());
        serviceRecord.setProductCode(getProductCode());
        serviceRecord.setProblemTemplate(getProblemTemplate());
        serviceRecord.setProductCode(getProductCode());
        serviceRecord.setProductId(getProductId());
        serviceRecord.setProductName(getProductName());
        serviceRecord.setRepairDeadline(getRepairDeadline());
        serviceRecord.setServiceDate(getServiceDate());
        serviceRecord.setServiceType(getServiceType());
        serviceRecord.setServiceWay(getServiceWay());
        serviceRecord.setType(getType());
        return serviceRecord;
    }

    @Override
    public ServiceRecord toDTO(ServiceRecordVO serviceRecordVO) {
        return toDTO(this);
    }

    @Override
    public List<ServiceRecord> toDTO(List<ServiceRecordVO> voList) {
        List<ServiceRecord> list = new ArrayList<>();
        for(ServiceRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public ServiceRecordVO toVO(ServiceRecord serviceRecord){
        ServiceRecordVO serviceRecordVO = new ServiceRecordVO();
        serviceRecordVO.setAdornEar(serviceRecord.getAdornEar());
        serviceRecordVO.setBuyDate(serviceRecord.getBuyDate());
        serviceRecordVO.setCharge(serviceRecord.getCharge());
        serviceRecordVO.setChargePrice(serviceRecord.getChargePrice());
        serviceRecordVO.setCode(serviceRecord.getCode());
        serviceRecordVO.setDealState(serviceRecord.getDealState());
        serviceRecordVO.setFinishDate(serviceRecord.getFinishDate());
        serviceRecordVO.setId(serviceRecord.getId());
        serviceRecordVO.setNextServiceDate(serviceRecord.getNextServiceDate());
        serviceRecordVO.setProblemDesc(serviceRecord.getProblemDesc());
        serviceRecordVO.setProductCode(serviceRecord.getProductCode());
        serviceRecordVO.setProblemTemplate(serviceRecord.getProblemTemplate());
        serviceRecordVO.setProductCode(serviceRecord.getProductCode());
        serviceRecordVO.setProductId(serviceRecord.getProductId());
        serviceRecordVO.setProductName(serviceRecord.getProductName());
        serviceRecordVO.setRepairDeadline(serviceRecord.getRepairDeadline());
        serviceRecordVO.setServiceDate(serviceRecord.getServiceDate());
        serviceRecordVO.setServiceType(serviceRecord.getServiceType());
        serviceRecordVO.setServiceWay(serviceRecord.getServiceWay());
        serviceRecordVO.setType(serviceRecord.getType());
        return serviceRecordVO;
    }

    @Override
    public List<ServiceRecordVO> toVO(List<ServiceRecord> list) {
        List<ServiceRecordVO> resList = new ArrayList<>();
        for(ServiceRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

