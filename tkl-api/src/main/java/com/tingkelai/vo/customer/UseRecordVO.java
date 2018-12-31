package com.tingkelai.vo.customer;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.UseRecord;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.dict.DictItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用效果记录
 */
@ApiModel(description = "客户主表")
public class UseRecordVO implements BaseVO<UseRecord, UseRecordVO> {

    public UseRecordVO(){

    }

    public UseRecordVO(UseRecord useRecord){
        setId(useRecord.getId());
        setCustomerVO(new CustomerVO(useRecord.getCustomer()));
        setDictBrand(new DictItemVO(useRecord.getDictBrand()));
        setDictEar(new DictItemVO(useRecord.getDictEar()));
        setDictMachineType(new DictItemVO(useRecord.getDictMachineType()));
        setDictUseOrNo(new DictItemVO((useRecord.getDictUseOrNo())));
        setDictUseResult(new DictItemVO(useRecord.getDictUseResult()));
        setDictUseYear(new DictItemVO(useRecord.getDictUseYear()));
        setMachineCode(useRecord.getMachineCode());
    }

    /** 主键 */
    @JsonProperty("id")
    @ApiModelProperty(value = "主键")
    private Long id;

    /** 关联客户 */
    @JsonProperty("customerVO")
    @ApiModelProperty(value = "关联客户")
    private CustomerVO customerVO;

    /** 数据所属公司 */
    @ApiModelProperty(hidden = true)
    private Long teamId;

    /** 机器类型 */
    @JsonProperty("dictMachineType")
    @ApiModelProperty(value = "机器类型")
    private DictItemVO dictMachineType;

    /** 品牌 */
    @JsonProperty("dictBrand")
    @ApiModelProperty(value = "品牌")
    private DictItemVO dictBrand;

    /** 是否还在使用 */
    @JsonProperty("dictUseOrNo")
    @ApiModelProperty(value = "是否还在使用")
    private DictItemVO dictUseOrNo;

    /** 左右耳 */
    @JsonProperty("dictEar")
    @ApiModelProperty(value = "左右耳")
    private DictItemVO dictEar;

    /** 使用年限 */
    @JsonProperty("dictUseYear")
    @ApiModelProperty(value = "使用年限")
    private DictItemVO dictUseYear;

    /** 使用效果 */
    @JsonProperty("dictUseResult")
    @ApiModelProperty(value = "使用效果")
    private DictItemVO dictUseResult;

    /** 机器编号 */
    @JsonProperty("machineCode")
    @ApiModelProperty(value = "机器编号")
    private String machineCode;

    public CustomerVO getCustomerVO() {
        if(customerVO == null){
            customerVO = new CustomerVO();
        }
        return customerVO;
    }

    public void setCustomerVO(CustomerVO customerVO) {
        this.customerVO = customerVO;
    }

    public Long getTeamId() {
        return teamId;
    }

    @Override
    public UseRecord toDTO() {
        return toDTO(this);
    }

    @Override
    public UseRecord toDTO(UseRecordVO useRecordVO) {
        UseRecord useRecord = new UseRecord();
        useRecord.setId(useRecordVO.getId());
        if(useRecordVO.getCustomerVO() != null){
            useRecord.setCustomer(useRecordVO.getCustomerVO().toDTO());
        }
        useRecord.setDictBrand(useRecordVO.getDictBrand().toDTO());
        useRecord.setDictEar(useRecordVO.getDictEar().toDTO());
        useRecord.setDictMachineType(useRecordVO.getDictMachineType().toDTO());
        useRecord.setDictUseOrNo(useRecordVO.getDictUseOrNo().toDTO());
        useRecord.setDictUseResult(useRecordVO.getDictUseResult().toDTO());
        useRecord.setDictUseYear(useRecordVO.getDictUseYear().toDTO());
        useRecord.setMachineCode(useRecordVO.getMachineCode());
        useRecord.setTeamId(useRecordVO.getTeamId());
        return useRecord;
    }

    @Override
    public List<UseRecord> toDTO(List<UseRecordVO> voList) {
        List<UseRecord> list = new ArrayList<>();
        for(UseRecordVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    @Override
    public UseRecordVO toVO(UseRecord vo) {
        return new UseRecordVO(vo);
    }

    @Override
    public List<UseRecordVO> toVO(List<UseRecord> list) {
        List<UseRecordVO> resList = new ArrayList<>();
        for(UseRecord temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public DictItemVO getDictMachineType() {
        if(dictMachineType == null){
            dictMachineType = new DictItemVO();
        }
        return dictMachineType;
    }

    public void setDictMachineType(DictItemVO dictMachineType) {
        this.dictMachineType = dictMachineType;
    }

    public DictItemVO getDictBrand() {
        if(dictBrand == null){
            dictBrand = new DictItemVO();
        }
        return dictBrand;
    }

    public void setDictBrand(DictItemVO dictBrand) {
        this.dictBrand = dictBrand;
    }

    public DictItemVO getDictUseOrNo() {
        if(dictUseOrNo == null){
            dictUseOrNo = new DictItemVO();
        }
        return dictUseOrNo;
    }

    public void setDictUseOrNo(DictItemVO dictUseOrNo) {
        this.dictUseOrNo = dictUseOrNo;
    }

    public DictItemVO getDictEar() {
        if(dictEar == null){
            dictEar = new DictItemVO();
        }
        return dictEar;
    }

    public void setDictEar(DictItemVO dictEar) {
        this.dictEar = dictEar;
    }

    public DictItemVO getDictUseYear() {
        if(dictUseYear == null){
            dictUseYear = new DictItemVO();
        }
        return dictUseYear;
    }

    public void setDictUseYear(DictItemVO dictUseYear) {
        this.dictUseYear = dictUseYear;
    }

    public DictItemVO getDictUseResult() {
        if(dictUseResult == null){
            dictUseResult = new DictItemVO();
        }
        return dictUseResult;
    }

    public void setDictUseResult(DictItemVO dictUseResult) {
        this.dictUseResult = dictUseResult;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }
}
