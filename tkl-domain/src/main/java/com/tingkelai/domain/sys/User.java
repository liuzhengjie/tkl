package com.tingkelai.domain.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.Valid;
import java.util.Objects;

/**
 * 用户
 * @author liuzhengjie
 * @date 2018-11-23 19:54:33
 * @version 1.0
 */
@ApiModel(description = "用户")
@TableName("tkl_sys_user")
@Mapper
public class User extends DataEntity<Long>{

    /**
     * 是否锁定（1：正常；-1：删除；0：锁定；）
     */
    public static final int STATUS_DELETE = -1;
    public static final int STATUS_LOCKED = 0;
    public static final int STATUS_NORMAL = 1;

    @JsonProperty("userName")
    @TableField("user_name")
    private String userName = null;

    @JsonProperty("realName")
    @TableField("real_name")
    private String realName = null;

    @JsonProperty("portrait")
    @TableField("portrait")
    private String portrait = null;

    @JsonProperty("password")
    @TableField("password")
    private String password = null;

    @JsonProperty("salt")
    @TableField("salt")
    private String salt = null;

    @JsonProperty("email")
    @TableField("email")
    private String email = null;

    @JsonProperty("phone")
    @TableField("phone")
    private String phone = null;

    @JsonProperty("userStatus")
    @TableField("status")
    private Integer userStatus = null;

    @JsonProperty("teamId")
    @TableField("team_id")
    private Integer teamId = null;

    /**
     * 用户登录名
     * @return userName
     **/
    @ApiModelProperty(value = "用户登录名")


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户真实姓名
     * @return realName
     **/
    @ApiModelProperty(value = "用户真实姓名")


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public User portrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    /**
     * 用户别名
     * @return portrait
     **/
    @ApiModelProperty(value = "用户别名")


    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    /**
     * 密码
     * @return password
     **/
    @ApiModelProperty(value = "密码")


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User salt(String salt) {
        this.salt = salt;
        return this;
    }

    /**
     * salt
     * @return salt
     **/
    @ApiModelProperty(value = "salt")


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    /**
     * 邮箱
     * @return email
     **/
    @ApiModelProperty(value = "邮箱")


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * 手机号
     * @return phone
     **/
    @ApiModelProperty(value = "手机号")


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User userStatus(Integer userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    /**
     * 用户状态
     * @return userStatus
     **/
    @ApiModelProperty(value = "用户状态")


    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @ApiModelProperty(value = "用户所属公司id")
    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.userName, user.userName) &&
                Objects.equals(this.realName, user.realName) &&
                Objects.equals(this.portrait, user.portrait) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.salt, user.salt) &&
                Objects.equals(this.email, user.email) &&
                Objects.equals(this.phone, user.phone) &&
                Objects.equals(this.userStatus, user.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, realName, portrait, password, salt, email, phone, userStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
        sb.append("    portrait: ").append(toIndentedString(portrait)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    salt: ").append(toIndentedString(salt)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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

    public String getCredentialsSalt() {
        return userName + salt;
    }
}
