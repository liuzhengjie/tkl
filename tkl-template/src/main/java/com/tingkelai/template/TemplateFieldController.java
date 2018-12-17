package com.tingkelai.template;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.template.TemplateFieldApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.template.TemplateField;
import com.tingkelai.vo.template.TemplateFieldVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 动态模板字段处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class TemplateFieldController extends BaseCRUDController<TemplateField, Long> implements TemplateFieldApi<TemplateFieldVO> {


    @Override
    public ResponseMessage templateFieldListGet(TemplateFieldVO templateFieldVO) {
        return getEntityList(templateFieldVO);
    }

    @Override
    public ResponseMessage templateFieldGet(TemplateFieldVO templateFieldVO) {
        return getEntity(templateFieldVO);
    }

    @Override
    public ResponseMessage templateFieldPost(@Valid TemplateFieldVO templateFieldVO) {
        return saveEntity(templateFieldVO);
    }

    @Override
    public ResponseMessage templateFieldPut(@Valid TemplateFieldVO templateFieldVO) {
        return updateEntity(templateFieldVO);
    }

    @Override
    public ResponseMessage templateFieldDelete(@Valid TemplateFieldVO templateFieldVO) {
        return deleteEntity(templateFieldVO);
    }
}
