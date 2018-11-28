package com.tingkelai.domain.customer;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
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

    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    @JsonProperty("code")
    @TableField("code")
    private String code = null;

    @JsonProperty("sex")
    @TableField("sex")
    private String sex = null;

    @JsonProperty("provience")
    @TableField("provience")
    private String provience = null;

    @JsonProperty("city")
    @TableField("city")
    private String city = null;

    @JsonProperty("region")
    @TableField("region")
    private String region = null;

    @JsonProperty("area")
    @TableField("area")
    private String area = null;

    @JsonProperty("registDate")
    @TableField("regist_date")
    private String registDate = null;

    @JsonProperty("birthday")
    @TableField("birthday")
    private String birthday = null;

    @JsonProperty("age")
    @TableField("age")
    private Integer age = null;

    @JsonProperty("job")
    @TableField("job")
    private String job = null;

    @JsonProperty("deptOwner")
    @TableField(value = "dept_owner", el = "deptOwner.id")
    private Dept deptOwner = null;

    @JsonProperty("userOwner")
    @TableField(value = "user_owner", el = "userOwner.id")
    private User userOwner = null;

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

    public Customer code(String code) {
        this.code = code;
        return this;
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

    public Customer sex(String sex) {
        this.sex = sex;
        return this;
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

    public Customer provience(String provience) {
        this.provience = provience;
        return this;
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

    public Customer city(String city) {
        this.city = city;
        return this;
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

    public Customer region(String region) {
        this.region = region;
        return this;
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

    public Customer area(String area) {
        this.area = area;
        return this;
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

    public Customer registDate(String registDate) {
        this.registDate = registDate;
        return this;
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

    public Customer birthday(String birthday) {
        this.birthday = birthday;
        return this;
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

    public Customer age(Integer age) {
        this.age = age;
        return this;
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

    public Customer job(String job) {
        this.job = job;
        return this;
    }

    /**
     * 职业
     * @return job
     **/
    @ApiModelProperty(value = "职业")


    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Customer deptOwner(Dept deptOwner) {
        this.deptOwner = deptOwner;
        return this;
    }

    /**
     * Get deptOwner
     * @return deptOwner
     **/
    @ApiModelProperty(value = "")
    @ApiIgnore()
    public Dept getDeptOwner() {
        return deptOwner;
    }

    public void setDeptOwner(Dept deptOwner) {
        this.deptOwner = deptOwner;
    }

    public Customer userOwner(User userOwner) {
        this.userOwner = userOwner;
        return this;
    }

    /**
     * Get userOwner
     * @return userOwner
     **/
    @ApiModelProperty(value = "")
    @ApiIgnore()
    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.name, customer.name) &&
                Objects.equals(this.code, customer.code) &&
                Objects.equals(this.sex, customer.sex) &&
                Objects.equals(this.provience, customer.provience) &&
                Objects.equals(this.city, customer.city) &&
                Objects.equals(this.region, customer.region) &&
                Objects.equals(this.area, customer.area) &&
                Objects.equals(this.registDate, customer.registDate) &&
                Objects.equals(this.birthday, customer.birthday) &&
                Objects.equals(this.age, customer.age) &&
                Objects.equals(this.job, customer.job) &&
                Objects.equals(this.deptOwner, customer.deptOwner) &&
                Objects.equals(this.userOwner, customer.userOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, sex, provience, city, region, area, registDate, birthday, age, job, deptOwner, userOwner);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
        sb.append("    provience: ").append(toIndentedString(provience)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    region: ").append(toIndentedString(region)).append("\n");
        sb.append("    area: ").append(toIndentedString(area)).append("\n");
        sb.append("    registDate: ").append(toIndentedString(registDate)).append("\n");
        sb.append("    birthday: ").append(toIndentedString(birthday)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    job: ").append(toIndentedString(job)).append("\n");
        sb.append("    deptOwner: ").append(toIndentedString(deptOwner)).append("\n");
        sb.append("    userOwner: ").append(toIndentedString(userOwner)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}