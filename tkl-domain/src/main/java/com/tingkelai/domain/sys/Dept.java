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
 * 部门
 * @author liuzhengjie
 * @date 2018-11-23 21:13:17
 * @version 1.0
 */
@TableName("tkl_sys_dept")
@Mapper
public class Dept extends DataEntity<Long> {
  /**
   * 部门名称
   **/
  @TableField("name")
  private String name = null;

  /**
   * 父部门id
   **/
  @TableField("parent_id")
  private Integer parentId = null;

  /**
   * 所有父部门id拼成的string
   * @return parentIds
   **/
  @TableField("parent_ids")
  private String parentIds = null;

  /** 所属公司id */
  @TableField("team_id")
  private Long teamId;

  /** 部门类型 */
  @TableField("type")
  private String type;

  public Long getTeamId() {
    return teamId;
  }

  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}

