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
    @JsonProperty("name")
    @TableField("name")
    private String name = null;

    @JsonProperty("code")
    @TableField("code")
    private String code = null;

    @JsonProperty("usable")
    @TableField("usable")
    private Boolean usable = null;

    @JsonProperty("isSys")
    @TableField("is_sys")
    private String isSys = null;

    /**
     * 角色名
     * @return name
     **/
    @ApiModelProperty(value = "角色名")


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

    /**
     * 角色编码
     * @return code
     **/
    @ApiModelProperty(value = "角色编码")


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

    /**
     * 是否可用
     * @return usable
     **/
    @ApiModelProperty(value = "是否可用")


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

    /**
     * 是否是系统角色
     * @return isSys
     **/
    @ApiModelProperty(value = "是否是系统角色")


    public String isIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(this.name, role.name) &&
                Objects.equals(this.code, role.code) &&
                Objects.equals(this.usable, role.usable) &&
                Objects.equals(this.isSys, role.isSys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, usable, isSys);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Role {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    usable: ").append(toIndentedString(usable)).append("\n");
        sb.append("    isSys: ").append(toIndentedString(isSys)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}