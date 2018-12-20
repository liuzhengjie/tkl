package com.tingkelai.vo.sys;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Role;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色
 * @author liuzhengjie
 * @date 2018-11-23 21:10:08
 * @version 1.0
 */
@ApiModel(description = "角色")
public class RoleVO implements BaseVO<Role, RoleVO>{

    @JsonProperty("id")
    private Long id = null;

    @ApiModelProperty(name = "id", value = "id")
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


    @JsonProperty("name")
    private String name = null;

    @JsonProperty("code")
    private String code = null;

    @JsonProperty("usable")
    private Boolean usable = null;

    @JsonProperty("isSys")
    private String isSys = null;

    /**
     * 角色名
     * @return name
     **/
    @ApiModelProperty(value = "角色名", required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 角色编码
     * @return code
     **/
    @ApiModelProperty(value = "角色编码", required = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 是否可用
     * @return usable
     **/
    @ApiModelProperty(value = "是否可用", required = true)
    public Boolean isUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    /**
     * 是否是系统角色
     * @return isSys
     **/
    @ApiModelProperty(value = "是否是系统角色", required = true)
    public String isIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

    /**
     * 封装成业务需要的对象
     */
    public Role toDTO(){
        return toDTO(this);
    }

    @Override
    public Role toDTO(RoleVO roleVO) {
        Role role = new Role();
        role.setId(roleVO.getId());
        role.setCode(roleVO.getCode());
        role.setName(roleVO.getName());
        return role;
    }

    @Override
    public List<Role> toDTO(List<RoleVO> voList) {
        List<Role> list = new ArrayList<>();
        for(RoleVO temp : voList){
            list.add(temp.toDTO());
        }
        return list;
    }

    /**
     * 封装成web需要的对象
     */
    public RoleVO toVO(Role role){
        RoleVO roleVO = new RoleVO();
        roleVO.setCode(role.getCode());
        roleVO.setId(role.getId());
        roleVO.setName(role.getName());
        return roleVO;
    }

    @Override
    public List<RoleVO> toVO(List<Role> list) {
        List<RoleVO> resList = new ArrayList<>();
        for(Role temp : list){
            resList.add(toVO(temp));
        }
        return resList;
    }
}