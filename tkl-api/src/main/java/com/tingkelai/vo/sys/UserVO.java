package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Team;
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

    public UserVO(){}

    public UserVO(User user){
        setEmail(user.getEmail());
        setId(user.getId());
        setPhone(user.getPhone());
        setPortrait(user.getPortrait());
        setRealname(user.getRealname());
        setTeamId(user.getTeamId());
        setUsername(user.getUsername());
        setUserStatus(user.getUserStatus());
        setRemarks(user.getRemarks());
    }

    @JsonProperty("id")
    private Long id = null;
    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    @Override
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @ApiModelProperty(value = "用户所属公司id", required = true)
    public Long getTeamId() {
        return teamId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("username")
    @ApiModelProperty(value = "用户登录名")
    private String username = null;

    @JsonProperty("realname")
    @ApiModelProperty(value = "用户真实姓名")
    private String realname = null;

    @JsonProperty("portrait")
    @ApiModelProperty(value = "用户头像url")
    private String portrait = null;

    @JsonProperty("password")
    @ApiModelProperty(value = "密码")
    private transient String password = null;

    @JsonProperty("email")
    @ApiModelProperty(value = "邮箱")
    private String email = null;

    @JsonProperty("phone")
    @ApiModelProperty(value = "手机号")
    private String phone = null;

    @JsonProperty("status")
    @ApiModelProperty(value = "用户状态")
    private Integer userStatus = 1;

    @JsonProperty("teamId")
    @ApiModelProperty(hidden = true)
    private Long teamId = null;

    @JsonProperty("remarks")
    @ApiModelProperty(value = "备注信息")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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
        user.setTeamId(userVO.getTeamId());
        user.setUsername(userVO.getUsername());
        user.setPassword(userVO.getPassword());
        user.setUserStatus(userVO.getUserStatus());
        user.setRemarks(userVO.getRemarks());
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
        return new UserVO(user);
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
