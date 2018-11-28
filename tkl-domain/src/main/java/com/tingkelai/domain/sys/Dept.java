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
@ApiModel(description = "部门")
@TableName("tkl_sys_dept")
@Mapper
public class Dept extends DataEntity<Long> {
  @JsonProperty("name")
  @TableField("name")
  private String name = null;

  @JsonProperty("parentId")
  @TableField("parent_id")
  private Integer parentId = null;

  @JsonProperty("parentIds")
  @TableField("parent_ids")
  private String parentIds = null;

  /**
   * 部门名称
   * @return name
  **/
  @ApiModelProperty(value = "部门名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Dept parentId(Integer parentId) {
    this.parentId = parentId;
    return this;
  }

  /**
   * 父部门id
   * @return parentId
  **/
  @ApiModelProperty(value = "父部门id")


  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public Dept parentIds(String parentIds) {
    this.parentIds = parentIds;
    return this;
  }

  /**
   * 所有父部门id拼成的string
   * @return parentIds
  **/
  @ApiModelProperty(value = "所有父部门id拼成的string")


  public String getParentIds() {
    return parentIds;
  }

  public void setParentIds(String parentIds) {
    this.parentIds = parentIds;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Dept dept = (Dept) o;
    return Objects.equals(this.name, dept.name) &&
        Objects.equals(this.parentId, dept.parentId) &&
        Objects.equals(this.parentIds, dept.parentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, parentId, parentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dept {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    parentIds: ").append(toIndentedString(parentIds)).append("\n");
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

