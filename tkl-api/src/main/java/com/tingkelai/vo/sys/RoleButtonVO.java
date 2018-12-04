package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.RoleButton;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

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
        return toDTO(this);
    }

    @Override
    public RoleButton toDTO(RoleButtonVO roleButtonVO) {
        RoleButton roleButton = new RoleButton();
        roleButton.setId(roleButtonVO.getId());
        roleButton.setRoleId(roleButtonVO.getRoleId());
        roleButton.setButtonId(roleButtonVO.getButtonId());
        return roleButton;
    }

    @Override
    public List<RoleButton> toDTO(List<RoleButtonVO> voList) {
        List<RoleButton> list = new ArrayList<>();
        for(RoleButtonVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public RoleButtonVO toVO(RoleButton roleButton){
        RoleButtonVO roleButtonVO = new RoleButtonVO();
        roleButtonVO.setId(roleButton.getId());
        roleButtonVO.setRoleId(roleButton.getRoleId());
        roleButtonVO.setButtonId(roleButton.getButtonId());
        return roleButtonVO;
    }

    @Override
    public List<RoleButtonVO> toVO(List<RoleButton> list) {
        List<RoleButtonVO> resList = new ArrayList<>();
        for(RoleButton temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
