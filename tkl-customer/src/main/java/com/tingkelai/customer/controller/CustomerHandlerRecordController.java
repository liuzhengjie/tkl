package com.tingkelai.customer.controller;

import com.tingkelai.api.controller.BaseCRUDController;
import com.tingkelai.api.customer.CustomerHandlerRecordApi;
import com.tingkelai.domain.ResponseMessage;
import com.tingkelai.domain.customer.HandlerRecord;
import com.tingkelai.vo.BasePage;
import com.tingkelai.vo.customer.HandlerRecordVO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户经手人变更记录处理类
 *
 * @author liuzhengjie
 * @date 2018-11-27 14:15:09
 * @version 1.0
 */
@RestController
public class CustomerHandlerRecordController extends BaseCRUDController<HandlerRecord, Long> implements CustomerHandlerRecordApi<HandlerRecordVO> {

    @Override
    public ResponseMessage<HandlerRecordVO> customerHandlerRecordDelete(HandlerRecordVO requestBody) {
        return deleteEntity(requestBody);
    }

    @Override
    public ResponseMessage<HandlerRecordVO> customerHandlerRecordGet(HandlerRecordVO requestBody) {
        return getEntity(requestBody);
    }

    @Override
    public ResponseMessage<List<HandlerRecordVO>> customerHandlerRecordListGet(HandlerRecordVO requestBody, BasePage basePage) {
        return list(requestBody, basePage);
    }

    @Override
    public ResponseMessage<HandlerRecordVO> customerHandlerRecordPost(HandlerRecordVO requestBody) {
        return saveEntity(requestBody);
    }

    @Override
    public ResponseMessage<HandlerRecordVO> customerHandlerRecordPut(HandlerRecordVO requestBody) {
        return updateEntity(requestBody);
    }
}
