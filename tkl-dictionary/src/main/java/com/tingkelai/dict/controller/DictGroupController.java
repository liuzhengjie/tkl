package com.tingkelai.dict.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.dict.DictGroupApi;
import com.tingkelai.api.sys.SysDictApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.service.dict.IDictGroupService;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.dict.DictCategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据字典处理类
 *
 * @author liuzhengjie
 * @date 2018-11-26 20:32:49
 * @version 1.0
 */
@RestController
public class DictGroupController extends BaseCRUDController<DictCategory, Long> implements DictGroupApi<DictCategoryVO> {

    @Override
    public ResponseMessage<List<DictCategoryVO>> dictGroupListGet(DictCategoryVO dictCategoryVO, BasePage basePage) {
        return list(dictCategoryVO, basePage);
    }

    @Override
    public ResponseMessage<DictCategoryVO> dictGroupGet(DictCategoryVO dictCategoryVO) {
        return getEntity(dictCategoryVO);
    }

    @Override
    public ResponseMessage<DictCategoryVO> dictGroupPost(@Valid DictCategoryVO dictCategoryVO) {
        return saveEntity(dictCategoryVO);
    }

    @Override
    public ResponseMessage<DictCategoryVO> dictGroupPut(@Valid DictCategoryVO dictCategoryVO) {
        return updateEntity(dictCategoryVO);
    }

    @Override
    public ResponseMessage<DictCategoryVO> dictGroupDelete(DictCategoryVO dictCategoryVO) {
        return deleteEntity(dictCategoryVO);
    }
}
