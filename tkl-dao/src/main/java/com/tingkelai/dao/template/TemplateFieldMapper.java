package com.tingkelai.dao.template;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tingkelai.domain.template.Template;
import com.tingkelai.domain.template.TemplateField;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态模板字段相关
 * 2018-12-17 10:52:03
 * @author liuzhengjie
 * @version 1.0
 */
@Mapper
public interface TemplateFieldMapper extends BaseMapper<TemplateField> {
    
}
