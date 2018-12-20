package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.domain.dict.DictItem;
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
 * 客户主表
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:24:37
 * @version 1.0
 */
@ApiModel(description = "客户主表")
public class CustomerVO implements BaseVO<Customer, CustomerVO>{

    public CustomerVO(){

    }

    public CustomerVO(Customer customer){
        setId(customer.getId());
        setAge(customer.getAge());
        setArea(customer.getArea());
        setBirthday(customer.getBirthday());
        setCity(customer.getCity());
        setCode(customer.getCode());
        setName(customer.getName());
        setProvience(customer.getProvience());
        setRegion(customer.getRegion());
        setRegistDate(customer.getRegistDate());
        setSex(customer.getSex());
        setJob(customer.getJob());
        // 所属部门
        setDeptOwner(new DeptVO(customer.getDeptOwner()));
        // 所属用户
        setUserOwner(new UserVO(customer.getUserOwner()));
        // 客户来源
        setFromDict(new DictItemVO(customer.getFromDict()));
        // 客户类型
        setTypeDict(new DictItemVO(customer.getTypeDict()));
        // 客户性质
        setCharacterDict(new DictItemVO(customer.getCharacterDict()));
        // 客户等级
        setLevelDict(new DictItemVO(customer.getLevelDict()));
        // 客户状态
        setStateDict(new DictItemVO(customer.getStateDict()));
    }

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    @Override
    public void setTeamId(Long teamId) {

    }

    @Override
    public Long getTeamId() {
        return null;
    }


    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 客户名字
     * @return name
     **/
    @ApiModelProperty(value = "客户名字")
    @JsonProperty("name")
    private String name = null;

    /**
     * 客户编号
     * @return code
     **/
    @ApiModelProperty(value = "客户编号")
    @JsonProperty("code")
    private String code = null;

    /**
     * 客户性别
     * @return sex
     **/
    @ApiModelProperty(value = "客户性别")
    @JsonProperty("sex")
    private String sex = null;

    /**
     * 省
     * @return provience
     **/
    @ApiModelProperty(value = "省")
    @JsonProperty("provience")
    private String provience = null;

    /**
     * 市
     * @return city
     **/
    @ApiModelProperty(value = "市")
    @JsonProperty("city")
    private String city = null;

    /**
     * 区
     * @return region
     **/
    @ApiModelProperty(value = "区")
    @JsonProperty("region")
    private String region = null;

    /**
     * 地址
     * @return area
     **/
    @ApiModelProperty(value = "地址")
    @JsonProperty("area")
    private String area = null;

    /**
     * 注册时间
     * @return registDate
     **/
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registDate = null;

    /**
     * 生日
     * @return birthday
     **/
    @ApiModelProperty(value = "生日")
    @JsonProperty("birthday")
    private String birthday = null;

    /**
     * 年龄
     * @return age
     **/
    @ApiModelProperty(value = "年龄")
    @JsonProperty("age")
    private Integer age = null;

    @JsonProperty("job")
    private String job = null;

    /** 所属部门 */
    @JsonProperty("deptOwner")
    private DeptVO deptOwner = null;

    /** 所属人员 */
    @JsonProperty("userOwner")
    private UserVO userOwner = null;


    /** 客户来源 */
    @ApiModelProperty(value = "客户来源")
    @JsonProperty("fromDict")
    private DictItemVO fromDict;

    /** 客户类型 */
    @ApiModelProperty(value = "客户类型")
    @JsonProperty("typeDict")
    private DictItemVO typeDict;

    /** 客户性质 */
    @ApiModelProperty(value = "客户性质")
    @JsonProperty("characterDict")
    private DictItemVO characterDict;

    /** 客户等级 */
    @ApiModelProperty(value = "客户等级")
    @JsonProperty("levelDict")
    private DictItemVO levelDict;

    /** 客户状态 */
    @ApiModelProperty(value = "客户状态")
    @JsonProperty("stateDict")
    private DictItemVO stateDict;

    public DictItemVO getFromDict() {
        return fromDict;
    }

    public void setFromDict(DictItemVO fromDict) {
        this.fromDict = fromDict;
    }

    public DictItemVO getTypeDict() {
        return typeDict;
    }

    public void setTypeDict(DictItemVO typeDict) {
        this.typeDict = typeDict;
    }

    public DictItemVO getCharacterDict() {
        return characterDict;
    }

    public void setCharacterDict(DictItemVO characterDict) {
        this.characterDict = characterDict;
    }

    public DictItemVO getLevelDict() {
        return levelDict;
    }

    public void setLevelDict(DictItemVO levelDict) {
        this.levelDict = levelDict;
    }

    public DictItemVO getStateDict() {
        return stateDict;
    }

    public void setStateDict(DictItemVO stateDict) {
        this.stateDict = stateDict;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public DeptVO getDeptOwner() {
        return deptOwner;
    }

    public void setDeptOwner(DeptVO deptOwner) {
        this.deptOwner = deptOwner;
    }

    public UserVO getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(UserVO userOwner) {
        this.userOwner = userOwner;
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


    /**
     * 封装成业务需要的对象
     */
    public Customer toDTO(){
        return toDTO(this);
    }

    @Override
    public Customer toDTO(CustomerVO vo) {
        Customer customer = new Customer();
        customer.setId(vo.getId());
        customer.setAge(vo.getAge());
        customer.setArea(vo.getArea());
        customer.setBirthday(vo.getBirthday());
        customer.setCity(vo.getCity());
        customer.setCode(vo.getCode());
        customer.setName(vo.getName());
        customer.setProvience(vo.getProvience());
        customer.setRegion(vo.getRegion());
        customer.setRegistDate(vo.getRegistDate());
        customer.setSex(vo.getSex());
        customer.setJob(vo.getJob());
        // 所属部门
        if(vo.getDeptOwner() != null && vo.getDeptOwner().getId() != null){
            customer.setDeptOwner(vo.getDeptOwner().toDTO());
        }
        // 所属用户
        if(vo.getUserOwner() != null && vo.getUserOwner().getId() != null){
            customer.setUserOwner(vo.getUserOwner().toDTO());
        }
        // 客户来源
        if(vo.getFromDict() != null && vo.getFromDict().getId() != null){
            customer.setFromDict(vo.getFromDict().toDTO());
        }
        // 客户类型
        if(vo.getTypeDict() != null && vo.getTypeDict().getId() != null){
            customer.setTypeDict(vo.getTypeDict().toDTO());
        }
        // 客户性质
        if(vo.getCharacterDict() != null && vo.getCharacterDict().getId() != null){
            customer.setCharacterDict(vo.getCharacterDict().toDTO());
        }
        // 客户等级
        if(vo.getLevelDict() != null && vo.getLevelDict().getId() != null){
            customer.setLevelDict(vo.getLevelDict().toDTO());
        }
        // 客户状态
        if(vo.getStateDict() != null && vo.getStateDict().getId() != null){
            customer.setStateDict(vo.getStateDict().toDTO());
        }
        return customer;
    }

    @Override
    public List<Customer> toDTO(List<CustomerVO> voList) {
        List<Customer> list = new ArrayList<>();
        for(CustomerVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public CustomerVO toVO(Customer customer){
        return new CustomerVO(customer);
    }

    @Override
    public List<CustomerVO> toVO(List<Customer> list) {
        List<CustomerVO> resList = new ArrayList<>();
        for(Customer temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}