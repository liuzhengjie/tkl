package com.tingkelai.vo.customer;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.customer.Customer;
import com.tingkelai.vo.BaseVO;
import com.tingkelai.vo.sys.DeptVO;
import com.tingkelai.vo.sys.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 客户主表
 *
 * @author liuzhengjie
 * @date 2018-11-27 19:24:37
 * @version 1.0
 */
@ApiModel(description = "客户主表")
public class CustomerVO implements BaseVO<Customer, CustomerVO>{

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

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("sex")
    private String sex = null;

    @JsonProperty("provience")
    private String provience = null;

    @JsonProperty("city")
    private String city = null;

    @JsonProperty("region")
    private String region = null;

    @JsonProperty("area")
    private String area = null;

    @JsonProperty("registDate")
    private String registDate = null;

    @JsonProperty("birthday")
    private String birthday = null;

    @JsonProperty("age")
    private Integer age = null;

    @JsonProperty("job")
    private String job = null;

    /**
     * 客户名字
     * @return name
     **/
    @ApiModelProperty(value = "客户名字")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 客户编号
     * @return code
     **/
    @ApiModelProperty(value = "客户编号")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 客户性别
     * @return sex
     **/
    @ApiModelProperty(value = "客户性别")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 省
     * @return provience
     **/
    @ApiModelProperty(value = "省")
    public String getProvience() {
        return provience;
    }

    public void setProvience(String provience) {
        this.provience = provience;
    }

    /**
     * 市
     * @return city
     **/
    @ApiModelProperty(value = "市")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     * @return region
     **/
    @ApiModelProperty(value = "区")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 地址
     * @return area
     **/
    @ApiModelProperty(value = "地址")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 注册时间
     * @return registDate
     **/
    @ApiModelProperty(value = "注册时间")
    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    /**
     * 生日
     * @return birthday
     **/
    @ApiModelProperty(value = "生日")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 年龄
     * @return age
     **/
    @ApiModelProperty(value = "年龄")
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
        Customer customer = new Customer();
        customer.setAge(getAge());
        customer.setArea(getArea());
        customer.setBirthday(getBirthday());
        customer.setCity(getCity());
        customer.setCode(getCode());
        customer.setId(getId());
        customer.setName(getName());
        customer.setProvience(getProvience());
        customer.setRegion(getRegion());
        customer.setRegistDate(getRegistDate());
        customer.setSex(getSex());
        return customer;
    }

    /**
     * 封装成web需要的对象
     */
    public CustomerVO toVO(Customer customer){
        return null;
    }
}