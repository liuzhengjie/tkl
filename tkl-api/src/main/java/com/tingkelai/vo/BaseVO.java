package com.tingkelai.vo;

/**
 * vo接口，用来将web层对象和view层对象转换
 *
 */
public interface BaseVO<T, VO> {
    /**
     * 封装成业务需要的对象
     */
    T toDTO();

    /**
     * 封装成web需要的对象
     */
    VO toVO(T vo);
}
