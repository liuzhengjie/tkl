package com.tingkelai.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 按钮角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
@TableName("tkl_sys_role_button")
public class RoleButton implements java.io.Serializable {

    /** 编号 */
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;

    /** 按钮编号 */
    @TableId(value = "button_id")
    private Long buttonId;

    /** 角色编号 */
    @TableId(value = "role_id")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getButtonId() {
        return buttonId;
    }

    public void setButtonId(Long buttonId) {
        this.buttonId = buttonId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
