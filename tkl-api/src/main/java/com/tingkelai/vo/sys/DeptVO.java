package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Dept;
import com.tingkelai.domain.sys.Team;
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

  public DeptVO(){}

  public DeptVO(Dept dept){
    setId(dept.getId());
    setName(dept.getName());
    setParentId(dept.getParentId());
    setParentIds(dept.getParentIds());
    setRemarks(dept.getRemarks());
  }

  @JsonProperty("id")
  @ApiModelProperty(name = "id", value = "id")
  private Long id = null;

  @JsonProperty("teamId")
  @ApiModelProperty(name = "teamId", value = "teamId")
  private Long teamId = null;

  @ApiModelProperty(value = "部门名称")
  @JsonProperty("name")
  private String name = null;

  @ApiModelProperty(value = "父部门id")
  @JsonProperty("parentId")
  private Integer parentId = null;

  @ApiModelProperty(value = "所有父部门id拼成的string")
  @JsonProperty("parentIds")
  private String parentIds = null;

  @JsonProperty("remarks")
  @ApiModelProperty(name = "备注", value = "remarks")
  private String remarks;

  public Long getId() {
    return id;
  }

  @Override
  public void setTeamId(Long teamId) {
    this.teamId = teamId;
  }

  @Override
  public Long getTeamId() {
    return teamId;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public void setId(Long id) {
    this.id = id;
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
    dept.setTeamId(deptVO.getTeamId());
    dept.setRemarks(deptVO.getRemarks());
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
    return new DeptVO(dept);
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

