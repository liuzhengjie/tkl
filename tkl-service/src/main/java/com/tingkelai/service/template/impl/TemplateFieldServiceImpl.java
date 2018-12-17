package com.tingkelai.service.template.impl;

import com.tingkelai.domain.template.TemplateField;
import com.tingkelai.service.common.impl.CommonServiceImpl;
import com.tingkelai.service.template.ITemplateFieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 动态模板字段相关
 *
 * 2018-12-17 10:55:22
 * @author liuzhengjie
 * @version 1.0
 */
@Transactional
@Service("templateFieldService")
public class TemplateFieldServiceImpl extends CommonServiceImpl<TemplateField> implements ITemplateFieldService {

}
