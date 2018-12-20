package com.tingkelai.domain.sys;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * 角色
 * @author liuzhengjie
 * @date 2018-11-23 21:10:08
 * @version 1.0
 */
@ApiModel(description = "角色")
@TableName("tkl_sys_role")
public class Role  extends DataEntity<Long> {

    /**
     * 角色名
     */
    @TableField("name")
    private String name = null;


    /**
     * 角色编码
     */
    @TableField("code")
    private String code = null;

    /**
     * 是否可用
     **/
    @TableField("usable")
    private Boolean usable = null;

    /**
     * 是否是系统角色
     **/
    @TableField("is_sys")
    private String isSys = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role code(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Role usable(Boolean usable) {
        this.usable = usable;
        return this;
    }

    public Boolean isUsable() {
        return usable;
    }

    public void setUsable(Boolean usable) {
        this.usable = usable;
    }

    public Role isSys(String isSys) {
        this.isSys = isSys;
        return this;
    }

    public String isIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }

}