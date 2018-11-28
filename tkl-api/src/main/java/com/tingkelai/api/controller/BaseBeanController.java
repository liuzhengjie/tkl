package com.tingkelai.api.controller;

import com.tingkelai.util.ReflectionUtils;

import java.io.Serializable;

/**
 * 通用controller，用来加载bean
 * @author liuzhengjie
 * @date 2018-11-28 12:15:22
 * @version 1.0
 */
public class BaseBeanController <Entity extends Serializable> extends BaseController{

    /**
     * 实体类型
     */
    protected final Class<Entity> entityClass;

    protected BaseBeanController() {
        this.entityClass = ReflectionUtils.getSuperGenericType(getClass());
    }

    protected Entity newModel() {
        try {
            return entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("can not instantiated model : " + this.entityClass, e);
        }
    }
}
