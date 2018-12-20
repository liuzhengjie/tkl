package com.tingkelai.dao.dict;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.dict.DictItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典项
 */
@Mapper
public interface DictItemMapper extends BaseMapper<DictItem> {

}