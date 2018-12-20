package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Menu;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单
 *
 * 2018-11-23 21:12:55
 * @author liuzhengjie
 * @version 1.0
 */
@ApiModel(description = "菜单")
public class MenuVO implements BaseVO<Menu, MenuVO>{

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

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("parentId")
  private Integer parentId = null;

  @JsonProperty("parentIds")
  private String parentIds = null;

  @JsonProperty("permission")
  private String permission = null;

  @JsonProperty("isShow")
  private String isShow = null;

  @JsonProperty("sort")
  private Integer sort = null;

  @JsonProperty("menuIcon")
  private String menuIcon = null;

  /**
   * 菜单名
   * @return name
  **/
  @ApiModelProperty(value = "菜单名", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 菜单类型
   * @return type
  **/
  @ApiModelProperty(value = "菜单类型", required = true)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  /**
   * 菜单类型
   * @return url
  **/
  @ApiModelProperty(value = "菜单类型", required = true)
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
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

  /**
   * 权限
   * @return permission
  **/
  @ApiModelProperty(value = "权限", required = true)
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

  /**
   * 封装成业务需要的对象
   */
  public Menu toDTO(){
    return toDTO(this);
  }

  @Override
  public Menu toDTO(MenuVO menuVO) {
    Menu menu = new Menu();
    menu.setId(menuVO.getId());
    menu.setMenuIcon(menuVO.getMenuIcon());
    menu.setName(menuVO.getName());
    menu.setParentId(menuVO.getParentId());
    menu.setParentIds(menuVO.getParentIds());
    menu.setPermission(menuVO.getPermission());
    menu.setSort(menuVO.getSort());
    menu.setType(menuVO.getType());
    menu.setUrl(menuVO.getUrl());
    return menu;
  }

  @Override
  public List<Menu> toDTO(List<MenuVO> voList) {
    List<Menu> list = new ArrayList<>();
    for(MenuVO temp : voList){
      list.add(temp.toDTO());
    }
    return list;
  }

  /**
   * 封装成web需要的对象
   */
  public MenuVO toVO(Menu menu){
    MenuVO menuVO = new MenuVO();
    menuVO.setId(menu.getId());
    menuVO.setMenuIcon(menu.getMenuIcon());
    menuVO.setName(menu.getName());
    menuVO.setParentId(menu.getParentId());
    menuVO.setParentIds(menu.getParentIds());
    menuVO.setPermission(menu.getPermission());
    menuVO.setSort(menu.getSort());
    menuVO.setType(menu.getType());
    menuVO.setUrl(menu.getUrl());
    return menuVO;
  }

  @Override
  public List<MenuVO> toVO(List<Menu> list) {
    List<MenuVO> resList = new ArrayList<>();
    for(Menu temp : list){
      resList.add(toVO(temp));
    }
    return resList;
  }
}

