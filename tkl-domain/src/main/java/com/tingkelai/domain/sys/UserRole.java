package com.tingkelai.domain.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
@TableName("tkl_sys_user_role")
public class UserRole implements java.io.Serializable {

    /** 编号 */
    @TableId(value = "id",type= IdType.AUTO)
    private Long id;

    /** 用户编号 */
    @TableId(value = "user_id")
    private Long userId;

    /** 角色编号 */
    @TableId(value = "role_id")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
