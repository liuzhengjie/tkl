package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.UserRole;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

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
    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    /** 用户编号 */
    private Long userId;

    /** 角色编号 */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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
        UserRole userRole = new UserRole();
        userRole.setUserId(getUserId());
        userRole.setId(getId());
        userRole.setRoleId(getRoleId());
        return userRole;
    }

    /**
     * 封装成web需要的对象
     */
    public UserRoleVO toVO(UserRole userRole){
        return null;
    }
}
