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
 * 公司
 * @author liuzhengjie
 * @date 2018-11-23 21:12:30
 * @version 1.0
 */
@TableName("tkl_sys_team")
@Mapper
public class Team  extends DataEntity<Long>{

  /**
   * 公司名
   */
  @TableField("name")
  private String name = null;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

