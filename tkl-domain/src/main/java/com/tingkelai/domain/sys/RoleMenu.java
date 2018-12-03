package com.tingkelai.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 菜单角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
@TableName("tkl_sys_role_menu")
public class RoleMenu implements java.io.Serializable {

    /** 编号 */
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;
    /** 菜单编号 */
    @TableId(value = "menu_id")
    private Long menuId;
    @TableId(value = "role_id")
    /** 角色编号 */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
