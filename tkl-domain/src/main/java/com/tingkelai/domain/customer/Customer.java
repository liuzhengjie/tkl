package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 客户主表
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:24:37
 * @version 1.0
 */
@ApiModel(description = "客户主表")
@TableName("tkl_customer")
@Mapper
public class Customer  extends DataEntity<Long> {

    /** 客户名字 */
    @TableField("name")
    private String name = null;

    /** 客户编号 */
    @TableField("code")
    private String code = null;

    /** 性别 */
    @TableField("sex")
    private String sex = null;

    /** 省份 */
    @TableField("provience")
    private String provience = null;

    /** 市 */
    @JsonProperty("city")
    @TableField("city")
    private String city = null;

    /** 区 */
    @TableField("region")
    private String region = null;

    /** 地址 */
    @TableField("area")
    private String area = null;

    /** 注册时间 */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(value = "regist_date", fill = FieldFill.UPDATE)
    private Date registDate = new Date();

    /** 生日 */
    @TableField("birthday")
    private String birthday = null;

    /** 年龄 */
    @TableField("age")
    private Integer age = null;

    /** 职业 */
    @TableField("job")
    private String job = null;

    /** 所属部门 */
    @TableField(value = "dept_owner", el = "deptOwner.id")
    private Dept deptOwner = null;

    /** 所属人员 */
    @TableField(value = "user_owner", el = "userOwner.id")
    private User userOwner = null;

    /** 客户来源 */
    @TableField(value = "from_dict", el = "fromDict.id")
    private DictItem fromDict;

    /** 客户类型 */
    @TableField(value = "type_dict", el = "typeDict.id")
    private DictItem typeDict;

    /** 客户性质 */
    @TableField(value = "character_dict", el = "characterDict.id")
    private DictItem characterDict;

    /** 客户等级 */
    @TableField(value = "level_dict", el = "levelDict.id")
    private DictItem levelDict;

    /** 客户状态 */
    @TableField(value = "state_dict", el = "stateDict.id")
    private DictItem stateDict;

    public DictItem getFromDict() {
        if(fromDict == null){
            fromDict = new DictItem();
        }
        return fromDict;
    }

    public void setFromDict(DictItem fromDict) {
        this.fromDict = fromDict;
    }

    public DictItem getTypeDict() {
        if(typeDict == null){
            typeDict = new DictItem();
        }
        return typeDict;
    }

    public void setTypeDict(DictItem typeDict) {
        this.typeDict = typeDict;
    }

    public DictItem getCharacterDict() {
        if(characterDict == null){
            characterDict = new DictItem();
        }
        return characterDict;
    }

    public void setCharacterDict(DictItem characterDict) {
        this.characterDict = characterDict;
    }

    public DictItem getLevelDict() {
        if(levelDict == null){
            levelDict = new DictItem();
        }
        return levelDict;
    }

    public void setLevelDict(DictItem levelDict) {
        this.levelDict = levelDict;
    }

    public DictItem getStateDict() {
        if(stateDict == null){
            stateDict = new DictItem();
        }
        return stateDict;
    }

    public void setStateDict(DictItem stateDict) {
        this.stateDict = stateDict;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Dept getDeptOwner() {
        if(deptOwner == null){
            deptOwner = new Dept();
        }
        return deptOwner;
    }

    public void setDeptOwner(Dept deptOwner) {
        this.deptOwner = deptOwner;
    }

    public User getUserOwner() {
        if(userOwner == null){
            userOwner = new User();
        }
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }
}