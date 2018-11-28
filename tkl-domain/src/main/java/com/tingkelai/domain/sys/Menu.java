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
 * 菜单
 * @author liuzhengjie
 * @date 2018-11-23 21:12:55
 * @version 1.0
 */
@ApiModel(description = "菜单")
@TableName("tkl_sys_menu")
@Mapper
public class Menu  extends DataEntity<Long> {
  @JsonProperty("name")
  @TableField("name")
  private String name = null;

  @JsonProperty("type")
  @TableField("type")
  private String type = null;

  @JsonProperty("url")
  @TableField("url")
  private String url = null;

  @JsonProperty("parentId")
  @TableField("parent_id")
  private Integer parentId = null;

  @JsonProperty("parentIds")
  @TableField("parent_ids")
  private String parentIds = null;

  @JsonProperty("permission")
  @TableField("permission")
  private String permission = null;

  @JsonProperty("isShow")
  @TableField("is_show")
  private String isShow = null;

  @JsonProperty("sort")
  @TableField("sort")
  private Integer sort = null;

  @JsonProperty("menuIcon")
  @TableField("menu_icon")
  private String menuIcon = null;

  /**
   * 菜单名
   * @return name
  **/
  @ApiModelProperty(value = "菜单名")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Menu type(String type) {
    this.type = type;
    return this;
  }

  /**
   * 菜单类型
   * @return type
  **/
  @ApiModelProperty(value = "菜单类型")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Menu url(String url) {
    this.url = url;
    return this;
  }

  /**
   * 菜单类型
   * @return url
  **/
  @ApiModelProperty(value = "菜单类型")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Menu parentId(Integer parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * 父级id
   * @return parentId
  **/
  @ApiModelProperty(value = "父级id")


  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Menu parentIds(String parentIds) {
    this.parentIds = parentIds;
    return this;
  }

  /**
   * 所有父级id构成的string
   * @return parentIds
  **/
  @ApiModelProperty(value = "所有父级id构成的string")


  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
  }

  public Menu permission(String permission) {
    this.permission = permission;
    return this;
  }

  /**
   * 权限
   * @return permission
  **/
  @ApiModelProperty(value = "权限")


  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

  public Menu isShow(String isShow) {
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

  public Menu sort(Integer sort) {
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

  public Menu menuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
    return this;
  }

  /**
   * 菜单图标
   * @return menuIcon
  **/
  @ApiModelProperty(value = "菜单图标")


  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Menu menu = (Menu) o;
    return Objects.equals(this.name, menu.name) &&
        Objects.equals(this.type, menu.type) &&
        Objects.equals(this.url, menu.url) &&
        Objects.equals(this.parentId, menu.parentId) &&
        Objects.equals(this.parentIds, menu.parentIds) &&
        Objects.equals(this.permission, menu.permission) &&
        Objects.equals(this.isShow, menu.isShow) &&
        Objects.equals(this.sort, menu.sort) &&
        Objects.equals(this.menuIcon, menu.menuIcon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, url, parentId, parentIds, permission, isShow, sort, menuIcon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Menu {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    parentIds: ").append(toIndentedString(parentIds)).append("\n");
    sb.append("    permission: ").append(toIndentedString(permission)).append("\n");
    sb.append("    isShow: ").append(toIndentedString(isShow)).append("\n");
    sb.append("    sort: ").append(toIndentedString(sort)).append("\n");
    sb.append("    menuIcon: ").append(toIndentedString(menuIcon)).append("\n");
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

