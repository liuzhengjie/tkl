package com.tingkelai.vo.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tingkelai.domain.sys.Team;
import com.tingkelai.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公司
 * @author liuzhengjie
 * @date 2018-11-23 21:12:30
 * @version 1.0
 */
@ApiModel(description = "公司")
public class TeamVO implements BaseVO<Team, TeamVO>{

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

  /**
   * 公司名
   * @return name
  **/
  @ApiModelProperty(value = "公司名")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 封装成业务需要的对象
   */
  public Team toDTO(){
    Team team = new Team();
    team.setId(getId());
    team.setName(getName());
    return team;
  }

  /**
   * 封装成web需要的对象
   */
  public TeamVO toVO(Team team){
    return null;
  }

}

