package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 销售机会
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:42:19
 * @version 1.0
 */
@ApiModel(description = "销售机会")
public class SaleChanceListVO implements BaseVO<SaleChance, SaleChanceListVO>{

    public SaleChanceListVO(){

    }

    public SaleChanceListVO(SaleChance saleChance){
        setId(saleChance.getId());
        setName(saleChance.getName());
        setDept(new DeptVO(saleChance.getDept()));
        setUser(new UserVO(saleChance.getUser()));
        setCustomer(new CustomerVO(saleChance.getCustomer()));
    }

    public SaleChanceListVO(SaleChance saleChance, FollowRecord followRecord){
        setId(saleChance.getId());
        setName(saleChance.getName());
        setDept(new DeptVO(saleChance.getDept()));
        setUser(new UserVO(saleChance.getUser()));
        setCustomer(new CustomerVO(saleChance.getCustomer()));
        if(followRecord != null){
            setFollowRecordVO(new FollowRecordVO(followRecord));
        }
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

    @ApiModelProperty(value = "销售机会名称")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("门店")
    @JsonProperty("dept")
    private DeptVO dept;

    @ApiModelProperty("服务人员")
    @JsonProperty("user")
    private UserVO user;

    @ApiModelProperty("关联客户")
    @JsonProperty("customer")
    private CustomerVO customer;

    @ApiModelProperty("最新的跟进记录")
    @JsonProperty("followRecordVO")
    private FollowRecordVO followRecordVO;

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

    public CustomerVO getCustomer() {
        if(customer == null){
            customer = new CustomerVO();
        }
        return customer;
    }

    public void setCustomer(CustomerVO customer) {
        this.customer = customer;
    }

    public FollowRecordVO getFollowRecordVO() {
        if(followRecordVO == null){
            followRecordVO = new FollowRecordVO();
        }
        return followRecordVO;
    }

    public void setFollowRecordVO(FollowRecordVO followRecordVO) {
        this.followRecordVO = followRecordVO;
    }

    /**
     * 封装成业务需要的对象
     */
    public SaleChance toDTO(){
        return toDTO(this);
    }

    @Override
    public SaleChance toDTO(SaleChanceListVO saleChanceVO) {
        SaleChance saleChance = new SaleChance();
        saleChance.setId(saleChanceVO.getId());
        saleChance.setUser(saleChanceVO.getUser().toDTO());
        saleChance.setDept(saleChanceVO.getDept().toDTO());
        saleChance.setTeamId(saleChanceVO.getTeamId());
        saleChance.setCustomer(saleChanceVO.getCustomer().toDTO());
        saleChance.setName(saleChanceVO.getName());
        return saleChance;
    }

    @Override
    public List<SaleChance> toDTO(List<SaleChanceListVO> voList) {
        List<SaleChance> list = new ArrayList<>();
        for(SaleChanceListVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public SaleChanceListVO toVO(SaleChance saleChance){
        return new SaleChanceListVO(saleChance, saleChance.getFollowRecord());
    }

    @Override
    public List<SaleChanceListVO> toVO(List<SaleChance> list) {
        List<SaleChanceListVO> resList = new ArrayList<>();
        for(SaleChance temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
