package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 销售机会
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:42:19
 * @version 1.0
 */
@ApiModel(description = "销售机会")
public class SaleChanceVO implements BaseVO<SaleChance, SaleChanceVO>{

    public SaleChanceVO(){

    }

    public SaleChanceVO(SaleChance saleChance){
        setId(saleChance.getId());
        setDept(new DeptVO(saleChance.getDept()));
        setUser(new UserVO(saleChance.getUser()));
        setCustomer(new CustomerVO(saleChance.getCustomer()));
        setOrderFlag(saleChance.getOrderFlag());
        setName(saleChance.getName());
        setDiscoverDate(saleChance.getDiscoverDate());
        setNextContactDate(saleChance.getNextContactDate());
        setPlanSaleDate(saleChance.getPlanSaleDate());
        setPlanSaleMoney(saleChance.getPlanSaleMoney());
    }

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

    @ApiModelProperty(value = "销售机会名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("门店")
    @JsonProperty("dept")
    private DeptVO dept;

    @ApiModelProperty("服务人员")
    @JsonProperty("user")
    private UserVO user;

    @ApiModelProperty(value = "发现日期")
    @JsonProperty("discoverDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date discoverDate;

    @JsonProperty("planSaleDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计日期")
    private Date planSaleDate;

    @JsonProperty("planSaleMoney")
    @ApiModelProperty(value = "预计销售额")
    private String planSaleMoney;

    @ApiModelProperty(value = "下次联系日期")
    @JsonProperty("nextContactDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date nextContactDate;

    @ApiModelProperty(value = "预约计划标识")
    @JsonProperty("orderFlag")
    private String orderFlag;

    @ApiModelProperty("关联客户")
    @JsonProperty("customer")
    private CustomerVO customer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDiscoverDate() {
        return discoverDate;
    }

    public void setDiscoverDate(Date discoverDate) {
        this.discoverDate = discoverDate;
    }

    public Date getPlanSaleDate() {
        return planSaleDate;
    }

    public void setPlanSaleDate(Date planSaleDate) {
        this.planSaleDate = planSaleDate;
    }

    public String getPlanSaleMoney() {
        return planSaleMoney;
    }

    public void setPlanSaleMoney(String planSaleMoney) {
        this.planSaleMoney = planSaleMoney;
    }

    public Date getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(Date nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
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
    public SaleChance toDTO(){
        return toDTO(this);
    }

    @Override
    public SaleChance toDTO(SaleChanceVO saleChanceVO) {
        SaleChance saleChance = new SaleChance();
        saleChance.setId(saleChanceVO.getId());
        saleChance.setDept(saleChanceVO.getDept().toDTO());
        saleChance.setUser(saleChanceVO.getUser().toDTO());
        saleChance.setTeamId(saleChanceVO.getTeamId());
        saleChance.setCustomer(saleChanceVO.getCustomer().toDTO());
        saleChance.setOrderFlag(saleChanceVO.getOrderFlag());
        saleChance.setName(saleChanceVO.getName());
        saleChance.setDiscoverDate(saleChanceVO.getDiscoverDate());
        saleChance.setNextContactDate(saleChanceVO.getNextContactDate());
        saleChance.setPlanSaleDate(saleChanceVO.getPlanSaleDate());
        saleChance.setPlanSaleMoney(saleChanceVO.getPlanSaleMoney());
        saleChance.setTeamId(saleChanceVO.getTeamId());
        return saleChance;
    }

    @Override
    public List<SaleChance> toDTO(List<SaleChanceVO> voList) {
        List<SaleChance> list = new ArrayList<>();
        for(SaleChanceVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleChanceVO toVO(SaleChance saleChance){
        return new SaleChanceVO(saleChance);
    }

    @Override
    public List<SaleChanceVO> toVO(List<SaleChance> list) {
        List<SaleChanceVO> resList = new ArrayList<>();
        for(SaleChance temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
