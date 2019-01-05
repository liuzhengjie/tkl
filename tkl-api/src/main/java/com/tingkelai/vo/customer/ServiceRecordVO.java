package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.ServiceRecord;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import com.tingkelai.vo.product.ProductVO;
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

    public ServiceRecordVO(){

    }

    public ServiceRecordVO(ServiceRecord serviceRecord){
        // 基本信息
        setId(serviceRecord.getId());
        setTeamId(serviceRecord.getTeamId());
        /** 服务编号 */
        setCode(serviceRecord.getCode());
        /** 关联部门 */
        setDept(new DeptVO(serviceRecord.getDept()));
        /** 关联用户 */
        setUser(new UserVO(serviceRecord.getUser()));
        /** 服务日期 */
        setServiceDate(serviceRecord.getServiceDate());
        /** 下次服务时间 */
        setNextServiceDate(serviceRecord.getNextServiceDate());
        /** 预约标识 */
        setOrderFlag(serviceRecord.getOrderFlag());

        /** 服务产品 */
        setProduct(new ProductVO(serviceRecord.getProduct()));
        /** 佩戴耳 */
        setAdornEarDict(new DictItemVO(serviceRecord.getAdornEarDict()));
        /** 产品来源 */
        setProductSourceDict(new DictItemVO(serviceRecord.getProductSourceDict()));
        /** 购买时间 */
        setBuyDate(serviceRecord.getBuyDate());
        /** 维护到期时间(保修时间) */
        setRepairDeadline(serviceRecord.getRepairDeadline());
        /** 是否保修 */
        setRepairFlag(serviceRecord.getRepairFlag());


        /** 服务类型 */
        setServiceTypeDict(new DictItemVO(serviceRecord.getServiceTypeDict()));
        /** 服务方式 */
        setServiceWayDict(new DictItemVO(serviceRecord.getServiceWayDict()));
        /**  关联联系人 */
        setLinkman(new LinkManVO(serviceRecord.getLinkman()));
        /** 问题类型 */
        setProblemTypeDict(new DictItemVO(serviceRecord.getProblemTypeDict()));
        /** 问题模板 */
        setProblemTemplateDict(new DictItemVO(serviceRecord.getProblemTemplateDict()));
        /** 问题描述 */
        setProblemDesc(serviceRecord.getProblemDesc());

        /** 处理阶段(处理状态) */
        setDealStateDict(new DictItemVO(serviceRecord.getDealStateDict()));
        /** 是否返修 */
        setReturnRepairDict(new DictItemVO(serviceRecord.getReturnRepairDict()));
        /** 完成时间 */
        setFinishDate(serviceRecord.getFinishDate());
        /** 完成时间 */
        setDealTemplateDict(new DictItemVO(serviceRecord.getDealTemplateDict()));
        /** 是否收费 */
        setChargeDict(new DictItemVO(serviceRecord.getChargeDict()));
        /** 收费金额 */
        setChargePrice(serviceRecord.getChargePrice());
        /** 关联客户 */
        setCustomer(new CustomerVO(serviceRecord.getCustomer()));
        /** 处理结果 */
        setDealResult(serviceRecord.getDealResult());
    }

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("teamId")
    @ApiModelProperty(hidden = true)
    private Long teamId = null;

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

    //==============================================
    //                   基本信息
    //===============================================

    /** 服务编号 */
    @JsonProperty("code")
    @ApiModelProperty(value = "服务编号")
    private String code = null;

    /** 关联部门 */
    @JsonProperty("dept")
    @ApiModelProperty(value = "关联部门")
    private DeptVO dept = null;

    /** 关联用户 */
    @JsonProperty("user")
    @ApiModelProperty(value = "关联用户")
    private UserVO user = null;

    /** 服务日期 */
    @JsonProperty("serviceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "服务日期")
    private Date serviceDate = null;

    /** 下次服务时间 */
    @JsonProperty("nextServiceDate")
    @ApiModelProperty(value = "下次服务时间")
    private String nextServiceDate = null;

    /** 预约标识 */
    @JsonProperty("orderFlag")
    @ApiModelProperty(value = "预约标识")
    private String orderFlag = null;

    //===============================================
    //                 服务产品相关
    //===============================================

    /** 服务产品 */
    @JsonProperty("product")
    @ApiModelProperty(value = "服务产品")
    private ProductVO product;

    /** 佩戴耳 */
    @JsonProperty("adornEarDict")
    @ApiModelProperty(value = "佩戴耳")
    private DictItemVO adornEarDict;

    /** 产品来源 */
    @JsonProperty("productSourceDict")
    @ApiModelProperty(value = "产品来源")
    private DictItemVO productSourceDict;

    /** 购买时间 */
    @JsonProperty("buyDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "购买时间")
    private Date buyDate = null;

    /** 维护到期时间(保修时间) */
    @JsonProperty("repairDeadline")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "维护到期时间(保修时间)")
    private Date repairDeadline = null;

    /** 是否保修 */
    @JsonProperty("repairFlag")
    @ApiModelProperty(value = "是否保修")
    private String repairFlag;

    //==============================================
    //                   服务情况
    //===============================================

    /** 服务类型 */
    @JsonProperty("serviceTypeDict")
    @ApiModelProperty(value = "服务类型")
    private DictItemVO serviceTypeDict;

    /** 服务方式 */
    @JsonProperty("serviceWayDict")
    @ApiModelProperty(value = "服务方式")
    private DictItemVO serviceWayDict;

    /**  关联联系人 */
    @JsonProperty("linkman")
    @ApiModelProperty(value = "关联联系人")
    private LinkManVO linkman;

    /** 问题类型 */
    @JsonProperty("problemTypeDict")
    @ApiModelProperty(value = "问题类型")
    private DictItemVO problemTypeDict;

    /** 问题模板 */
    @JsonProperty("problemTemplateDict")
    @ApiModelProperty(value = "问题模板")
    private DictItemVO problemTemplateDict;

    /** 问题描述 */
    @JsonProperty("problemDesc")
    @ApiModelProperty(value = "问题描述")
    private String problemDesc;


    //==============================================
    //                   处理情况
    //===============================================
    /** 处理阶段(处理状态) */
    @JsonProperty("dealStateDict")
    @ApiModelProperty(value = "处理阶段(处理状态)")
    private DictItemVO dealStateDict;

    /** 是否返修 */
    @JsonProperty("returnRepairDict")
    @ApiModelProperty(value = "是否返修")
    private DictItemVO returnRepairDict;

    /** 完成时间 */
    @JsonProperty("finishDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间")
    private Date finishDate = null;

    /** 完成时间 */
    @JsonProperty("dealTemplateDict")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间")
    private DictItemVO dealTemplateDict;

    /** 是否收费 */
    @JsonProperty("chargeDict")
    @ApiModelProperty(value = "是否收费")
    private DictItemVO chargeDict;

    /** 收费金额 */
    @JsonProperty("chargePrice")
    @ApiModelProperty(value = "收费金额")
    private Double chargePrice;

    /** 关联客户 */
    @JsonProperty("customer")
    @ApiModelProperty(value = "关联客户")
    private CustomerVO customer;

    /** 处理结果 */
    @JsonProperty("dealResult")
    @ApiModelProperty(value = "处理结果")
    private String dealResult;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DeptVO getDept() {
        if(dept == null){
            dept = new DeptVO();
        }
        return dept;
    }

    public void setDept(DeptVO dept) {
        this.dept = dept;
    }

    public UserVO getUser() {
        if(user == null){
            user = new UserVO();
        }
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(String nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }

    public ProductVO getProduct() {
        if(product == null){
            product = new ProductVO();
        }
        return product;
    }

    public void setProduct(ProductVO product) {
        this.product = product;
    }

    public DictItemVO getAdornEarDict() {
        if(adornEarDict == null){
            adornEarDict = new DictItemVO();
        }
        return adornEarDict;
    }

    public void setAdornEarDict(DictItemVO adornEarDict) {
        this.adornEarDict = adornEarDict;
    }

    public DictItemVO getProductSourceDict() {
        if(productSourceDict == null){
            productSourceDict = new DictItemVO();
        }
        return productSourceDict;
    }

    public void setProductSourceDict(DictItemVO productSourceDict) {
        this.productSourceDict = productSourceDict;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getRepairDeadline() {
        return repairDeadline;
    }

    public void setRepairDeadline(Date repairDeadline) {
        this.repairDeadline = repairDeadline;
    }

    public String getRepairFlag() {
        return repairFlag;
    }

    public void setRepairFlag(String repairFlag) {
        this.repairFlag = repairFlag;
    }

    public DictItemVO getServiceTypeDict() {
        if(serviceTypeDict == null){
            serviceTypeDict = new DictItemVO();
        }
        return serviceTypeDict;
    }

    public void setServiceTypeDict(DictItemVO serviceTypeDict) {
        this.serviceTypeDict = serviceTypeDict;
    }

    public DictItemVO getServiceWayDict() {
        if(serviceWayDict == null){
            serviceWayDict = new DictItemVO();
        }
        return serviceWayDict;
    }

    public void setServiceWayDict(DictItemVO serviceWayDict) {
        this.serviceWayDict = serviceWayDict;
    }

    public LinkManVO getLinkman() {
        if(linkman == null){
            linkman = new LinkManVO();
        }
        return linkman;
    }

    public void setLinkman(LinkManVO linkman) {
        this.linkman = linkman;
    }

    public DictItemVO getProblemTypeDict() {
        if(problemTypeDict == null){
            problemTypeDict = new DictItemVO();
        }
        return problemTypeDict;
    }

    public void setProblemTypeDict(DictItemVO problemTypeDict) {
        this.problemTypeDict = problemTypeDict;
    }

    public DictItemVO getProblemTemplateDict() {
        if(problemTemplateDict == null){
            problemTemplateDict = new DictItemVO();
        }
        return problemTemplateDict;
    }

    public void setProblemTemplateDict(DictItemVO problemTemplateDict) {
        this.problemTemplateDict = problemTemplateDict;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public DictItemVO getDealStateDict() {
        if(dealStateDict == null){
            dealStateDict = new DictItemVO();
        }
        return dealStateDict;
    }

    public void setDealStateDict(DictItemVO dealStateDict) {
        this.dealStateDict = dealStateDict;
    }

    public DictItemVO getReturnRepairDict() {
        if(returnRepairDict == null){
            returnRepairDict = new DictItemVO();
        }
        return returnRepairDict;
    }

    public void setReturnRepairDict(DictItemVO returnRepairDict) {
        this.returnRepairDict = returnRepairDict;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public DictItemVO getDealTemplateDict() {
        if(dealTemplateDict == null){
            dealTemplateDict = new DictItemVO();
        }
        return dealTemplateDict;
    }

    public void setDealTemplateDict(DictItemVO dealTemplateDict) {
        this.dealTemplateDict = dealTemplateDict;
    }

    public DictItemVO getChargeDict() {
        if(chargeDict == null){
            chargeDict = new DictItemVO();
        }
        return chargeDict;
    }

    public void setChargeDict(DictItemVO chargeDict) {
        this.chargeDict = chargeDict;
    }

    public Double getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(Double chargePrice) {
        this.chargePrice = chargePrice;
    }

    public CustomerVO getCustomer() {
        if(customer == null){
            customer = new CustomerVO();
        }
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }

    /**
     * 封装成业务需要的对象
     */
    public ServiceRecord toDTO(){
        return toDTO(this);
    }

    @Override
    public ServiceRecord toDTO(ServiceRecordVO serviceRecordVO) {
        ServiceRecord serviceRecord = new ServiceRecord();
        // 基本信息
        serviceRecord.setId(serviceRecordVO.getId());
        serviceRecord.setTeamId(serviceRecordVO.getTeamId());
        /** 服务编号 */
        serviceRecord.setCode(serviceRecordVO.getCode());
        /** 关联部门 */
        serviceRecord.setDept(serviceRecordVO.getDept().toDTO());
        /** 关联用户 */
        serviceRecord.setUser(serviceRecordVO.getUser().toDTO());
        /** 服务日期 */
        serviceRecord.setServiceDate(serviceRecordVO.getServiceDate());
        /** 下次服务时间 */
        serviceRecord.setNextServiceDate(serviceRecordVO.getNextServiceDate());
        /** 预约标识 */
        serviceRecord.setOrderFlag(serviceRecordVO.getOrderFlag());

        /** 服务产品 */
        serviceRecord.setProduct(serviceRecordVO.getProduct().toDTO());
        /** 佩戴耳 */
        serviceRecord.setAdornEarDict(serviceRecordVO.getAdornEarDict().toDTO());
        /** 产品来源 */
        serviceRecord.setProductSourceDict(serviceRecordVO.getProductSourceDict().toDTO());
        /** 购买时间 */
        serviceRecord.setBuyDate(serviceRecordVO.getBuyDate());
        /** 维护到期时间(保修时间) */
        serviceRecord.setRepairDeadline(serviceRecordVO.getRepairDeadline());
        /** 是否保修 */
        serviceRecord.setRepairFlag(serviceRecordVO.getRepairFlag());


        /** 服务类型 */
        serviceRecord.setServiceTypeDict(serviceRecordVO.getServiceTypeDict().toDTO());
        /** 服务方式 */
        serviceRecord.setServiceWayDict(serviceRecordVO.getServiceWayDict().toDTO());
        /**  关联联系人 */
        serviceRecord.setLinkman(serviceRecordVO.getLinkman().toDTO());
        /** 问题类型 */
        serviceRecord.setProblemTypeDict(serviceRecordVO.getProblemTypeDict().toDTO());
        /** 问题模板 */
        serviceRecord.setProblemTemplateDict(serviceRecordVO.getProblemTemplateDict().toDTO());
        /** 问题描述 */
        serviceRecord.setProblemDesc(serviceRecordVO.getProblemDesc());

        /** 处理阶段(处理状态) */
        serviceRecord.setDealStateDict(serviceRecordVO.getDealStateDict().toDTO());
        /** 是否返修 */
        serviceRecord.setReturnRepairDict(serviceRecordVO.getReturnRepairDict().toDTO());
        /** 完成时间 */
        serviceRecord.setFinishDate(serviceRecordVO.getFinishDate());
        /** 完成时间 */
        serviceRecord.setDealTemplateDict(serviceRecordVO.getDealTemplateDict().toDTO());
        /** 是否收费 */
        serviceRecord.setChargeDict(serviceRecordVO.getChargeDict().toDTO());
        /** 收费金额 */
        serviceRecord.setChargePrice(serviceRecordVO.getChargePrice());

        serviceRecord.setDealResult(serviceRecordVO.getDealResult());

        /** 关联客户 */
        serviceRecord.setCustomer(serviceRecordVO.getCustomer().toDTO());
        return serviceRecord;
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
        return new ServiceRecordVO(serviceRecord);
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

