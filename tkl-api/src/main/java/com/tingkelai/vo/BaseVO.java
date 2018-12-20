package com.tingkelai.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * vo接口，用来将web层对象和view层对象转换
 *
 */
public interface BaseVO<T, VO> extends Serializable{


    /**
     * 获取id
     */
    Long getId();

    /**
     * 设置teamId
     */
    void setTeamId(Long teamId);

    /**
     * 获取teamId
     */
    @ApiModelProperty(hidden = true)
    Long getTeamId();


    /**
     * 封装成业务需要的对象
     */
    T toDTO();

    /**
     * 封装成业务需要的对象
     */
    T toDTO(VO vo);

    /**
     * 封装成业务需要的对象
     */
    List<T> toDTO(List<VO> voList);

    /**
     * 封装成web需要的对象
     */
    VO toVO(T vo);

    /**
     * 封装成web需要的对象list
     */
    List<VO> toVO(List<T> list);
}
