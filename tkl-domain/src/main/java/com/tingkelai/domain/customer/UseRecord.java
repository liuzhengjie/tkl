package com.tingkelai.domain.customer;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 使用效果记录
 */
@TableName("tkl_customer_use_record")
@Mapper
public class UseRecord extends DataEntity<Long> {

    /** 主键 */
    @TableId(value = "id", type = IdType.UUID)
    private Long id;

    /** 数据所属公司 */
    @TableField("team_id")
    private Long teamId;

    /** 关联客户 */
    @TableField(value = "customer_id", el = "customer.id")
    private Customer customer;


    /** 机器类型 */
    @TableField(value = "dict_machine_type", el = "dictMachineType.id")
    private DictItem dictMachineType;

    /** 机器型号 */
    @TableField(value = "dict_machine_model", el = "dictMachineModel.id")
    private DictItem dictMachineModel;

    /** 品牌 */
    @TableField(value = "dict_brand", el = "dictBrand.id")
    private DictItem dictBrand;

    /** 是否还在使用 */
    @TableField(value = "dict_use_or_no", el = "dictUseOrNo.id")
    private DictItem dictUseOrNo;

    /** 左右耳 */
    @TableField(value = "dict_ear", el = "dictEar.id")
    private DictItem dictEar;

    /** 使用年限 */
    @TableField(value = "use_year")
    private Integer useYear;

    /** 使用效果 */
    @TableField(value = "dict_use_result", el = "dictUseResult.id")
    private DictItem dictUseResult;

    /** 机器编号 */
    @TableField(value = "machine_code")
    private String machineCode;

    public Customer getCustomer() {
        if(customer == null){
            customer = new Customer();
        }
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public DictItem getDictMachineType() {
        if(dictMachineType == null){
            dictMachineType = new DictItem();
        }
        return dictMachineType;
    }

    public void setDictMachineType(DictItem dictMachineType) {
        this.dictMachineType = dictMachineType;
    }

    public DictItem getDictBrand() {
        if(dictBrand == null){
            dictBrand = new DictItem();
        }
        return dictBrand;
    }

    public void setDictBrand(DictItem dictBrand) {
        this.dictBrand = dictBrand;
    }

    public DictItem getDictUseOrNo() {
        if(dictUseOrNo == null){
            dictUseOrNo = new DictItem();
        }
        return dictUseOrNo;
    }

    public void setDictUseOrNo(DictItem dictUseOrNo) {
        this.dictUseOrNo = dictUseOrNo;
    }

    public DictItem getDictEar() {
        if(dictEar == null){
            dictEar = new DictItem();
        }
        return dictEar;
    }

    public void setDictEar(DictItem dictEar) {
        this.dictEar = dictEar;
    }

    public Integer getUseYear() {
        return useYear;
    }

    public void setUseYear(Integer useYear) {
        this.useYear = useYear;
    }

    public DictItem getDictUseResult() {
        if(dictUseResult == null){
            dictUseResult = new DictItem();
        }
        return dictUseResult;
    }

    public void setDictUseResult(DictItem dictUseResult) {
        this.dictUseResult = dictUseResult;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public DictItem getDictMachineModel() {
        if(dictMachineModel == null){
            dictMachineModel = new DictItem();
        }
        return dictMachineModel;
    }

    public void setDictMachineModel(DictItem dictMachineModel) {
        this.dictMachineModel = dictMachineModel;
    }
}
