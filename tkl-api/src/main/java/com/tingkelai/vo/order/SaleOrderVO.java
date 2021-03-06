package com.tingkelai.vo.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.SaleProductRecord;
import com.tingkelai.domain.customer.SaleRecord;
import com.tingkelai.vo.customer.CustomerVO;
import com.tingkelai.vo.customer.LinkManVO;
import com.tingkelai.vo.customer.SaleProductRecordVO;
import com.tingkelai.vo.customer.SaleRecordVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 销售订单记录
 * 包含项：
 * 1、订单基本信息
 * 2、客户信息
 * 3、销售产品记录
 *
 * 2018-11-27 20:08:57
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "销售订单记录")
public class SaleOrderVO{

    public SaleOrderVO(){

    }

    public SaleOrderVO(SaleRecord saleRecord, List<SaleProductRecord> saleProductRecordList){
        this.saleRecord = new SaleRecordVO(saleRecord);
        SaleProductRecordVO saleProductRecordVO = new SaleProductRecordVO();
        this.saleProductRecordList = saleProductRecordVO.toVO(saleProductRecordList);
    }

    /** 关联主联系人信息 */
    @ApiModelProperty(value = "关联主联系人信息")
    @JsonProperty("linkMan")
    private LinkManVO linkMan;

    /** 销售订单基本信息 */
    @ApiModelProperty(value = "销售订单基本信息")
    @JsonProperty("saleRecord")
    private SaleRecordVO saleRecord;

    /** 销售产品记录list */
    @ApiModelProperty(value = "销售产品记录list")
    @JsonProperty("saleProductRecordList")
    private List<SaleProductRecordVO> saleProductRecordList;

    public LinkManVO getLinkMan() {
        if(linkMan == null){
            linkMan = new LinkManVO();
        }
        return linkMan;
    }

    public void setLinkMan(LinkManVO linkMan) {
        this.linkMan = linkMan;
    }

    public SaleRecordVO getSaleRecord() {
        if(saleRecord == null){
            saleRecord = new SaleRecordVO();
        }
        return saleRecord;
    }

    public void setSaleRecord(SaleRecordVO saleRecord) {
        this.saleRecord = saleRecord;
    }

    public List<SaleProductRecordVO> getSaleProductRecordList() {
        if(saleProductRecordList == null){
            saleProductRecordList = new ArrayList<>();
        }
        return saleProductRecordList;
    }

    public void setSaleProductRecordList(List<SaleProductRecordVO> saleProductRecordList) {
        this.saleProductRecordList = saleProductRecordList;
    }
}

