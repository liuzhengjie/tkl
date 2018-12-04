package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.User;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户
 * @author liuzhengjie
 * @date 2018-11-23 19:54:33
 * @version 1.0
 */
@ApiModel(description = "用户")
public class UserVO implements BaseVO<User, UserVO>{
    @JsonProperty("id")
    private Long id = null;
    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("userName")
    private String userName = null;

    @JsonProperty("realName")
    private String realName = null;

    @JsonProperty("portrait")
    private String portrait = null;

    @JsonProperty("password")
    private String password = null;

    @JsonProperty("salt")
    private String salt = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("phone")
    private String phone = null;

    @JsonProperty("userStatus")
    private Integer userStatus = null;

    @JsonProperty("teamId")
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

    /**
     * 封装成业务需要的对象
     */
    public User toDTO(){
        User user = new User();
        user.setEmail(getEmail());
        user.setId(getId());
        user.setPhone(getPhone());
        user.setPortrait(getPortrait());
        user.setRealName(getRealName());
        user.setSalt(getSalt());
        user.setTeamId(getTeamId());
        user.setUserName(getUserName());
        user.setUserStatus(getUserStatus());
        return user;
    }

    /**
     * 封装成web需要的对象
     */
    public UserVO toVO(User user){
        return null;
    }
}
