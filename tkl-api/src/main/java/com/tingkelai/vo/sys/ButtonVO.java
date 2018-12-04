package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Button;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 按钮
 * @author liuzhengjie
 * @date 2018-11-23 21:13:39
 * @version 1.0
 */
@ApiModel(description = "按钮")
public class ButtonVO implements BaseVO<Button, ButtonVO>{

  @JsonProperty("id")
  private Long id = null;

  @ApiModelProperty(name = "id", value = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("permission")
  private String permission = null;

  @JsonProperty("isShow")
  private String isShow = null;

  @JsonProperty("sort")
  private Integer sort = null;

  @JsonProperty("buttonIcon")
  private String buttonIcon = null;

  /**
   * 按钮名
   * @return name
  **/
  @ApiModelProperty(value = "按钮名", name = "name11", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  /**
   * 封装成业务需要的对象
   */
  public Button toDTO(){
    Button button = new Button();
    button.setButtonIcon(getButtonIcon());
    button.setId(getId());
    button.setName(getName());
    button.setPermission(getPermission());
    button.setSort(getSort());
    button.setType(getType());
    return button;
  }

  /**
   * 封装成web需要的对象
   */
  public ButtonVO toVO(Button button){
    return null;
  }
}

