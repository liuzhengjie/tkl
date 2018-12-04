package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleChance;
import com.tingkelai.vo.BaseVO;
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
public class SaleChanceVO implements BaseVO<SaleChance, SaleChanceVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
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
    private String nextContactDate = null;

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
    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
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
        SaleChanceVO saleChanceVO = new SaleChanceVO();
        saleChanceVO.setDiscoverDate(saleChance.getDiscoverDate());
        saleChanceVO.setId(saleChance.getId());
        saleChanceVO.setName(saleChance.getName());
        saleChanceVO.setNextContactDate(saleChance.getNextContactDate());
        saleChanceVO.setOrderFlag(saleChance.getOrderFlag());
        return saleChanceVO;
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
