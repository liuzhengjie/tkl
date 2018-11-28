package com.tingkelai.domain.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.entity.DataEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

import java.util.Objects;

/**
 * 按钮
 * @author liuzhengjie
 * @date 2018-11-23 21:13:39
 * @version 1.0
 */
@ApiModel(description = "按钮")
@TableName("tkl_sys_button")
@Mapper
public class Button  extends DataEntity<Long> {
  @JsonProperty("name")
  @TableField("name")
  private String name = null;

  @JsonProperty("type")
  @TableField("type")
  private String type = null;

  @JsonProperty("permission")
  @TableField("permission")
  private String permission = null;

  @JsonProperty("isShow")
  @TableField("is_show")
  private String isShow = null;

  @JsonProperty("sort")
  @TableField("sort")
  private Integer sort = null;

  @JsonProperty("buttonIcon")
  @TableField("button_icon")
  private String buttonIcon = null;

  /**
   * 按钮名
   * @return name
  **/
  @ApiModelProperty(value = "按钮名")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Button type(String type) {
    this.type = type;
    return this;
  }

  /**
   * 按钮类型
   * @return type
  **/
  @ApiModelProperty(value = "按钮类型")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Button permission(String permission) {
    this.permission = permission;
    return this;
  }

  /**
   * 按钮权限
   * @return permission
  **/
  @ApiModelProperty(value = "按钮权限")


  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public Button isShow(String isShow) {
    this.isShow = isShow;
    return this;
  }

  /**
   * 是否显示
   * @return isShow
  **/
  @ApiModelProperty(value = "是否显示")


  public String isIsShow() {
    return isShow;
  }

  public void setIsShow(String isShow) {
    this.isShow = isShow;
  }

  public Button sort(Integer sort) {
    this.sort = sort;
    return this;
  }

  /**
   * 排序
   * @return sort
  **/
  @ApiModelProperty(value = "排序")


  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public Button buttonIcon(String buttonIcon) {
    this.buttonIcon = buttonIcon;
    return this;
  }

  /**
   * 按钮图标
   * @return buttonIcon
  **/
  @ApiModelProperty(value = "按钮图标")


  public String getButtonIcon() {
    return buttonIcon;
  }

  public void setButtonIcon(String buttonIcon) {
    this.buttonIcon = buttonIcon;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Button button = (Button) o;
    return Objects.equals(this.name, button.name) &&
        Objects.equals(this.type, button.type) &&
        Objects.equals(this.permission, button.permission) &&
        Objects.equals(this.isShow, button.isShow) &&
        Objects.equals(this.sort, button.sort) &&
        Objects.equals(this.buttonIcon, button.buttonIcon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, permission, isShow, sort, buttonIcon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Button {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    isShow: ").append(toIndentedString(isShow)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    buttonIcon: ").append(toIndentedString(buttonIcon)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

