package com.tingkelai.template;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.template.TemplateApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.template.Template;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.template.TemplateVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 动态模板处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class TemplateController extends BaseCRUDController<Template, Long> implements TemplateApi<TemplateVO> {

    @Override
    public ResponseMessage<List<TemplateVO>> templateListGet(TemplateVO templateVO, BasePage basePage) {
        QueryWrapper<Template> queryWrapper = new QueryWrapper<>();
        queryWrapper.setEntity(templateVO.toDTO());
        return list(templateVO, templateVO.toDTO(), queryWrapper, basePage);
    }

    @Override
    public ResponseMessage templateGet(TemplateVO templateVO) {
        return getEntity(templateVO);
    }

    @Override
    public ResponseMessage templatePost(@Valid TemplateVO templateVO) {
        return saveEntity(templateVO);
    }

    @Override
    public ResponseMessage templatePut(@Valid TemplateVO templateVO) {
        return updateEntity(templateVO);
    }

    @Override
    public ResponseMessage templateDelete(TemplateVO templateVO) {
        return deleteEntity(templateVO);
    }
}
