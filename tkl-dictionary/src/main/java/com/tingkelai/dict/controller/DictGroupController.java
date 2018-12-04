package com.tingkelai.dict.controller;

import com.tingkelai.api.sys.SysDictApi;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.service.dict.IDictGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
public class DictGroupController implements SysDictApi<DictCategory> {

    @Override
    public List<DictCategory> sysDictCategoryListGet() {
        return null;
    }

    @Override
    public Map<String, String> sysDictCategoryDelete() {
        return null;
    }

    @Override
    public DictCategory sysDictCategoryGet() {
        return null;
    }

    @Override
    public Map<String, String> sysDictCategoryPost(DictCategory body) {
        return null;
    }

    @Override
    public Map<String, String> sysDictCategoryPut(DictCategory body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemDelete(DictCategory body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemGet(DictCategory body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemListPost(DictCategory body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemPost(DictCategory body) {
        return null;
    }

    @Override
    public ResponseEntity<Void> sysDictCategoryItemPut(DictCategory body) {
        return null;
    }
}
