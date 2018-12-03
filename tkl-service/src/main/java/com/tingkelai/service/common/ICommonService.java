package com.tingkelai.service.common;

import java.io.Serializable;
import java.util.List;

/**
 * 通用service
 * @author liuzhengjie
 * @date 2018-11-26 17:08:05
 * @version 1.0
 */
public interface ICommonService<T>{

    /** 获取列表信息，不带分页查询等功能 */
    List<T> list();

    /** C 保存对象信息 */
    boolean save(T t);

    /** R 根据id删除对象*/
    boolean removeById(Serializable serializable);

    /** U 更新或保存，更新有变化的字段 */
    boolean saveOrUpdate(T t);

    /** D 根据id获取对象 */
    T getById(Serializable serializable);
}