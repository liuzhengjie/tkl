package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.User;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

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

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("realname")
    private String realname = null;

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

    @JsonProperty("status")
    private Integer userStatus = 1;

    @JsonProperty("teamId")
    private Integer teamId = null;

    /**
     * 用户登录名
     * @return userName
     **/
    @ApiModelProperty(value = "用户登录名", required = true)
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
    @ApiModelProperty(value = "用户真实姓名", required = true)
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
    @ApiModelProperty(value = "密码", hidden = true)
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
    @ApiModelProperty(value = "salt", hidden = true)
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
    @ApiModelProperty(value = "手机号", required = true)
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

    @ApiModelProperty(value = "用户所属公司id", required = true)
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
        return toDTO(this);
    }

    @Override
    public User toDTO(UserVO userVO) {
        User user = new User();
        user.setEmail(userVO.getEmail());
        user.setId(userVO.getId());
        user.setPhone(userVO.getPhone());
        user.setPortrait(userVO.getPortrait());
        user.setRealname(userVO.getRealname());
        user.setSalt(userVO.getSalt());
        user.setTeamId(userVO.getTeamId());
        user.setUsername(userVO.getUsername());
        user.setUserStatus(userVO.getUserStatus());
        return user;
    }

    @Override
    public List<User> toDTO(List<UserVO> voList) {
        List<User> list = new ArrayList<>();
        for(UserVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public UserVO toVO(User user){
        UserVO userVO = new UserVO();
        userVO.setEmail(user.getEmail());
        userVO.setId(user.getId());
        userVO.setPhone(user.getPhone());
        userVO.setPortrait(user.getPortrait());
        userVO.setRealname(user.getRealname());
        userVO.setSalt(user.getSalt());
        userVO.setTeamId(user.getTeamId());
        userVO.setUsername(user.getUsername());
        userVO.setUserStatus(user.getUserStatus());
        return userVO;
    }

    @Override
    public List<UserVO> toVO(List<User> list) {
        List<UserVO> resList = new ArrayList<>();
        for(User temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
