package com.tingkelai.dao.dict;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.dict.DictCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictGroupMapper extends BaseMapper<DictCategory> {

}