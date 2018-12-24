package com.tingkelai.dict.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.dict.DictGroupApi;
import com.tingkelai.api.dict.DictItemApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.dict.DictCategory;
import com.tingkelai.domain.dict.DictItem;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.dict.DictCategoryVO;
import com.tingkelai.vo.dict.DictItemVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 数据字典处理类()
 *
 * @author liuzhengjie
 * @date 2018-11-26 20:32:49
 * @version 1.0
 */
@RestController
public class DictItemController extends BaseCRUDController<DictItem, Long> implements DictItemApi<DictItemVO> {

    @Override
    public ResponseMessage<List<DictItemVO>> dictItemListGet(DictItemVO dictItemVO, BasePage basePage) {
        return list(dictItemVO, basePage);
    }

    @Override
    public ResponseMessage<DictItemVO> dictItemGet(DictItemVO dictItemVO) {
        return getEntity(dictItemVO);
    }

    @Override
    public ResponseMessage<DictItemVO> dictItemPost(@Valid DictItemVO dictItemVO) {
        return saveEntity(dictItemVO);
    }

    @Override
    public ResponseMessage<DictItemVO> dictItemPut(@Valid DictItemVO dictItemVO) {
        return updateEntity(dictItemVO);
    }

    @Override
    public ResponseMessage<DictItemVO> dictItemDelete(DictItemVO dictItemVO) {
        return deleteEntity(dictItemVO);
    }
}
