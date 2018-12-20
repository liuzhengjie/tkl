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

  /**
   * 菜单名
   */
  @TableField("name")
  private String name = null;

  /**
   * 菜单类型
   */
  @TableField("type")
  private String type = null;

  /**
   * 菜单url
   */
  @TableField("url")
  private String url = null;

  /**
   * 父级id
   */
  @TableField("parent_id")
  private Integer parentId = null;

  /**
   * 所有父级id构成的string
   */
  @TableField("parent_ids")
  private String parentIds = null;

  /**
   * 权限
   */
  @TableField("permission")
  private String permission = null;

  /**
   * 是否显示
   */
  @TableField("is_show")
  private String isShow = null;

  /**
   * 排序
   */
  @TableField("sort")
  private Integer sort = null;

  /**
   * 菜单图标
   */
  @TableField("menu_icon")
  private String menuIcon = null;

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

  public String getMenuIcon() {
    return menuIcon;
  }

  public void setMenuIcon(String menuIcon) {
    this.menuIcon = menuIcon;
  }
}

