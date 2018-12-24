package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
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
        setDiscoverDate(saleChance.getDiscoverDate());
        setId(saleChance.getId());
        setName(saleChance.getName());
        setNextContactDate(saleChance.getNextContactDate());
        setOrderFlag(saleChance.getOrderFlag());
        setDept(new DeptVO(saleChance.getDept()));
        setUser(new UserVO(saleChance.getUser()));
        setCustomer(new CustomerVO(saleChance.getCustomer()));
        setLinkMan(new LinkManVO(saleChance.getLinkMan()));
        setLastFollowFate(saleChance.getLastFollowFate());
        setPhaseDict(new DictItemVO(saleChance.getPhaseDict()));
    }

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(hidden = true)
    private Long teamId;

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

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("orderFlag")
    private String orderFlag = null;

    @JsonProperty("discoverDate")
    private String discoverDate = null;

    @JsonProperty("nextContactDate")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date nextContactDate = null;

    @ApiModelProperty("服务人员")
    private UserVO user;

    @ApiModelProperty("门店")
    private DeptVO dept;

    @ApiModelProperty("关联客户")
    private CustomerVO customer;

    /** 关联联系人 */
    @ApiModelProperty("联系人")
    private LinkManVO linkMan;

    /** 目前阶段 */
    @ApiModelProperty("目前阶段")
    private DictItemVO phaseDict;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("最后跟进时间")
    private Date lastFollowFate = null;

    /**
     * 销售机会名称
     * @return name
     **/
    @ApiModelProperty(value = "销售机会名称")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 预约计划标识
     * @return orderFlag
     **/
    @ApiModelProperty(value = "预约计划标识")
    public String getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(String orderFlag) {
        this.orderFlag = orderFlag;
    }


    /**
     * 下次联系日期
     * @return nextContactDate
     **/
    @ApiModelProperty(value = "下次联系日期")
    public Date getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(Date nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    /**
     * 发现日期
     * @return discoverDate
     **/
    @ApiModelProperty(value = "发现日期")
    public String getDiscoverDate() {
        return discoverDate;
    }

    public void setDiscoverDate(String discoverDate) {
        this.discoverDate = discoverDate;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public DeptVO getDept() {
        return dept;
    }

    public void setDept(DeptVO dept) {
        this.dept = dept;
    }

    public CustomerVO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }

    public LinkManVO getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(LinkManVO linkMan) {
        this.linkMan = linkMan;
    }

    public DictItemVO getPhaseDict() {
        return phaseDict;
    }

    public void setPhaseDict(DictItemVO phaseDict) {
        this.phaseDict = phaseDict;
    }

    public Date getLastFollowFate() {
        return lastFollowFate;
    }

    public void setLastFollowFate(Date lastFollowFate) {
        this.lastFollowFate = lastFollowFate;
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
        saleChance.setDiscoverDate(saleChanceVO.getDiscoverDate());
        saleChance.setId(saleChanceVO.getId());
        saleChance.setName(saleChanceVO.getName());
        saleChance.setNextContactDate(saleChanceVO.getNextContactDate());
        saleChance.setOrderFlag(saleChanceVO.getOrderFlag());
        if(saleChanceVO.getCustomer() != null){
            saleChance.setCustomer(saleChanceVO.getCustomer().toDTO());
        }
        if(saleChance.getPhaseDict() != null){
            saleChance.setCustomer(saleChanceVO.getCustomer().toDTO());
        }
        if(saleChance.getUser() != null){
            saleChance.setUser(saleChanceVO.getUser().toDTO());
        }
        if(saleChance.getDept() != null){
            saleChance.setDept(saleChanceVO.getDept().toDTO());
        }
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
