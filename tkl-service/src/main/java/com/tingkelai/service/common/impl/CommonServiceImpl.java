package com.tingkelai.service.common.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingkelai.service.common.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 通用service处理类
 *
 * @author liuzhengjie
 * @date 2018-11-29 10:16:45
 * @version 1.0
 * @param <T> domain类
 */
@Transactional
public class CommonServiceImpl<T> extends ServiceImpl<BaseMapper<T>, T> implements ICommonService<T>{

    @Override
    public boolean saveBatch(Collection<T> collection, int i) {
        return super.saveBatch(collection, i);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList) {
        return super.saveBatch(entityList);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> collection, int i) {
        return super.saveOrUpdateBatch(collection, i);
    }

    @Override
    public boolean removeById(Serializable serializable) {
        return super.removeById(serializable);
    }

    @Override
    public boolean removeByMap(Map<String, Object> map) {
        return super.removeByMap(map);
    }

    @Override
    public boolean remove(Wrapper<T> wrapper) {
        return super.remove(wrapper);
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> collection) {
        return super.removeByIds(collection);
    }

    @Override
    public boolean updateById(T t) {
        return super.updateById(t);
    }

    @Override
    public boolean update(T t, Wrapper<T> wrapper) {
        return super.update(t, wrapper);
    }

    @Override
    public boolean updateBatchById(Collection<T> collection, int i) {
        return super.updateBatchById(collection, i);
    }

    @Override
    public boolean saveOrUpdate(T t) {
        return super.saveOrUpdate(t);
    }

    @Override
    public T getById(Serializable serializable) {
        return super.getById(serializable);
    }

    @Override
    public Collection<T> listByIds(Collection<? extends Serializable> collection) {
        return super.listByIds(collection);
    }

    @Override
    public Collection<T> listByMap(Map<String, Object> map) {
        return super.listByMap(map);
    }

    @Override
    public T getOne(Wrapper<T> wrapper, boolean b) {
        return super.getOne(wrapper, b);
    }

    @Override
    public Map<String, Object> getMap(Wrapper<T> wrapper) {
        return super.getMap(wrapper);
    }

    @Override
    public int count(Wrapper<T> wrapper) {
        return super.count(wrapper);
    }

    @Override
    public List<T> list() {
        return super.list(Wrappers.emptyWrapper());
    }

    @Override
    public List<T> list(Wrapper<T> wrapper) {
        return super.list(wrapper);
    }

    @Override
    public IPage<T> page(IPage<T> iPage, Wrapper<T> wrapper) {
        return super.page(iPage, wrapper);
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<T> wrapper) {
        return super.listMaps(wrapper);
    }

    @Override
    public List<Object> listObjs(Wrapper<T> wrapper) {
        return super.listObjs(wrapper);
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<T> iPage, Wrapper<T> wrapper) {
        return super.pageMaps(iPage, wrapper);
    }
}