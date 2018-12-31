package com.tingkelai.customer.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerUseRecordApi;
import com.tingkelai.api.product.ProductApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.UseRecord;
import com.tingkelai.domain.product.Product;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.UseRecordVO;
import com.tingkelai.vo.product.ProductVO;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 机器使用情况处理类
 * 2018-12-17 11:42:39
 * @author liuzhengjie
 * @version 1.0
 */
@RestController
public class CustomerUseRecordController extends BaseCRUDController<UseRecord, Long> implements CustomerUseRecordApi<UseRecordVO> {

    @Override
    public ResponseMessage<List<UseRecordVO>> useRecordListGet(UseRecordVO useRecordVO, BasePage basePage) {
        return list(useRecordVO, basePage);
    }

    @Override
    public ResponseMessage<UseRecordVO> useRecordGet(UseRecordVO useRecordVO) {
        return getEntity(useRecordVO);
    }

    @Override
    public ResponseMessage<UseRecordVO> useRecordPost(@Valid UseRecordVO useRecordVO) {
        return saveEntity(useRecordVO);
    }

    @Override
    public ResponseMessage<UseRecordVO> useRecordPut(@Valid UseRecordVO useRecordVO) {
        return updateEntity(useRecordVO);
    }

    @Override
    public ResponseMessage<UseRecordVO> useRecordDelete(UseRecordVO useRecordVO) {
        QueryWrapper<UseRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", useRecordVO.getId());
        return removeEntity(useRecordVO, queryWrapper);
    }
}
