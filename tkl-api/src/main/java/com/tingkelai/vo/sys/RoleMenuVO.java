package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
public class RoleMenuVO implements BaseVO<RoleMenu, RoleMenuVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** 菜单编号 */
    private Long menuId;
    /** 角色编号 */
    private Long roleId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
    public RoleMenu toDTO(){
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(getId());
        roleMenu.setMenuId(getMenuId());
        roleMenu.setRoleId(getRoleId());
        return roleMenu;
    }

    /**
     * 封装成web需要的对象
     */
    public RoleMenuVO toVO(RoleMenu roleMenu){
        return null;
    }
}
