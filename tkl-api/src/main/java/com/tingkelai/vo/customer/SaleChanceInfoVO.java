package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.FollowRecord;
import com.tingkelai.domain.customer.SaleChance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 销售机会全部信息
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:42:19
 * @version 1.0
 */
@ApiModel(description = "销售机会（包含跟进记录）")
public class SaleChanceInfoVO{

    public SaleChanceInfoVO(){

    }

    public SaleChanceInfoVO(SaleChance saleChance){

    }

    @ApiModelProperty(hidden = true)
    private Long teamId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    /** 销售机会基本信息 */
    @ApiModelProperty(value = "销售机会基本信息")
    @JsonProperty("saleChance")
    private SaleChanceVO saleChance;

    /** 销售记录跟进记录列表信息 */
    @ApiModelProperty(value = "销售记录跟进记录列表信息")
    @JsonProperty("inventoryExtInfoVOList")
    private List<FollowRecordVO> followRecordVOList;

    public SaleChanceVO getSaleChance() {
        return saleChance;
    }

    public void setSaleChance(SaleChanceVO saleChance) {
        this.saleChance = saleChance;
    }

    public List<FollowRecordVO> getFollowRecordVOList() {
        return followRecordVOList;
    }

    public void setFollowRecordVOList(List<FollowRecordVO> followRecordVOList) {
        this.followRecordVOList = followRecordVOList;
    }


    /** 获取销售机会 */
    public SaleChance gainSaleChance(){
        return saleChance.toDTO();
    }

    /** 获取跟进记录 */
    public List<FollowRecord> gainFollowRecordList(){
        FollowRecordVO followRecordVO = new FollowRecordVO();
        return followRecordVO.toDTO(followRecordVOList);
    }
}
