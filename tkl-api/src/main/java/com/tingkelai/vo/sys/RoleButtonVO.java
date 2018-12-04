package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

/**
 * 按钮角色中间表
 *
 * 2018-11-30 13:42:12
 * @author liuzhengjie
 * @version 1.0
 */
public class RoleButtonVO implements BaseVO<RoleButton, RoleButtonVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** 按钮编号 */
    private Long buttonId;

    /** 角色编号 */
    private Long roleId;

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

    /**
     * 封装成业务需要的对象
     */
    public RoleButton toDTO(){
        RoleButton roleButton = new RoleButton();
        roleButton.setId(getId());
        roleButton.setRoleId(getRoleId());
        roleButton.setButtonId(getButtonId());
        return roleButton;
    }

    /**
     * 封装成web需要的对象
     */
    public RoleButtonVO toVO(RoleButton roleButton){
        return null;
    }
}
