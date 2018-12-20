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
@TableName("tkl_sys_user")
@Mapper
public class User extends DataEntity<Long>{

    /**
     * 是否锁定（1：正常；-1：删除；0：锁定；）
     */
    public static final int STATUS_DELETE = -1;
    public static final int STATUS_LOCKED = 0;
    public static final int STATUS_NORMAL = 1;

    /**
     * 用户登录名
     **/
    @TableField("username")
    private String username = null;

    /**
     * 用户真实姓名
     **/
    @TableField("realname")
    private String realname = null;

    /**
     * 用户别名
     **/
    @TableField("portrait")
    private String portrait = null;

    /**
     * 密码
     **/
    @JsonProperty("password")
    @TableField("password")
    private String password = null;

    /**
     * salt
     **/
    @TableField("salt")
    private String salt = null;

    /**
     * 邮箱
     **/
    @TableField("email")
    private String email = null;

    /**
     * 手机号
     **/
    @TableField("phone")
    private String phone = null;

    /**
     * 用户状态
     **/
    @TableField("user_status")
    private Integer userStatus = 1;

    /**
     * 用户所属公司id
     */
    @JsonProperty("teamId")
    @TableField("team_id")
    private Long teamId = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId){
        this.teamId = teamId;
    }

    public String getCredentialsSalt() {
        return username + salt;
    }
}
