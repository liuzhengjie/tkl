package com.tingkelai.dao.dict;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.dict.DictCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictGroupMapper extends BaseMapper<DictCategory> {


    /**
     * 根据code获取数据字典分组信息
     * @param code
     * @return
     */
    DictCategory getByCode(@Param("code") String code);
}