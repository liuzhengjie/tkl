package com.tingkelai.dict.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.sys.SysDictApi;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.service.dict.IDictGroupService;
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
public class DictGroupController extends BaseCRUDController<DictCategory, Long> implements SysDictApi<DictCategoryVO> {

    @Override
    public ResponseEntity sysDictCategoryListGet(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryDelete(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryGet(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryPost(@Valid DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryPut(@Valid DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemDelete(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryItemGet(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryItemListPost(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryItemPost(DictCategoryVO dictCategoryVO) {
        return null;
    }

    @Override
    public ResponseEntity sysDictCategoryItemPut(DictCategoryVO dictCategoryVO) {
        return null;
    }
}
