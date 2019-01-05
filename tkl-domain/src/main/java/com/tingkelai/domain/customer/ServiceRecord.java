package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.product.Product;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

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

    //==============================================
    //                   基本信息
    //===============================================

    /** 服务编号 */
    @JsonProperty("code")
    @TableField("code")
    private String code = null;

    /** 关联部门 */
    @JsonProperty("dept")
    @TableField(value = "dept_id", el = "dept.id")
    private Dept dept = null;

    /** 关联用户 */
    @JsonProperty("user")
    @TableField(value = "user_id", el = "user.id")
    private User user = null;

    /** 服务日期 */
    @JsonProperty("serviceDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("service_date")
    private Date serviceDate = null;

    /** 下次服务时间 */
    @JsonProperty("nextServiceDate")
    @TableField("next_service_date")
    private String nextServiceDate = null;

    /** 预约标识 */
    @JsonProperty("orderFlag")
    @TableField("order_flag")
    private String orderFlag = null;

    /** 数据所属公司 */
    @JsonProperty("teamId")
    @TableField("team_id")
    private Long teamId;

    //===============================================
    //                 服务产品相关
    //===============================================

    /** 服务产品 */
    @JsonProperty("product")
    @TableField(value = "product_id", el = "product.id")
    private Product product;

    /** 佩戴耳 */
    @JsonProperty("adornEarDict")
    @TableField(value = "adorn_ear_id", el = "adornEarDict.id")
    private DictItem adornEarDict;

    /** 产品来源 */
    @JsonProperty("productSourceDict")
    @TableField(value = "product_source_id", el = "productSourceDict.id")
    private DictItem productSourceDict;

    /**
     * 购买时间
     **/
    @JsonProperty("buyDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("buy_date")
    private Date buyDate = null;

    /**
     * 维护到期时间(保修时间)
     **/
    @JsonProperty("repairDeadline")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("repair_deadline")
    private Date repairDeadline = null;

    /** 是否保修 */
    @JsonProperty("repairFlag")
    @TableField("dict_return_repair_id")
    private String repairFlag;


    //==============================================
    //                   服务情况
    //===============================================

    /** 服务类型 */
    @JsonProperty("serviceTypeDict")
    @TableField(value = "dict_service_type_id", el = "serviceTypeDict.id")
    private DictItem serviceTypeDict;

    /** 服务方式 */
    @JsonProperty("serviceWayDict")
    @TableField(value = "dict_service_way_id", el = "serviceWayDict.id")
    private DictItem serviceWayDict;

    /**  关联联系人 */
    @JsonProperty("linkman")
    @TableField(value = "linkman_id", el = "linkman.id")
    private LinkMan linkman;

    /** 问题类型 */
    @JsonProperty("problemTypeDict")
    @TableField(value = "dict_problem_type_id", el = "problemTypeDict.id")
    private DictItem problemTypeDict;

    /** 问题模板 */
    @JsonProperty("problemTemplateDict")
    @TableField(value = "dict_problem_template_id", el = "problemTemplateDict.id")
    private DictItem problemTemplateDict;

    /** 问题描述 */
    @JsonProperty("problemDesc")
    @TableField("problem_desc")
    private String problemDesc;


    //==============================================
    //                   处理情况
    //===============================================
    /** 处理阶段(处理状态) */
    @JsonProperty("dealStateDict")
    @TableField(value = "dict_deal_state_id", el = "dealStateDict.id")
    private DictItem dealStateDict;

    /** 是否返修 */
    @JsonProperty("returnRepairDict")
    @TableField(value = "dict_return_repair_id", el = "returnRepairDict.id")
    private DictItem returnRepairDict;

    /** 完成时间 */
    @JsonProperty("finishDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("finish_date")
    private Date finishDate = null;

    /** 处理模板 */
    @JsonProperty("dealTemplateDict")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "dict_deal_template_id", el = "dealTemplateDict.id")
    private DictItem dealTemplateDict;

    /** 是否收费 */
    @JsonProperty("chargeDict")
    @TableField(value = "dict_charge_id", el = "chargeDict.id")
    private DictItem chargeDict;

    /** 收费金额 */
    @JsonProperty("chargePrice")
    @TableField("charge_price")
    private Double chargePrice;

    /** 处理结果 */
    @JsonProperty("dealResult")
    @TableField("deal_result")
    private String dealResult;

    /**
     * 关联客户
     **/
    @JsonProperty("customer")
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }


    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public LinkMan getLinkman() {
        if(linkman == null){
            linkman = new LinkMan();
        }
        return linkman;
    }

    public void setLinkman(LinkMan linkman) {
        this.linkman = linkman;
    }

    public Dept getDept() {
        if(dept == null){
            dept = new Dept();
        }
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public User getUser() {
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public Customer getCustomer() {
        if(customer == null){
            customer = new Customer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        if(product == null){
            product = new Product();
        }
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public DictItem getAdornEarDict() {
        if(adornEarDict == null){
            adornEarDict = new DictItem();
        }
        return adornEarDict;
    }

    public void setAdornEarDict(DictItem adornEarDict) {
        this.adornEarDict = adornEarDict;
    }

    public DictItem getProductSourceDict() {
        if(productSourceDict == null){
            productSourceDict = new DictItem();
        }
        return productSourceDict;
    }

    public void setProductSourceDict(DictItem productSourceDict) {
        this.productSourceDict = productSourceDict;
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

    public DictItem getServiceTypeDict() {
        if(serviceTypeDict == null){
            serviceTypeDict = new DictItem();
        }
        return serviceTypeDict;
    }

    public void setServiceTypeDict(DictItem serviceTypeDict) {
        this.serviceTypeDict = serviceTypeDict;
    }

    public DictItem getServiceWayDict() {
        if(serviceWayDict == null){
            serviceWayDict = new DictItem();
        }
        return serviceWayDict;
    }

    public void setServiceWayDict(DictItem serviceWayDict) {
        this.serviceWayDict = serviceWayDict;
    }

    public DictItem getProblemTypeDict() {
        if(problemTypeDict == null){
            problemTypeDict = new DictItem();
        }
        return problemTypeDict;
    }

    public void setProblemTypeDict(DictItem problemTypeDict) {
        this.problemTypeDict = problemTypeDict;
    }

    public DictItem getProblemTemplateDict() {
        if(problemTemplateDict == null){
            problemTemplateDict = new DictItem();
        }
        return problemTemplateDict;
    }

    public void setProblemTemplateDict(DictItem problemTemplateDict) {
        this.problemTemplateDict = problemTemplateDict;
    }

    public DictItem getDealStateDict() {
        if(dealStateDict == null){
            dealStateDict = new DictItem();
        }
        return dealStateDict;
    }

    public void setDealStateDict(DictItem dealStateDict) {
        this.dealStateDict = dealStateDict;
    }

    public DictItem getReturnRepairDict() {
        if(returnRepairDict == null){
            returnRepairDict = new DictItem();
        }
        return returnRepairDict;
    }

    public void setReturnRepairDict(DictItem returnRepairDict) {
        this.returnRepairDict = returnRepairDict;
    }

    public DictItem getDealTemplateDict() {
        if(dealTemplateDict == null){
            dealTemplateDict = new DictItem();
        }
        return dealTemplateDict;
    }

    public void setDealTemplateDict(DictItem dealTemplateDict) {
        this.dealTemplateDict = dealTemplateDict;
    }

    public DictItem getChargeDict() {
        if(chargeDict == null){
            chargeDict = new DictItem();
        }
        return chargeDict;
    }

    public void setChargeDict(DictItem chargeDict) {
        this.chargeDict = chargeDict;
    }

    public Double getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(Double chargePrice) {
        this.chargePrice = chargePrice;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
    }
}

