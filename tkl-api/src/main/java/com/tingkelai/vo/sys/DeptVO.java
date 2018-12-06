package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门
 * @author liuzhengjie
 * @date 2018-11-23 21:13:17
 * @version 1.0
 */
@ApiModel(description = "部门")
public class DeptVO implements BaseVO<Dept, DeptVO>{

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

  @JsonProperty("parentId")
  private Integer parentId = null;

  @JsonProperty("parentIds")
  private String parentIds = null;

  /**
   * 部门名称
   * @return name
  **/
  @ApiModelProperty(value = "部门名称", required = true)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeptVO parentId(Integer parentId) {
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

  public DeptVO parentIds(String parentIds) {
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

  /**
   * 封装成业务需要的对象
   */
  public Dept toDTO(){
    return toDTO(this);
  }

  @Override
  public Dept toDTO(DeptVO deptVO) {
    Dept dept = new Dept();
    dept.setId(deptVO.getId());
    dept.setName(deptVO.getName());
    dept.setParentId(deptVO.getParentId());
    dept.setParentIds(deptVO.getParentIds());
    return dept;
  }

  @Override
  public List<Dept> toDTO(List<DeptVO> voList) {
    List<Dept> list = new ArrayList<>();
    for(DeptVO temp : voList){
      list.add(temp.toDTO());
    }
    return list;
  }

  /**
   * 封装成web需要的对象
   */
  public DeptVO toVO(Dept dept){
    DeptVO deptVO = new DeptVO();
    deptVO.setId(dept.getId());
    deptVO.setName(dept.getName());
    deptVO.setParentId(dept.getParentId());
    deptVO.setParentIds(dept.getParentIds());
    return deptVO;
  }

  @Override
  public List<DeptVO> toVO(List<Dept> list) {
    List<DeptVO> resList = new ArrayList<>();
    for(Dept temp : list){
      resList.add(toVO(temp));
    }
    return resList;
  }
}

