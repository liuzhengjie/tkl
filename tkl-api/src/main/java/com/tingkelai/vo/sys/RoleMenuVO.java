package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.RoleMenu;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

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

    /** 菜单编号 */
    @JsonProperty("menuId")
    private Long menuId;
    /** 角色编号 */
    @JsonProperty("roleId")
    private Long roleId;

    @ApiModelProperty(value = "菜单id", required = true)
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
    public RoleMenu toDTO(){
        return toDTO(this);
    }

    @Override
    public RoleMenu toDTO(RoleMenuVO roleMenuVO) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setId(roleMenuVO.getId());
        roleMenu.setMenuId(roleMenuVO.getMenuId());
        roleMenu.setRoleId(roleMenuVO.getRoleId());
        return roleMenu;
    }

    @Override
    public List<RoleMenu> toDTO(List<RoleMenuVO> voList) {
        List<RoleMenu> list = new ArrayList<>();
        for(RoleMenuVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public RoleMenuVO toVO(RoleMenu roleMenu){
        RoleMenuVO roleMenuVO = new RoleMenuVO();
        roleMenuVO.setId(roleMenu.getId());
        roleMenuVO.setMenuId(roleMenu.getMenuId());
        roleMenuVO.setRoleId(roleMenu.getRoleId());
        return roleMenuVO;
    }

    @Override
    public List<RoleMenuVO> toVO(List<RoleMenu> list) {
        List<RoleMenuVO> resList = new ArrayList<>();
        for(RoleMenu temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}
