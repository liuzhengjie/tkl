package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.domain.sys.UserRole;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
public class UserRoleVO implements BaseVO<UserRole, UserRoleVO>{

    @JsonProperty("id")
    private Long id = null;
    @ApiModelProperty(name = "id", value = "id", required = true)
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

    /** 用户编号 */
    @JsonProperty("userId")
    private Long userId;

    /** 角色编号 */
    @JsonProperty("roleId")
    private Long roleId;

    @ApiModelProperty(value = "用户id", required = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @ApiModelProperty(value = "角色id", required = true)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 封装成业务需要的对象
     */
    public UserRole toDTO(){
        return toDTO(this);
    }

    @Override
    public UserRole toDTO(UserRoleVO userRoleVO) {
        UserRole userRole = new UserRole();
        userRole.setId(getId());
        userRole.setUserId(getUserId());
        userRole.setRoleId(getRoleId());
        return userRole;
    }

    @Override
    public List<UserRole> toDTO(List<UserRoleVO> voList) {
        List<UserRole> list = new ArrayList<>();
        for(UserRoleVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public UserRoleVO toVO(UserRole userRole){
        UserRoleVO userRoleVO = new UserRoleVO();
        userRoleVO.setUserId(userRole.getUserId());
        userRoleVO.setId(userRole.getId());
        userRoleVO.setRoleId(userRole.getRoleId());
        return userRoleVO;
    }

    @Override
    public List<UserRoleVO> toVO(List<UserRole> list) {
        List<UserRoleVO> resList = new ArrayList<>();
        for(UserRole temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
