package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.customer.LinkMan;
import com.tingkelai.domain.customer.SubscribePlan;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 客户预约计划
 */
@ApiModel(description = "客户预约计划")
public class SubscribePlanVO implements BaseVO<SubscribePlan, SubscribePlanVO>{

    @JsonProperty("id")
    @ApiModelProperty(name = "id", value = "id")
    private Long id = null;

    @ApiModelProperty(hidden = true)
    private Long teamId;

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

    @ApiModelProperty(value = "预约类型")
    @JsonProperty("planType")
    private String planType = null;

    @ApiModelProperty(value = "主题")
    @JsonProperty("theme")
    private String theme = null;

    @ApiModelProperty(value = "预约时间")
    @JsonProperty("planDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date planDate = null;

    @ApiModelProperty(value = "处理方式")
    @JsonProperty("dealWay")
    private String dealWay = null;

    @ApiModelProperty(value = "处理类型")
    @JsonProperty("dealType")
    private String dealType = null;

    @ApiModelProperty(value = "关联联系人")
    @JsonProperty("linkman")
    private LinkManVO linkman = null;

    @ApiModelProperty(value = "关联用户")
    @JsonProperty("dept")
    private DeptVO dept = null;

    @ApiModelProperty(value = "关联用户")
    @JsonProperty("user")
    private UserVO user = null;

    @ApiModelProperty(value = "关联客户")
    @JsonProperty("customer")
    private CustomerVO customer = null;


    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }


    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public String getDealWay() {
        return dealWay;
    }

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    public CustomerVO getCustomer() {
        if(customer == null){
            customer = new CustomerVO();
        }
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }

    /**
     * 封装成业务需要的对象
     */
    public SubscribePlan toDTO(){
        return toDTO(this);
    }

    @Override
    public SubscribePlan toDTO(SubscribePlanVO subscribePlanVO) {
        SubscribePlan subscribePlan = new SubscribePlan();
        subscribePlan.setDealType(subscribePlanVO.getDealType());
        subscribePlan.setDealWay(subscribePlanVO.getDealWay());
        subscribePlan.setId(subscribePlanVO.getId());
        subscribePlan.setPlanDate(subscribePlanVO.getPlanDate());
        subscribePlan.setPlanType(subscribePlanVO.getPlanType());
        subscribePlan.setTheme(subscribePlanVO.getTheme());
        subscribePlan.setCustomer(subscribePlanVO.getCustomer().toDTO());
        subscribePlan.setLinkman(subscribePlanVO.getLinkman().toDTO());
        subscribePlan.setDept(subscribePlanVO.getDept().toDTO());
        subscribePlan.setUser(subscribePlanVO.getUser().toDTO());
        subscribePlan.setTeamId(subscribePlanVO.getTeamId());
        return subscribePlan;
    }

    @Override
    public List<SubscribePlan> toDTO(List<SubscribePlanVO> voList) {
        List<SubscribePlan> list = new ArrayList<>();
        for(SubscribePlanVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SubscribePlanVO toVO(SubscribePlan subscribePlan){
        SubscribePlanVO subscribePlanVO = new SubscribePlanVO();
        subscribePlanVO.setDealType(subscribePlan.getDealType());
        subscribePlanVO.setDealWay(subscribePlan.getDealWay());
        subscribePlanVO.setId(subscribePlan.getId());
        subscribePlanVO.setPlanDate(subscribePlan.getPlanDate());
        subscribePlanVO.setPlanType(subscribePlan.getPlanType());
        subscribePlanVO.setTheme(subscribePlan.getTheme());
        subscribePlanVO.setLinkman(new LinkManVO(subscribePlan.getLinkman()));
        subscribePlanVO.setDept(new DeptVO(subscribePlan.getDept()));
        subscribePlanVO.setUser(new UserVO(subscribePlan.getUser()));
        subscribePlanVO.setTeamId(subscribePlan.getTeamId());
        return subscribePlanVO;
    }

    @Override
    public List<SubscribePlanVO> toVO(List<SubscribePlan> list) {
        List<SubscribePlanVO> resList = new ArrayList<>();
        for(SubscribePlan temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}

