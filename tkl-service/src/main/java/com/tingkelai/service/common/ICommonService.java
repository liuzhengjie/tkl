package com.tingkelai.service.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    /** R 根据条件删除对象 */
    boolean remove(Wrapper<T> wrapper);

    /** U 更新或保存，更新有变化的字段 */
    boolean saveOrUpdate(T t);

    /**  根据id获取对象 */
    T getById(Serializable serializable);

    /** 根据条件获取对象 */
    T getOne(Wrapper<T> var1);

    /** 通过条件获取分页列表 */
    IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
}