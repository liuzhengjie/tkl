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


  /**
   * 按钮名
   */
  @TableField("name")
  private String name = null;

  /**
   * 按钮类型
   */
  @TableField("type")
  private String type = null;

  /**
   * 按钮权限
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
   **/
  @TableField("sort")
  private Integer sort = null;

  /**
   * 按钮图标
   */
  @TableField("button_icon")
  private String buttonIcon = null;

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

  public String getButtonIcon() {
    return buttonIcon;
  }

  public void setButtonIcon(String buttonIcon) {
    this.buttonIcon = buttonIcon;
  }
}

