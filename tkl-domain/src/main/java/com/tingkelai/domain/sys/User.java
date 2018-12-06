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

    @JsonProperty("username")
    @TableField("username")
    private String username = null;

    @JsonProperty("realname")
    @TableField("realname")
    private String realname = null;

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
    @TableField("user_status")
    private Integer userStatus = null;

    @JsonProperty("teamId")
    @TableField("team_id")
    private Integer teamId = null;

    /**
     * 用户登录名
     * @return userName
     **/
    @ApiModelProperty(value = "用户登录名")


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户真实姓名
     * @return realName
     **/
    @ApiModelProperty(value = "用户真实姓名")
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public String getCredentialsSalt() {
        return username + salt;
    }
}
